package cn.jastz.mall.config;

import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import me.jastz.common.freemarker.directive.PageDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zhiwen
 */
@Component
public class FreemarkerConfig {

    @Autowired
    private Configuration configuration;

    @PostConstruct
    public void setSharedVariable() throws TemplateModelException {
        configuration.setSharedVariable("pagination", new PageDirective());
    }
}
