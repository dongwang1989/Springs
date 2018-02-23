package cn.zzdz.weblog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

import org.springframework.web.context.request.RequestContextHolder;

import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Order(1)
public class WebLogAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 定义拦截规则：拦截com.xjj.web.controller包下面的所有类中，有@RequestMapping注解的方法。
	 */
	@Pointcut("execution(* cn.zzdz.login..*.*(..))") // and
															// @annotation(org.springframework.web.bind.annotation.RequestMapping)
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) {
		// 接收到请求，记录请求内容
		System.out.println("日志前");
		logger.info("WebLogAspect.doBefore()");

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容

		logger.info("URL : " + request.getRequestURL().toString());

		logger.info("HTTP_METHOD : " + request.getMethod());

		logger.info("IP : " + request.getRemoteAddr());

		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());

		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

		// 获取所有参数方法一：

		Enumeration<String> enu = request.getParameterNames();

		while (enu.hasMoreElements()) {

			String paraName = (String) enu.nextElement();

			System.out.println(paraName + ": " + request.getParameter(paraName));

		}

	}

	@After("webLog()")
	public void doAfter() {
		System.out.println("wwwzzzaaa");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		logger.info("url = {} end of execution", request.getRequestURL());
	}

	@AfterReturning("webLog()")

	public void doAfterReturning(JoinPoint joinPoint) {
		System.out.println("www");
		// 处理完请求，返回内容
		logger.info("WebLogAspect.doAfterReturning()");

	}
}
