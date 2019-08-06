package me.jastz.common.china.district;

import com.google.common.collect.Lists;
import me.jastz.common.china.district.vo.Item;
import me.jastz.common.json.JsonUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProvinceHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    public static String chineseDistrictUrl = "http://xzqh.mca.gov.cn/map";
    public static String queryUrl = "http://xzqh.mca.gov.cn/defaultQuery?shengji=%s&diji=%s&xianji=%s";

    /**
     * 获取省级城市
     *
     * @return
     */
    public static List<City> getShenjiList() {
        List<City> provinces = Lists.newArrayList();
        try {
            Document doc = Jsoup.connect(chineseDistrictUrl).get();
            Elements elements = doc.select("select[name='shengji']");
//            System.out.println(elements);
            Elements script = doc.select("script");
            Element element = script.get(4);
//            System.out.println(element);
            String jsonVar = element.data().toString().split(";")[0];
//            System.out.println(jsonVar);
            String[] arr = jsonVar.split(" ");
            String jsonStr = arr[arr.length - 1];
//            System.out.println(jsonStr);
            //  将JSON转化成Java对象
            Item[] itemArray = JsonUtil.jsonToObject(jsonStr, Item[].class);
            for (Item item : itemArray) {
                provinces.add(new City(item.getShengji(), item.getQuHuaDaiMa()));
            }
//            System.out.println(JsonUtil.objectToPrettyJson(provinces));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return provinces;
    }

    /**
     * 获取地级城市
     *
     * @param shenji
     * @return
     */
    public static List<City> getDiji(String shenji) {
        List<City> prefectures = Lists.newArrayList();
        try {
            Document doc = Jsoup.connect(String.format(queryUrl, getUrlEncode(shenji), "-1", "-1")).get();
            Elements elements = doc.select("table.info_table").select("tr").select(".shi_nub");
            String 地名, 驻地, 行政区划代码, 区号, 邮编;
            BigDecimal 市级人口, 市级面积;
            City shiCity, xianCity;
            List<City> xianCities;
            for (Element shi : elements) {
                地名 = shi.select("td").get(0).text().substring(1).replace("</td>", "");
                驻地 = shi.select("td").get(1).text().replace("</td>", "");
                市级人口 = "".equals(shi.select("td").get(2).text().replace("</td>", "")
                        .replace("☆", ""))
                        ? null : new BigDecimal(shi.select("td").get(2).text().replace("</td>", "").replace("☆", ""))
                ;
                市级面积 = "".equals(shi.select("td").get(3).text().replace("</td>", "")
                        .replace("☆", ""))
                        ? null : new BigDecimal(shi.select("td").get(3).text().replace("</td>", "").replace("☆", ""))
                ;


                行政区划代码 = shi.select("td").get(4).text().replace("</td>", "");
                区号 = shi.select("td").get(5).text().replace("</td>", "");
                邮编 = shi.select("td").get(6).text().replace("</td>", "");
                shiCity = new City(地名, 驻地, 市级人口, 市级面积, 行政区划代码, 区号, 邮编);
                xianCities = Lists.newArrayList();
                Elements xians = doc.select("table.info_table").select("tr[type=2][parent=" + 地名 + "]");
                for (Element xian : xians) {
                    BigDecimal 县级人口, 县级面积;
                    Elements td = xian.select("td");
                    if (td.size() == 0) {
                        td = xian.select("th");
                    }
                    地名 = td.get(0).text().replace("</td>", "");
                    驻地 = td.get(1).text().replace("</td>", "");
                    县级人口 = "".equals(td.select("td").get(2).text().replace("</td>", "")
                            .replace("☆", ""))
                            ? null : new BigDecimal(td.select("td").get(2).text().replace("</td>", "").replace("☆", ""))
                    ;
                    县级面积 = "".equals(td.select("td").get(3).text().replace("</td>", "")
                            .replace("☆", ""))
                            ? null : new BigDecimal(td.select("td").get(3).text().replace("</td>", "").replace("☆", ""))
                    ;

                    行政区划代码 = td.get(4).text().replace("</td>", "");
                    区号 = td.get(5).text().replace("</td>", "");
                    邮编 = td.get(6).text().replace("</td>", "");
                    xianCities.add(new City(地名, 驻地, 县级人口, 县级面积, 行政区划代码, 区号, 邮编, Lists.newArrayList()));
                }
                shiCity.setChildren(xianCities);
                prefectures.add(shiCity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(JsonUtil.objectToPrettyJson(prefectures));
        return prefectures;
    }

    private static String getUrlEncode(String str) {
        try {
            return URLEncoder.encode(str, "gb2312");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<City> mulitThread() {
        long start = System.currentTimeMillis();
        List<City> cityList = Lists.newArrayList();
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            List<Future<City>> futures = Lists.newArrayList();
            for (City city : getShenjiList()) {
                futures.add(executorService.submit(new DijiThread(city)));
            }

            executorService.shutdown();

            while (true) {
                if (executorService.isTerminated()) {
                    for (Future<City> item : futures) {
                        cityList.add(item.get());
                    }
                    System.out.println(JsonUtil.objectToPrettyJson(cityList));
                    break;
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("任务全部执行完毕,消耗时间：%s ms", (end - start)));
        }
        return cityList;
    }

    private static List<City> singleThread() {
        long start = System.currentTimeMillis();
        List<City> cityList = Lists.newArrayList();
        for (City city : getShenjiList()) {
            city.setChildren(getDiji(city.getName()));
            cityList.add(city);
        }
        long end = System.currentTimeMillis();
        System.out.println(JsonUtil.objectToPrettyJson(cityList));
        System.out.println(String.format("任务全部执行完毕,消耗时间：%s ms", (end - start)));
        return cityList;
    }

    public static List<City> getAllCity() {
        return mulitThread();
    }


    public static void main(String[] args) {
//        singleThread();//任务全部执行完毕,消耗时间：34472 ms
//        mulitThread();//任务全部执行完毕,消耗时间：13331 ms
        System.out.println(JsonUtil.objectToPrettyJson(getDiji("北京市(京)")));
    }


}
