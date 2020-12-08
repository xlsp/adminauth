package cn.arcdev.gym.adminauth.filter;

import cn.arcdev.core.constant.ErrorCodes;
import cn.arcdev.core.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Spring security exception translator.
 *
 * @author Kraken
 */
@Slf4j
public class AuthExceptionTranslationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (AccessDeniedException exception) {
            returnJson(servletResponse,
                    ErrorCodes.DEFAULT_ERROR_CODE + HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
        } catch (AuthenticationException exception) {
            returnJson(servletResponse,
                    ErrorCodes.DEFAULT_ERROR_CODE + HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
        }
    }

    /**
     * Return an error json in http servlet response.
     *
     * @param response servlet response
     * @param status   error status code
     * @param message  error message
     * @throws IOException if response write json failed
     */
    protected void returnJson(ServletResponse response, int status, String message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getOutputStream().write(objectMapper.writeValueAsBytes(new Response<>().setStatus(status).setMessage(message)));
    }
}
