package com.drone.app.exception;

import com.drone.app.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DroneExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto notFoundException(NotFoundException ex){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setResponseStatus(HttpStatus.NOT_FOUND.value());
        errorDto.setMessage(ex.getMessage());
        return errorDto;
    }

}
