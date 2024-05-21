package com.sparta.filterpattern.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.yaml.snakeyaml.util.ArrayUtils;

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
public class CartCookieFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    // 전처리
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    if (httpServletRequest.getCookies() != null) {
      if (Arrays.stream(httpServletRequest.getCookies())
          .anyMatch(h -> "cart".equals(h.getName()))) {
        log.error("cart cookie is not allowed");
        return;
//        throw new RuntimeException("cart cookie is not allowed");
      }
    }

    filterChain.doFilter(servletRequest, servletResponse); // 다음 Filter 로 이동
  }
}
