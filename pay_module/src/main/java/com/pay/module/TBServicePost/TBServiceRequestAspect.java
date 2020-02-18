package com.pay.module.TBServicePost;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Title: ControllerAspect.java
 * @Description: Controller切面,主要计算交易耗时
 * @author: 雷大鹏
 * @date: 2020-02-03 08:53:39
 */
@Aspect
@Component
@Slf4j
public class TBServiceRequestAspect {

	private ThreadLocal<Map> tlocal = new ThreadLocal<Map>();

	@Pointcut("execution(public * com.pay.module.TBServicePost..*.*(..))")
	public void TBServiceAspect() {
	}

	@Before("TBServiceAspect()")
	public void doBefore(JoinPoint joinPoint) {
		try {
			long beginTime = System.currentTimeMillis();
			String args = (String) joinPoint.getArgs()[0];
			log.info("--->tbService服务调用,请求报文[" + args + "]");
			Map optLog = new HashMap();
			optLog.put("tbService_beginTime", beginTime);
			optLog.put("tbService_args", args);
			tlocal.set(optLog);

		} catch (Exception e) {
			log.error("***请求报文分析失败doBefore()***", e);
		}
	}

	@AfterReturning(returning = "result", pointcut = "TBServiceAspect()")
	public void doAfterReturning(Object result) {
		Map optLog = tlocal.get();
		try {
			long beginTime = (long) optLog.get("tbService_beginTime");
			Map argMap = JSON.parseObject(optLog.get("tbService_args").toString(), Map.class);
			Map resultMap = JSON.parseObject(result.toString(), Map.class);
			log.info("<---tbService服务调用,返回报文[" + result + "],交易耗时：[" + (System.currentTimeMillis() - beginTime) + "]");
		} catch (Exception e) {
			log.error("***响应报文分析失败doAfterReturning()***", e);
		}
		optLog = null;
	}

}