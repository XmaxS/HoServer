package com.horizon.server.common.advice;

import com.horizon.server.common.vo.ExceptionResult;
import com.horizon.server.common.exception.HoException;
import com.horizon.server.common.enums.ExceptionEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class HoExceptionHandler {

    @ExceptionHandler(HoException.class)
    public ResponseEntity<ExceptionResult> handleException(HoException e){
        ExceptionEnums exceptionEnums = e.getExceptionEnums();
        return ResponseEntity.status(exceptionEnums.getCode())
                .body(new ExceptionResult(e.getExceptionEnums()));
    }

}
