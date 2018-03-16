package cn.zzdz.aspect;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import cd.zzdz.permission.IPermission;
import cn.zzdz.service.impl.AuthorityImpl;

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
		@SuppressWarnings("unchecked")
		List<AuthorityImpl> list = (List<AuthorityImpl>) SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		Set<String> set = list.get(0).getPermissions();
		// Object target = point.getTarget();
		// Class<?> classz = target.getClass();
		Method m = ((MethodSignature) point.getSignature()).getMethod();
		// 进行权限判断
		boolean isEquals = false;
		IPermission rc = null;
		if (point.getClass().isAnnotationPresent(IPermission.class)) {
			rc = point.getClass().getAnnotation(IPermission.class);
		} else if (m.isAnnotationPresent(IPermission.class)) {
			rc = m.getAnnotation(IPermission.class);
		}
		System.out.println(rc.value());
		if (set != null && set.contains(rc.value())) {
			isEquals = true;
		}
		if (isEquals == false) {
			throw new Exception("权限不够");
		}
	}

}
