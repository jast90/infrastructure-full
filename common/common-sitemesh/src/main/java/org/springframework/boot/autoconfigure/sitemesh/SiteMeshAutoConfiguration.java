package org.springframework.boot.autoconfigure.sitemesh;

import cn.jastz.sitemesh.SiteMeshFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author zhiwen
 */
@EnableConfigurationProperties(SiteMeshProperties.class)
public class SiteMeshAutoConfiguration {

    private final SiteMeshProperties siteMeshProperties;

    public SiteMeshAutoConfiguration(SiteMeshProperties siteMeshProperties) {
        this.siteMeshProperties = siteMeshProperties;
    }

    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean registrationBean
                = new FilterRegistrationBean();
        registrationBean.setFilter(new SiteMeshFilter(siteMeshProperties));
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
