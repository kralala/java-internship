package hiber.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static hiber.security.SecurityConst.CRYPT_KEY;
import static org.hibernate.internal.util.StringHelper.isEmpty;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
        }

        else //header != null
        {
            String user = JWT.require(Algorithm.HMAC512(CRYPT_KEY.getBytes()))
                    .build()
                    .verify(header.replace("Bearer ", ""))
                    .getSubject();

            if (user != null) {
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(token);
                chain.doFilter(request, response);
            }

        }
    }


}
