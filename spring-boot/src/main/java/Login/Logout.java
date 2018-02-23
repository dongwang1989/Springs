package Login;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Logout {
	public static 
	@RequestMapping("/logout")
	String logout(HttpSession session)
	{
		// 移除session
        session.removeAttribute("username");
		return "退出成功";
	}

}
