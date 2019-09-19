package com.universal.config.exception;


import com.universal.vo.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * @author YIJIUE
 */
@Component
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {

    @Override
    public ResponseEntity translate(Exception e) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED.value())
                .body(ResponseApi.fail(e.toString()));

    }
}
