package cn.zzdz.weblog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Order(2)
public class LogStatus {
	@Pointcut("execution(* cn.zzdz.login.Hello.*(..))")
	public void logsta() {
	}
//dao数据库  dto//从数据库查出数据传输
	@Around("logsta()")
	public Object aroundStatus(ProceedingJoinPoint pjp) throws Throwable {
		Object proceed;
		System.out.println("这是环绕通知之前的部分!!");
		// 获取将要执行的方法名称
		String methodName = pjp.getSignature().getName();

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			proceed = pjp.proceed();// 调用目标方法
		}
		else
		{
			proceed="403";
		}
		System.out.println("这是环绕通知之后的部分!!");
		return proceed;
	}

}
