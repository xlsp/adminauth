package cn.arcdev.gym.adminauth.filter;

import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Login filter.
 *
 * @author Kraken
 */
public class AdminLoginFilter extends AbstractAuthenticationProcessingFilter {
    public AdminLoginFilter() {
        super(new AntPathRequestMatcher("/login", HttpMethod.POST.toString()));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        return null;
    }
}
