package cn.zzdz.login;

import java.util.List;

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
	public List<User> getUser(@RequestParam String username) {
		List<User> list=userService.findUserinfo2(username);
		System.out.println("hgf"+list);
		return list;
	}
}
