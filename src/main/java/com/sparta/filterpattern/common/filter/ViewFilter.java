package com.sparta.filterpattern.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.springframework.stereotype.Component;

/**
 * create on 2024/05/27 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Component
public class ViewFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    // 요청값에서 cookie 확인
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

    if (httpServletRequest.getCookies() != null) {
      for (Cookie cookie : httpServletRequest.getCookies()) {
        // cookie 에 view 값이 있으면 return
        if ("view".equals(cookie.getName())) {
          return;
        }
      }
    }

    // 문제 없으니 다음 filter
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
