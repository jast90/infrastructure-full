package me.jastz.common.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

/**
 * Freemarker 工具类
 * <p>
 * Created by zhiwen on 2017/1/24.
 */
public class Freemarkers {

    /**
     * 渲染模板字符串
     *
     * @param templateString
     * @param model
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public static String renderString(String templateString, Map<String, ?> model) throws IOException, TemplateException {
        try {
            StringWriter writer = new StringWriter();
            Template template = new Template("name", new StringReader(templateString), new Configuration(Configuration.VERSION_2_3_23));
            template.process(model, writer);
            return writer.toString();
        } catch (IOException e) {
            throw e;
        } catch (TemplateException e) {
            throw e;
        }
    }
}
