package com.ultra.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * Created by zhenglian on 2016/10/12.
 */
@Configuration
public class I18nConfig extends WebMvcConfigurationSupport {

    /**
     * session区域解析器
     * 
     * @return
     */
    // @Bean
    // public LocaleResolver localeResolver() {
    // SessionLocaleResolver resolver = new SessionLocaleResolver();
    // //这里通过设置China.US可以进行中英文转化
    // resolver.setDefaultLocale(Locale.US);
    //
    // return resolver;
    // }

    /**
     * cookie区域解析器
     * 
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver slr = new CookieLocaleResolver();
        // 设置默认区域,
        slr.setDefaultLocale(Locale.CHINA);
        slr.setCookieMaxAge(3600);// 设置cookie有效期.
        return slr;
    }

    // 固定的区域解析器之FixedLocaleResolver:一直使用固定的Local, 不支持改变语言。
    // @Bean
    // public LocaleResolver localeResolver() {
    // FixedLocaleResolver slr = new FixedLocaleResolver();
    // // 设置默认区域,
    // slr.setDefaultLocale(Locale.US);
    // return slr;
    // }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        // 设置识别国际化参数,默认为：locale
        // lci.setParamName(LocaleChangeInterceptor.DEFAULT_PARAM_NAME);
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
