package cn.zzdz.login;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
	public UserDto getUser(@RequestParam String username,HttpSession session) {
		return userService.findUserInfoByuser(username,session);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResultDto register(@RequestBody UserDto userdto) {
		return userService.saveUser(userdto);
	}

	@RequestMapping("/logout")
	public ResultDto logout(HttpSession session) {
		return userService.logout(session);
	}
}
