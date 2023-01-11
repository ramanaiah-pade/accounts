package com.ramana.accounts.exceptions;

import com.ramana.accounts.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

   @ExceptionHandler(NotFoundException.class)
   public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request){
        return new ResponseEntity<>(buildErrorObject(ex, request), HttpStatus.NOT_FOUND);
   }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request){
        return new ResponseEntity<>(buildErrorObject(ex, request), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
        return new ResponseEntity<>(buildErrorObject(ex, request), HttpStatus.INTERNAL_SERVER_ERROR);
    }

   public static Error buildErrorObject(Exception ex, WebRequest request){
       Error error = new Error();
       error.setTimestamp(new Date());
       error.setError(getErrorType(ex));
       error.setPath(request.getContextPath());
       error.setStatus(getStatusCode(ex));
       error.setMessage(ex.getMessage());
       return error;
   }

    private static int getStatusCode(Exception ex) {
       if(ex instanceof NotFoundException)
           return 404;
       if(ex instanceof BadRequestException)
            return 400;
       return 500;
    }

    private static String getErrorType(Exception ex) {
        if(ex instanceof NotFoundException)
            return "Not Found Exception";
        if(ex instanceof BadRequestException)
            return "Bad Request Exception";
        return "Internal Server Error";
    }
}
