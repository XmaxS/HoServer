package com.horizon.server.common.exception;


import com.horizon.server.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HoException extends RuntimeException{

    private ExceptionEnums exceptionEnums;

}
