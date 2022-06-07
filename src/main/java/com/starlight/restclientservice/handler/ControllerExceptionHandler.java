package com.starlight.restclientservice.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "com.starlight.restclientservice.controller")
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {


}
