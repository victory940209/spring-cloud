package com.victory.system.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableAspectJAutoProxy
@Aspect
@Component
public class LogAspect {


	@Around("execution(* com.foresys..*Controller.*(..))")
	public Object logBefore(ProceedingJoinPoint joinpoint)throws Throwable{

		Object proceed = joinpoint.proceed();

//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
//		HttpSession session = request.getSession();
//		Enumeration eheader = request.getHeaderNames();
//		while(eheader.hasMoreElements()) {
//			String nm = (String) eheader.nextElement();
//			log.info("==== headernm : " + nm + "  value : " + request.getHeader(nm));
//		}
//		log.info("==== TraceId : " + request.getHeader("X-B3-TraceId"));

        Map<String, Object> resMap = new HashMap<>();

        if(proceed instanceof Map) {
        	ObjectMapper mapper = new ObjectMapper();	//
        	resMap.put("resultValue", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(proceed));
        }else {
        	resMap.put("resultValue", proceed);
        }

        return proceed;
	}
}
