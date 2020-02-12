package com.spring.allinone.travel.audit;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class.getName());
	
	@Before("execution(* com.spring.allinone.travel.booking.BookingService.book(..))")
	public void logBookingRequest(JoinPoint joinPoint) {
		log.info("Before booking request with argument : "+Arrays.toString(joinPoint.getArgs()));
	}
}
