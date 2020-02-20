package br.com.lomonteiro.teste.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

        
    @ExceptionHandler(RequestValidationException.class)
    public ResponseEntity<CustomError> customHandleRequestValidation(Exception e, WebRequest request) {
        CustomError error = new CustomError();
        error.setError(e.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<CustomError>(error, HttpStatus.BAD_REQUEST);

    }

}
