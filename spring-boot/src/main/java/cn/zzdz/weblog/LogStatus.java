package cn.zzdz.weblog;

//@Aspect
//@Component
//@Order(2)
public class LogStatus {
	//@Pointcut("execution(* cn.zzdz.hellocontroller.HelloController.*(..))")
	public void logsta() {
	}
//dao数据库  dto//从数据库查出数据传输
	//@Around("logsta()")
	/*public Object aroundStatus(ProceedingJoinPoint pjp) throws Throwable {
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
	}*/

}
