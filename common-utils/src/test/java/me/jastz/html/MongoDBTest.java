package me.jastz.html;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

/**
 * @author zhiwen
 */
public class MongoDBTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void manual() {
        String url = "https://docs.mongodb.com/manual/";
        try {
            Document document = Jsoup.connect(url).get();
//            logger.info(document.html());
            Elements elements = document.select(".sphinxsidebar");
            if (elements.size() == 1) {
                Element sphinxsidebar = elements.get(0);
                Element ul = sphinxsidebar.select("ul").get(1);
                List<MongoDBDocument> mongoDBDocuments = getTitleFormUL(ul);
//                logger.info(JsonUtil.objectToPrettyJson(mongoDBDocuments));
                createFolder(createFolder("E:\\mongodb", mongoDBDocuments));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<MongoDBDocument> getTitleFormUL(Element element) {
        List<MongoDBDocument> mongoDBDocuments = Lists.newArrayList();
        if (element.is("ul")) {
            Elements children = element.children();
            children.forEach(li -> {
                if (li.is("li")) {
                    MongoDBDocument mongoDBDocument = new MongoDBDocument();
                    Element a = li.select("a").first();
                    mongoDBDocument.setUrl(String.format("https://docs.mongodb.com/manual/%s", a.attr("href")));
                    mongoDBDocument.setTitle(a.html());
                    Element ul;
                    if (li.children().size() == 2 && (ul = li.children().get(1)).is("ul")) {
                        mongoDBDocument.setSubList(getTitleFormUL(ul));
                    }
                    mongoDBDocuments.add(mongoDBDocument);
                }
            });
        }
        return mongoDBDocuments;
    }

    /**
     * 生成目录结构String
     *
     * @param folder
     * @param dbDocumentList
     * @return
     */
    public Set<String> createFolder(String folder, List<MongoDBDocument> dbDocumentList) {
        Set<String> folders = Sets.newLinkedHashSet();
        if (CollectionUtils.isEmpty(dbDocumentList) == false) {
            dbDocumentList.forEach(mongoDBDocument -> {
                String temp = String.format("%s%s%s", folder, File.separator, mongoDBDocument.getTitle().replace(" ", "-").replace("<code-class=\"docutils-literal\"><span-class=\"pre\">", "").replace("</span></code>", "").replace("\"", "“").replace(":", "："));
                folders.add(temp);
                folders.addAll(createFolder(temp, mongoDBDocument.getSubList()));
            });

        }
        return folders;
    }

    public void createFolder(Set<String> folderSet) {
        for (String folder : folderSet) {
            try {
                Files.createDirectories(Paths.get(folder));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

    }
}
