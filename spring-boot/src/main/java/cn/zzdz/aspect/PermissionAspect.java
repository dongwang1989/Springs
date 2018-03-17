package cn.zzdz.aspect;

import java.lang.reflect.Method;
import java.util.Collection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

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

	@Before("aspect() && @annotation(permission)")
	public void getmethod(JoinPoint point, IPermission permission) throws Exception {
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		// Object target = point.getTarget();
		// Class<?> classz = target.getClass();
		Method m = ((MethodSignature) point.getSignature()).getMethod();
		// 进行权限判断
		boolean isEquals = false;

		String permissionName = permission.value();
		if (authorities.stream().anyMatch(ga -> ga.getAuthority().equals(permissionName))) {
			isEquals = true;
		}
		if (isEquals == false) {
			throw new Exception("权限不够");
		}
	}

}
