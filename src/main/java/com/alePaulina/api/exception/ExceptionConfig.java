
package com.alePaulina.api.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pauline
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
