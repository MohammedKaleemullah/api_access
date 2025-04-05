package com.kaleem.apiaccess.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class DomainRestrictionFilter extends OncePerRequestFilter {

    private static final String ALLOWED_ORIGIN = "https://zohopayments.com";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        if ("/api/payments".equals(path)) {
            String origin = request.getHeader("Origin");
            String referer = request.getHeader("Referer");

            if (origin == null || !origin.equals(ALLOWED_ORIGIN)) {
                System.out.println("Blocked due to invalid origin: " + origin);
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden: Invalid Origin");
                return;
            }

            if (referer != null && !referer.startsWith(ALLOWED_ORIGIN)) {
                System.out.println("Blocked due to invalid referer: " + referer);
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden: Invalid Referer");
                return;
            }
        }

        // Allow other endpoints
        filterChain.doFilter(request, response);
    }

}
