# common-utils

## freemarker分页插件使用方式
1. freemarker 自定义指令配置
```java
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import me.jastz.common.freemarker.directive.HelloWorldDirective;
import me.jastz.common.freemarker.directive.PageDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FreemarkerConfig {

    @Autowired
    private Configuration configuration;

    @PostConstruct
    public void setSharedVariable() throws TemplateModelException {
        configuration.setSharedVariable("pagination", new PageDirective());
        configuration.setSharedVariable("hello", new HelloWorldDirective());
    }
}

```
2. ftl中使用pagination
```html
<@pagination modelName="page"></@pagination>
```
modelName 是 Srpring MVC Controller `model.addAttribute("page", page);`中的 attributeName

# TODO
[TODO](TODO.md)