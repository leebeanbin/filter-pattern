package com.sparta.filterpattern.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ViewCookieFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        // 전처리
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if (httpServletRequest.getCookies() != null) {
            if (Arrays.stream(httpServletRequest.getCookies())
                    .anyMatch(h -> "view".equals(h.getName()))) {
                log.error("view cookie is not allowed");
                return;
//        throw new RuntimeException("cart cookie is not allowed");
            }
        }

        // 문제가 없는 경우 다음 필터로 넘어 값니다.
        filterChain.doFilter(servletRequest, servletResponse); // 다음 Filter 로 이동
    }
}