package org.springframework.boot.autoconfigure.sitemesh;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @author zhiwen
 */
@ConfigurationProperties(prefix = "org.sitemesh")
public class SiteMeshProperties {
    private Map<String, String> tagPropertyMap;
    private Map<String, List<String>> pathDecoratorsMap;

    public Map<String, String> getTagPropertyMap() {
        return tagPropertyMap;
    }

    public void setTagPropertyMap(Map<String, String> tagPropertyMap) {
        this.tagPropertyMap = tagPropertyMap;
    }

    public Map<String, List<String>> getPathDecoratorsMap() {
        return pathDecoratorsMap;
    }

    public void setPathDecoratorsMap(Map<String, List<String>> pathDecoratorsMap) {
        this.pathDecoratorsMap = pathDecoratorsMap;
    }
}
