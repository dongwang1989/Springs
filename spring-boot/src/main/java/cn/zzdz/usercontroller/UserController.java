package cn.zzdz.usercontroller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
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

	// 修改用户信息
	@RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
	public ResultDto updateuser(@RequestBody UserDto userdto) {
		return userService.saveUser(userdto);
	}

	@RequestMapping("/loginout")
	public ResultDto logout(HttpSession session) {
		"".equals("");
		return userService.logout(session);
	}

	@IPermission("who")
	@RequestMapping("/whoim")
	public String whoIm() {
		System.out.println("进入whoim");
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}

	@RequestMapping("/whoim2")
	public Set<String> whoIm2(HttpSession session) {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		System.out.println(md5.encodePassword("123", "wd"));
		Set<String> set = new HashSet<>();
		set = userService.cafindUserInfoByuser("zhangsan");
		session.setAttribute("username", "zhangsan");
		return set;
	}

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
