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

	@RequestMapping("/whoim")
	public String whoIm() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}

	@RequestMapping("/hello")
	public ResultDto sayHello() {
		return userService.sayHello();
	}

	@RequestMapping("/hello/{param}")
	public ResultDto getHello(@PathVariable String param, HttpSession session) {
		session.setAttribute("username", "zhangsan");
		return userService.getHello(param);
	}

}
