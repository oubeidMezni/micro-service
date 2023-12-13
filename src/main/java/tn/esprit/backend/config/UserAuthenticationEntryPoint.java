package tn.esprit.backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import tn.esprit.backend.Dto.ErrorDto;
import javax.servlet.ServletException;
import java.io.IOException;

@Component
public class UserAuthenticationEntryPoint  implements AuthenticationEntryPoint {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @Override
    public void commence(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        OBJECT_MAPPER.writeValue(response.getOutputStream(), new ErrorDto("Unauthorized path"));
    }
}
