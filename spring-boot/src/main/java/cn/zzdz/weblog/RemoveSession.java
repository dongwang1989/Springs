package cn.zzdz.weblog;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RemoveSession {
	@Pointcut("execution( * Login..*.*(..))")
	public void removes()
	{}
	@Before("RemoveSession.removes()")
	public void before()
	{
		System.out.println("这是前置方法");
	}
}
