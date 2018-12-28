package cn.jastz.sitemesh;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.autoconfigure.sitemesh.SiteMeshProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhiwen
 */
@Component
public class SiteMeshFilter extends ConfigurableSiteMeshFilter {
    private final SiteMeshProperties siteMeshProperties;

    public SiteMeshFilter(SiteMeshProperties siteMeshProperties) {
        this.siteMeshProperties = siteMeshProperties;
    }

    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addTagRuleBundle(new MyTagRuleBundle(siteMeshProperties));
        // 路径和 装饰器（模板）
        if (siteMeshProperties.getPathDecoratorsMap() != null) {
            siteMeshProperties.getPathDecoratorsMap().forEach((k, v) -> {
                builder.addDecoratorPaths(k, v);
            });
        }
    }
}
