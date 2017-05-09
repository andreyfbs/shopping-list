package br.com.santosandrey.sl.api.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santosandrey.sl.api.client.UserStoreService;

/**
 * This Interceptor is
 */
public class TokenUserLoggedValidationInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenUserLoggedValidationInterceptor.class);

    private static final String HEADER_TOKEN_SESSION = "X-Token-Session";

    @Autowired
    private UserStoreService userStoreService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {

        // Check if endPoint needs authentication
        if (!checkResourceNeedsToken(handler)) {
            return true;
        }

        String accessToken = request.getHeader(HEADER_TOKEN_SESSION);

        if (StringUtils.isBlank(accessToken)) {
            LOGGER.info("c=TokenValidatorUserAuthenticationInterceptor, M=preHandle, step=tokenBlank, token={}, URI={}", accessToken,
                    request.getRequestURI());
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }

        // Check if User is Logged
        Long userId = userStoreService.retrieveUserId(accessToken);
        if (!userStoreService.isUserLogged(userId, accessToken)) {
            LOGGER.info("c=TokenValidatorUserAuthenticationInterceptor, M=preHandle, step=userNotLogged, token={}, URI={}", accessToken,
                    request.getRequestURI());
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        return true;
    }

    private boolean checkResourceNeedsToken(final Object handler) {
        final HandlerMethod method = (HandlerMethod) handler;

        return method.getMethod().isAnnotationPresent(TokenValidationRequired.class)
                || method.getMethod().getDeclaringClass().isAnnotationPresent(TokenValidationRequired.class);
    }

}