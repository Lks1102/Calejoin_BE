/*
package kr.co.calejoin.jwt;

import java.io.IOException;

import kr.co.calejoin.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SecurityException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String uri = request.getRequestURI();
        int i = uri.lastIndexOf("/");
        String path = uri.substring(i);

        log.info("JwtAuthenticationFilter...1 : " + path);


        String header = request.getHeader(AUTH_HEADER);
        log.info("JwtAuthenticationFilter...2 : " + header);

        String token = getTokenFromHeader(header);
        log.info("JwtAuthenticationFilter...3 : " + token);

        if(token != null) {

            try {
                jwtProvider.validateToken(token);

                // refresh 토큰 검사가 성공이면
                if(path.equals("/refreshToken")) {

                    Claims claims = jwtProvider.getClaims(token);
                    String uid  = (String) claims.get("uid");
                    String role = (String) claims.get("role");

                    UserEntity user = UserEntity.builder()
                            .uid(uid)
                            .type(role).build();

                    String accessToken = jwtProvider.createToken(user, 3);

                    response.setStatus(HttpServletResponse.SC_CREATED);
                    response.getWriter().print(accessToken);
                    return;
                }

            }catch (JwtCustomException e) {
                log.info("JwtAuthenticationFilter...6 : " + e.error.getStatus());
                log.info("JwtAuthenticationFilter...7 : " + e.error.getMessage());
                e.sendResponseError(response);
                return;
            }

            log.info("JwtAuthenticationFilter...4");
            // Security 인증처리
            Authentication authentication = jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 다음 필터 이동
        filterChain.doFilter(request, response);
    }

    public String getTokenFromHeader(String header) {

        if(header != null && header.startsWith(TOKEN_PREFIX)) {
            return header.substring(TOKEN_PREFIX.length());
        }

        return null;
    }

}*/
