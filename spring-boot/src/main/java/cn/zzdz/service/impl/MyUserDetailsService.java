package cn.zzdz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import cn.zzdz.service.IUserService;
@Component
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private IUserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//System.out.println("123"+username);//if(username.equals("zhangsan"))
        //{
              //假设返回的用户信息如下;
			
              //UserInfo userInfo=new UserInfo("张三",18,"男","zhangsan","123");
              return userService.log(username);
        //}
		//return null;
	}

}
