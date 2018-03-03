package cn.zzdz.provider;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import cn.zzdz.domain.UserInfo;
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
//				.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		//System.out.println(authentication.);
		
		String userName = authentication.getName();// 这个获取表单输入中返回的用户名;
		String password = (String) authentication.getPrincipal();// 这个是表单中输入的密码；
		// 这里构建来判断用户是否存在和密码是否正确
		UserInfo userInfo = (UserInfo) userDetailService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；
		if (userInfo == null) {
			throw new BadCredentialsException("用户名不存在");
		}
		if (!userInfo.getPassword().equals(password)) {
			throw new BadCredentialsException("密码不正确");
		}
		Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
		// 构建返回的用户登录成功的token
		return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// 这里直接改成retrun true;表示是支持这个执行
        return true;
	}

}
