package com.starlight.restclientservice.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServiceLoggingAspect {

    @Pointcut("execution(public * com.starlight.restclientservice.service.*Service.create(*))")
    public void createServiceMethod() {}

    @Pointcut("execution(public * com.starlight.restclientservice.service.*Service.deleteById(*))")
    public void deleteServiceMethod() {}

    @Pointcut("execution(public * com.starlight.restclientservice.service.*Service.getAll())")
    public void getAllServiceMethod() {}

    @Pointcut("execution(public * com.starlight.restclientservice.service.*Service.update(*))")
    public void updateServiceMethod() {}

    @Before("createServiceMethod() && target(service) && args(dto)")
    public void addLogsBeforeCreateServiceMethod(Object service, Object dto) {
        log.info("Invoked 'create' method in class {} with parameters {}", service, dto);
    }

    @AfterReturning(value = "createServiceMethod() && target(service)", returning = "result")
    public void addLogsAfterReturningFromCreateServiceMethod(Object service, Object result) {
        log.info("Returned result {} from 'create' method in class {}", result, service);
    }

    @After("createServiceMethod() && target(service)")
    public void addLogsAfterCreateServiceMethod(Object service) {
        log.info("After 'create' method in class {}", service);
    }

    @Before("deleteServiceMethod() && target(service) && args(id)")
    public void addLogsBeforeDeleteServiceMethod(Object service, Object id) {
        log.info("Invoked 'delete' method in class {} with id {}", service, id);
    }

    @After("deleteServiceMethod() && target(service)")
    public void addLogsAfterDeleteServiceMethod(Object service) {
        log.info("After 'delete' method in class {}", service);
    }

    @Before("getAllServiceMethod() && target(service)")
    public void addLogsBeforeGetAllServiceMethod(Object service) {
        log.info("Invoked 'getAll' method in class {}", service);
    }

    @AfterReturning(value = "getAllServiceMethod() && target(service)", returning = "result")
    public void addLogsAfterReturningFromGetAllServiceMethod(Object service, Object result) {
        log.info("Returned result {} from 'getAll' method in class {}", result, service);
    }

    @After("getAllServiceMethod() && target(service)")
    public void addLogsAfterGetAllServiceMethod(Object service) {
        log.info("After 'getAll' method in class {}", service);
    }

    @Before("updateServiceMethod() && target(service) && args(dto)")
    public void addLogsBeforeUpdateServiceMethod(Object service, Object dto) {
        log.info("Invoked 'update' method in class {} with parameters {}", service, dto);
    }

    @AfterReturning(value = "updateServiceMethod() && target(service)", returning = "result")
    public void addLogsAfterReturningFromUpdateServiceMethod(Object service, Object result) {
        log.info("Returned result {} from 'update' method in class {}", result, service);
    }

    @After("updateServiceMethod() && target(service)")
    public void addLogsAfterUpdateServiceMethod(Object service) {
        log.info("After 'update' method in class {}", service);
    }


}
