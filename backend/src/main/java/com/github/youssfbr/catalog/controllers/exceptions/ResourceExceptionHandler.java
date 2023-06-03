package com.github.youssfbr.catalog.controllers.exceptions;

import com.github.youssfbr.catalog.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound (
            ResourceNotFoundException e,
            HttpServletRequest request)
    {

        HttpStatus notFound = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError();
        error.setStatus(notFound.value());
        error.setError("Resource not found.");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(notFound).body(error);
    }

}
