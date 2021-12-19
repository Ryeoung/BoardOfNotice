package com.rsuport.notice.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class FilterConfig {
    /**
     * @return CharacterEncodingFilter
     *  인코딩 필터
     */
    @Bean
    public CharacterEncodingFilter  characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    /**
     * @param filter 인코딩 (utf - 8) 필터
     * @return FilterRegistrationBean
     *
     *  필터 등록
     */
    @Bean
    public FilterRegistrationBean setFilterRegistration(CharacterEncodingFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter);
        filterRegistrationBean.addUrlPatterns("/api/*"); // string 여러개를 가변인자로 받는 메소드
        return filterRegistrationBean;
    }
}
