package com.kaleem.apiaccess.config;

import com.kaleem.apiaccess.filter.DomainRestrictionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DomainRestrictionFilter> registerDomainFilter() {
        FilterRegistrationBean<DomainRestrictionFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new DomainRestrictionFilter());
        registrationBean.addUrlPatterns("/api/payments");
        return registrationBean;
    }
}
