package com.example.backend;

import lombok.Getter;

@Getter
public class Result {
    private final Integer code;   //相应码
    private final String message;
    private final Object data;

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
