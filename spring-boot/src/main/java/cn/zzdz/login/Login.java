package cn.zzdz.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zzdz.domain.User;
import cn.zzdz.service.IUserService;

@RestController
public class Login {
	/**
	 * 其中接受参数用RequestBody或RequestParam都可以
	 * 
	 * @param username
	 * @param pwd
	 * @param session
	 * @return
	 */
	@Autowired
	IUserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST) // @PathVariable String username,@PathVariable String
																	// // pwd
	public String log(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "pwd", required = true) String pwd, HttpSession session) {
		String values;
		Object strses = session.getAttribute("username");
		if (strses != null && !strses.equals("")) {
			values = "当前账号" + session.getAttribute("username") + "已经登陆！";
		} else {
			User user=userService.getUser(username, pwd);
			if (user!= null) {
				values = "登陆成功";
				session.setAttribute("username",user.getUsername());
			} else {
				values = "登陆error";
			}
		}
		return values;
	}
}
