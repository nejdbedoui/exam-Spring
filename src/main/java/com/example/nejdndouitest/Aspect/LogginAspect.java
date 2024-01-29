package com.example.nejdndouitest.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LogginAspect {
        @After("execution(* com.example.nejdndouitest.Service.*.addVehicleReservationAndAffectToWashingservice(..))")
    public void logWaiting(JoinPoint joinPoint) {
        log.info(" Waiting for a Worker ");
    }
}
