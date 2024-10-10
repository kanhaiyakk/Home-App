package com.kk.homeApp.entity;

import lombok.Data;

import java.util.Date;
@Data
public class ErrorObject {

    public Integer statusCode;

    public String message;

    public Date timestamp;
}
