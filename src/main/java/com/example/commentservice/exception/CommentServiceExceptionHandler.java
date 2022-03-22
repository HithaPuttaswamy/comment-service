package com.example.commentservice.exception;

import com.example.commentservice.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

public class CommentServiceExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler({CommentNotFoundException.class})
  ResponseEntity customerNotFoundHandler(Exception exception, ServletWebRequest request){
    ApiError apiError = new ApiError();
    apiError.setStatus(HttpStatus.NOT_FOUND);
    apiError.setErrors(Arrays.asList(exception.getMessage()));
    apiError.setPath(request.getDescription(false));
    apiError.setTimestamp(LocalDateTime.now());
    return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({CommentAlreadyExistsException.class})
  ResponseEntity customerAlreadyExistsException(Exception exception, ServletWebRequest request){
    ApiError apiError = new ApiError();
    apiError.setStatus(HttpStatus.FOUND);
    apiError.setErrors(Arrays.asList(exception.getMessage()));
    apiError.setPath(request.getDescription(false));
    apiError.setTimestamp(LocalDateTime.now());
    return new ResponseEntity<>(apiError, HttpStatus.FOUND);
  }
}
