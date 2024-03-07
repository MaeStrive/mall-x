package com.situ.mallsdau1.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BusinessException extends  RuntimeException{
    private String msg;

}
