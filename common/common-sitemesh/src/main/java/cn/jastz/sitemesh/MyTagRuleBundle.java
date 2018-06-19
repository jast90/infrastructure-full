package cn.jastz.sitemesh;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;
import org.springframework.boot.autoconfigure.sitemesh.SiteMeshProperties;

/**
 * @author zhiwen
 */
public class MyTagRuleBundle implements TagRuleBundle {

    private final SiteMeshProperties siteMeshProperties;

    public MyTagRuleBundle(SiteMeshProperties siteMeshProperties) {
        this.siteMeshProperties = siteMeshProperties;
    }

    @Override
    public void install(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
        // 标签名称映射成属性 tagToProperties
        siteMeshProperties.getTagPropertyMap().forEach((k, v) -> defaultState.addRule(k, new ExportTagToContentRule(siteMeshContext
                , contentProperty.getChild(v), false)));
    }

    @Override
    public void cleanUp(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
        if (!contentProperty.getChild("body").hasValue()) {
            contentProperty.getChild("body").setValue(contentProperty.getValue());
        }
    }
}
