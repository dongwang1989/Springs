package cn.zzdz.login;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
	@RequestMapping(value="/login",method=RequestMethod.POST) // @PathVariable String username,@PathVariable String pwd
	public String log(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "pwd", required = true) String pwd, HttpSession session) {
		String values;
		Object strses = session.getAttribute("username");
		if (strses != null && !strses.equals("")) {
			values = "当前账号" + session.getAttribute("username") + "已经登陆！";
		} else {
			System.out.println("aaa" + username + pwd);
			if (username.equals("zhangsan") && pwd.equals("123")) {
				System.out.println("succe");
				values = "登陆成功";
				session.setAttribute("username", username);
			} else {
				values = "登陆error";
			}
		}
		return values;
	}
}
