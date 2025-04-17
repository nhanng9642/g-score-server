package com.nhan.gscore.interceptor;

import com.nhan.gscore.domain.exception.ScoreNotFoundException;
import com.nhan.gscore.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
     @ExceptionHandler(Exception.class)
     public ResponseEntity<ErrorResponse> handleException(Exception e) {
         ErrorResponse errorResponse = new ErrorResponse();
         e.printStackTrace();
         errorResponse.setMessage(e.getMessage());
         errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
         return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
     }

     @ExceptionHandler(ScoreNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleScoreNotFoundException(ScoreNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage(e.getMessage());
            errorResponse.setCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(MethodArgumentTypeMismatchException.class)
        public ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
            String paramName = ex.getName();
            String expectedType = ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "unknown";
            String value = ex.getValue() != null ? ex.getValue().toString() : "null";

            String message = String.format("Parameter '%s' must be of type %s. Received value: '%s'",
                    paramName, expectedType, value);

            ErrorResponse errorResponse = new ErrorResponse(message, HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(errorResponse);
        }
}
