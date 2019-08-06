package me.jastz.https;

import me.jastz.common.http.HttpsUtil;
import me.jastz.https.entity.TicketLeftResponse;
import org.junit.Ignore;
import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by zhiwen on 2017/2/20.
 */
@Ignore
public class HttpsTest {

    @Test
    public void test12306() throws Exception {
        URL url = new URL("http://kyfw.12306.cn/otn/leftTicket/queryX?leftTicketDTO.train_date=2017-02-22&leftTicketDTO.from_station=SZQ&leftTicketDTO.to_station=SRG&purpose_codes=ADULT");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        conn.setSSLSocketFactory(HttpsUtil.getSSLSocketFactory());
        conn.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String input;
        while ((input = br.readLine()) != null)
            System.out.println(input);

    }

    @Test
    public void test() throws Exception {
        System.out.println(HttpsUtil.getForObject(TicketLeftResponse.class, getUrl()));
    }

    private String getUrl() {
        return "http://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2017-03-10&leftTicketDTO.from_station=SZQ&leftTicketDTO.to_station=SRG&purpose_codes=ADULT";
    }
}

//https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2017-02-22&leftTicketDTO.from_station=SZQ&leftTicketDTO.to_station=SRG&purpose_codes=ADULT
//https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2017-03-10&leftTicketDTO.from_station=SZQ&leftTicketDTO.to_station=SRG&purpose_codes=ADULT