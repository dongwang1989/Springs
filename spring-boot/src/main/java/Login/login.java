package Login;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@SpringBootApplication
public class login {
	

	@RequestMapping("/login/{username}/{pwd}")//@PathVariable String username,@PathVariable String pwd
	 public String log(@PathVariable("username") String username,@PathVariable("pwd") String pwd, HttpSession session)
	{
		
		String values;
		Object strses=session.getAttribute("username");
		if(strses!=null&&!strses.equals(""))
		{
			values = "当前账号"+session.getAttribute("username")+"已经登陆！";
			
		}
		else {
			System.out.println("aaa"+username+pwd);
			if(username.equals("zhangsan")&&pwd.equals("123"))
			{
				System.out.println("succe");
				values = "登陆成功";
				session.setAttribute("username", username);
			}
			else
			{
				values = "登陆error";
			}
		}
		return values;
	}

	
	public static void main(String[] args) {
		SpringApplication.run(login.class, args);
	}
}
