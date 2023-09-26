package com.ktxdevelopment.gatewayservice.auth.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
public class AdminSecurityFilter extends OncePerRequestFilter {

    private final String apiKey;

    public AdminSecurityFilter(@Value("${application.security.admin-key}") String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        if (!request.getServletPath().contains("/api/v1/admin")) {
            filterChain.doFilter(request, response);
            return;
        }

        String headerKey = request.getHeader("X-ADMIN-KEY");

        if (headerKey != null && headerKey.startsWith("SRT ")) {
            headerKey = DigestUtils.sha256Hex(headerKey.substring(4));
            if (Objects.equals(headerKey, apiKey)) {
                filterChain.doFilter(request, response);
            }
        }
    }
}
