package cn.zzdz.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zzdz.domain.User;
import cn.zzdz.service.IUserService;

@RestController
public class GetUser {
	@Autowired
	IUserService userService;
	@RequestMapping("/user")
	public User getUser(@RequestParam String username) {
		System.out.println(username);
		User user = userService.findUserinfoByuser3(username);
		if(user!=null)
		{
			user.setPwd("******");
		}
		/*List<User> list=userService.findUserinfo2(username);
		System.out.println("hgf"+list);*/
		return user;
	}
}
