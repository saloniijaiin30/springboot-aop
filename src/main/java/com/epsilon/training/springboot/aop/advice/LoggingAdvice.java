package com.epsilon.training.springboot.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {

	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

	@Pointcut(value = "execution(* com.epsilon.training.springboot.aop.*.*.*(..))")
	public void myPointcut() {
		
	}
		
	/***
	 * @Desc: Around Advice = Before Advice + After Advice
	 * @param pjp
	 * @return
	 * @throws JsonProcessingException
	 */
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {
		ObjectMapper mapper = null;
		String className = null;
		String methodName = null;
		Object[] args = null;
		try {
			mapper = new ObjectMapper();
			className = pjp.getTarget().getClass().toString();
			methodName = pjp.getSignature().getName();
			args = pjp.getArgs();
			log.info("Method is invoked " + className + ":" + methodName + "()" + "with Args: "
					+ mapper.writeValueAsString(args));
			Object object = pjp.proceed();
			log.info(className + ":" + methodName + "()" + "Response is: " + mapper.writeValueAsString(object));
		} catch (Exception e) {
			log.error("Exception has been occured in " + className + ":" + methodName + "()" + e.getCause());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
