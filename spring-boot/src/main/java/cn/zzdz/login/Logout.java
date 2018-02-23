package cn.zzdz.login;

import javax.servlet.http.HttpSession;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Logout {
	 @RequestMapping("/logout") 
	 String logout(HttpSession session) {
		session.removeAttribute("username");
		return "退出成功";
	}

}
