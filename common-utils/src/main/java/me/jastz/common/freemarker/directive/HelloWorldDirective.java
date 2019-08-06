package me.jastz.common.freemarker.directive;

import freemarker.core.Environment;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * ftl中的调用方式是<@hello content="Hello Wolrd!"></@hello>(注：hello是自己配置的)
 * <p>
 * Created by zhiwen on 2017/2/9.
 */
public class HelloWorldDirective implements TemplateDirectiveModel {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws TemplateException, IOException {
        if (params.isEmpty()) {
            throw new TemplateModelException(
                    "This directive need parameters.");
        }
        String text = "";
        if (params.get("content") != null) {
            text = ((SimpleScalar) params.get("content")).getAsString();
        }
        env.setVariable("key", env.getObjectWrapper().wrap(text));

        if (body != null) {
            body.render(env.getOut());
        } else {
            env.getOut().write(text);
        }
    }
}
