package cn.zzdz.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zzdz.domain.User;
import cn.zzdz.service.IUserService;

@RestController
public class Register {
	@Autowired
	IUserService userService ;
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@RequestParam(value="name",required=true) String name,
			@RequestParam(value="sex",required=true) String sex,
			@RequestParam(value="age",required=true) int age,
			@RequestParam(value="username",required=true) String username,
			@RequestParam(value="pwd",required=true) String pwd )
	{
		
		User user  = new User();
		user.setName(name);
		user.setAge(age);
		user.setUsername(username);
		user.setSex(sex);
		user.setPwd(pwd);
		userService.saveUser(user);
		return "";	
	}
}
