package com.ktxdevelopment.gatewayservice.auth.security.filter;

import com.ktxdevelopment.siratumustakim.exceptions.ApiKeyInvalidException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Slf4j
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {

    private static final String API_KEY_HEADER = "X-API-Key";
    private final String apiKey;

    public ApiKeyAuthenticationFilter(@Value("${application.security.api-key}") String apiKey) {
        this.apiKey = apiKey;
    }

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) {
        String providedApiKey = request.getHeader(API_KEY_HEADER);

        if (providedApiKey != null && providedApiKey.startsWith("SRT ") && DigestUtils.sha256Hex(providedApiKey.substring(4)).equals(apiKey)) {
            filterChain.doFilter(request, response);
            return;
        }

        throw new ApiKeyInvalidException();
    }
}