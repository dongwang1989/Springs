package cn.zzdz.usercontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cd.zzdz.permission.IPermission;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.UserDto;
import cn.zzdz.service.IUserService;

@RestController
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResultDto log(@RequestBody UserDto userdtolog, HttpSession session) {
		return userService.getUser(userdtolog, session);
	}

	@RequestMapping("/user")
	public UserDto getUser(@RequestParam String username) {
		return userService.findUserInfoByuser(username);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResultDto register(@RequestBody UserDto userdto) {
		return userService.saveUser(userdto);
	}

	@RequestMapping("/loginout")
	public ResultDto logout(HttpSession session) {
		return userService.logout(session);
	}

	@IPermission("who")
	@RequestMapping("/whoim")
	public String whoIm() {
		System.out.println("进入whoim");
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}

	// @RequestMapping("/whoim2")
	// public User whoIm2(HttpSession session) {
	// User user = userService.findUserPermission(1);
	// session.setAttribute("username", "zhangsan");
	// session.setAttribute("permission", user.getPermission());
	// return user;
	// }

	@IPermission("hello")
	@RequestMapping("/hello")
	public ResultDto sayHello() {
		return userService.sayHello();
	}

	@IPermission("hello2")
	@RequestMapping("/hello/{param}")
	public ResultDto getHello(@PathVariable String param) {
		return userService.getHello(param);
	}

	@RequestMapping("/exception/checked")
	public void checkedException() throws Exception {
		throw new Exception("A");
	}

	@RequestMapping("/exception/runtime")
	public void runtimeException() {
		throw new RuntimeException("B");
	}

}
