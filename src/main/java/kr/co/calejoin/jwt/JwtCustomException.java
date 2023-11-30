package kr.co.calejoin.jwt;

import java.io.IOException;

import org.springframework.http.MediaType;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;

// JWT 커스텀 예외클래스
public class JwtCustomException extends RuntimeException {

    JWT_ERROR error;

    @Getter
    public enum JWT_ERROR {
        BADTYPE(401, "JWT type is not Bearer or is null"),
        MALFORM(402, "JWT Malformed"),
        BADSIGN(403, "JWT has bad Signatured"),
        EXPIRED(404, "JWT Expired");

        private int status;
        private String message;

        JWT_ERROR(int status, String message) {
            this.status = status;
            this.message = message;
        }
    }

    public JwtCustomException(JWT_ERROR error) {
        super(error.name());
        this.error = error;
    }

    public void sendResponseError(HttpServletResponse response) throws IOException{
        response.setStatus(error.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().print(error.getMessage());
    }
}