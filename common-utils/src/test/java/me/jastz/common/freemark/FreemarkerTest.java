package me.jastz.common.freemark;

import freemarker.template.TemplateException;
import me.jastz.common.freemarker.Freemarkers;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhiwen on 2017/1/24.
 */
public class FreemarkerTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void renderString() {
        String templateString = "src/main/java/${packageName}/${moduleName}/web/${subModuleName}";
        Map<String, String> model = new HashMap();
        model.put("packageName", "me,jastz");
        model.put("moduleName", "site");
        model.put("subModuleName", "article");
        String actualString = "src/main/java/me,jastz/site/web/article";
        try {
            Assert.assertEquals(actualString, Freemarkers.renderString(templateString, model));
            logger.info("success");
        } catch (IOException e) {
            logger.error("IOException", e);
        } catch (TemplateException e) {
            logger.error("TemplateException", e);
        }
    }
}
