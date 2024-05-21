package com.sparta.filterpattern.common.config;

import com.sparta.filterpattern.common.filter.LoggingFilter;
import com.sparta.filterpattern.common.filter.CartCookieFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create on 2024/05/20 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Configuration
public class FilterConfiguration {

  /**
   * 로그 관련 필터 추가.
   *
   * @return {@code FilterRegistrationBean}
   * @see FilterRegistrationBean
   */
  @Bean
  public FilterRegistrationBean loggingFilter() {
    FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
    filterRegistrationBean.setFilter(new LoggingFilter());
    filterRegistrationBean.setOrder(1);
    filterRegistrationBean.addUrlPatterns("/*");

    return filterRegistrationBean;
  }

  /**
   * Cookie 에 cart 가 있을 시 필터하는 필터 추가.
   *
   * @return {@code FilterRegistrationBean}
   *    * @see FilterRegistrationBean
   */
  @Bean
  public FilterRegistrationBean cartCookieFilter() {
    FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
    filterRegistrationBean.setFilter(new CartCookieFilter());
    filterRegistrationBean.setOrder(2);
    filterRegistrationBean.addUrlPatterns("/product", "/product/**");

    return filterRegistrationBean;
  }
}
