package com.webserivces.newsapi.consumer.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

public class ValidationExeptionHandlers {


    //TODO check how to handle validation exeptions. They appear to not work correctly

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity handle(ConstraintViolationException constraintViolationException) {
//        Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
//        String errorMessage = "";
//        if (!violations.isEmpty()) {
//            StringBuilder builder = new StringBuilder();
//            violations.forEach(violation -> builder.append(" " + violation.getMessage()));
//            errorMessage = builder.toString();
//        } else {
//            errorMessage = "ConstraintViolationException occured.";
//        }
//        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//    }
}
