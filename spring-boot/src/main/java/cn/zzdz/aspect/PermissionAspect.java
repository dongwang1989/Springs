package cn.zzdz.aspect;

import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cd.zzdz.permission.IPermission;

@Component
@Aspect
@Order(1)
public class PermissionAspect {
	// /** 类上注解情形 */
	// @Pointcut("execution(* cn.zzdz.usercontroller..*.*(..)) &&
	// @within(cd.zzdz.permission.IPermission)")
	// public void aspect2() {
	//
	// }

	/** 方法上注解情形 */
	@Pointcut("execution(* cn.zzdz.usercontroller..*.*(..)) && @annotation(cd.zzdz.permission.IPermission)")
	public void aspect() {

	}

	@Before("aspect()")
	public void getmethod(JoinPoint point) throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("permission");
		Object target = point.getTarget();
		Class<?> classz = target.getClass();
		Method m = ((MethodSignature) point.getSignature()).getMethod();
		// 进行权限判断
		boolean isEquals = false;
		if (classz != null && m != null) {
			boolean isClzAnnotation = classz.isAnnotationPresent(IPermission.class);
			boolean isMethondAnnotation = m.isAnnotationPresent(IPermission.class);
			IPermission rc = null;
			// 如果方法和类声明中同时存在这个注解，那么方法中的会覆盖类中的设定。
			if (isMethondAnnotation) {
				rc = m.getAnnotation(IPermission.class);
			} else if (isClzAnnotation) {
				rc = classz.getAnnotation(IPermission.class);
			}
			String value = rc.value();
			@SuppressWarnings("unchecked")
			Set<String> set = (Set<String>) obj;
			if (set != null && set.contains(value)) {
				isEquals = true;
			}
		}
		if (isEquals == false) {
			throw new Exception("权限不够");
		}
	}

	/** aop实际拦截两种情形 */
	// @Around("aspect() || aspect2()")
	// public Object doBefore(ProceedingJoinPoint point) {
	// HttpServletRequest request = ((ServletRequestAttributes)
	// RequestContextHolder.getRequestAttributes())
	// .getRequest();
	// HttpSession session = request.getSession();
	// Object target = point.getTarget();
	// System.out.println("target:" + target);
	// String method = point.getSignature().getName();
	// System.out.println("getSignature:" +
	// point.getSignature().getDeclaringTypeName());
	// System.out.println("method:" + method);
	// Class<?> classz = target.getClass();
	// System.out.println("classz:" + classz);
	// Method m = ((MethodSignature) point.getSignature()).getMethod();
	// System.out.println("m:" + m.getReturnType());
	// try {
	// if (classz != null && m != null) {
	// boolean isClzAnnotation = classz.isAnnotationPresent(IPermission.class);
	// boolean isMethondAnnotation = m.isAnnotationPresent(IPermission.class);
	// IPermission rc = null;
	// // 如果方法和类声明中同时存在这个注解，那么方法中的会覆盖类中的设定。
	// if (isMethondAnnotation) {
	// rc = m.getAnnotation(IPermission.class);
	// } else if (isClzAnnotation) {
	// rc = classz.getAnnotation(IPermission.class);
	// }
	// String value = rc.value();
	// System.out.println("value:" + value);
	// Object obj = session.getAttribute("permission");
	// System.out.println("obj:" + obj);
	// @SuppressWarnings("unchecked")
	// Set<String> set = (Set<String>) obj;
	// System.out.println("set:" + set);
	// // 进行权限判断
	// boolean isEquals = false;
	// if (set != null && set.contains(value)) {
	// isEquals = true;
	// }
	// if (isEquals) {
	// try {
	// return point.proceed();
	// } catch (Throwable e) {
	// e.printStackTrace();
	// }
	// } else {
	// System.out.println("权限不够请绕行");
	// ResultDto resultdto = new ResultDto();
	// resultdto.setResult("权限不够请绕行");
	// }
	//
	// }
	// } catch (Exception e) {
	//
	// }
	// return null;
	// }
}
