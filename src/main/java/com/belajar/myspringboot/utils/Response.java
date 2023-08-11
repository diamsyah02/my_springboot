package com.belajar.myspringboot.utils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Response<T> {
    private Integer statusCode;
    private String message;
    private T data;
}
