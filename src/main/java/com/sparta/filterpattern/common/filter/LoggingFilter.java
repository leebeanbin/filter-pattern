package com.sparta.filterpattern.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * create on 2024/05/20 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class LoggingFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    // 전처리
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    String url = httpServletRequest.getRequestURI();
    log.info(url);

    filterChain.doFilter(servletRequest, servletResponse); // 다음 Filter 로 이동

    // 후처리
    log.info("비즈니스 로직 완료");
  }
}
