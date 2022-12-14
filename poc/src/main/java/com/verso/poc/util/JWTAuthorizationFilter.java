//package com.verso.poc.util;
//
//import io.jsonwebtoken.*;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@Component
//public class JWTAuthorizationFilter extends OncePerRequestFilter {
//
//    private static final String HEADER = "Authorization";
//    private static final String PREFIX = "Bearer ";
//
//    @Value("${spring.security.key}")
//    private String securityKey;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//        try {
//            if (existeJWTToken(request)) {
//                Claims claims = validateToken(request);
//                if (Objects.nonNull(claims.get("authorities"))) {
//                    setUpSpringAuthentication(claims);
//                } else {
//                    SecurityContextHolder.clearContext();
//                }
//            } else {
//                SecurityContextHolder.clearContext();
//            }
//            chain.doFilter(request, response);
//        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            (response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
//        }
//    }
//
//    private Claims validateToken(HttpServletRequest request) {
//        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
//        return Jwts.parser().setSigningKey(securityKey.getBytes()).parseClaimsJws(jwtToken).getBody();
//    }
//
//    private void setUpSpringAuthentication(Claims claims) {
//        @SuppressWarnings("unchecked")
//        List<String> authorities = (List<String>) claims.get("authorities");
//
//        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
//                authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
//        SecurityContextHolder.getContext().setAuthentication(auth);
//    }
//
//    private boolean existeJWTToken(HttpServletRequest request) {
//        String authenticationHeader = request.getHeader(HEADER);
//        return Objects.nonNull(authenticationHeader) && authenticationHeader.startsWith(PREFIX);
//    }
//}
