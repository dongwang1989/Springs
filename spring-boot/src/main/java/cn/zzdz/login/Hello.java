package cn.zzdz.login;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.service.IUserService;

@RestController
public class Hello {
	@Autowired
	IUserService userservice;

	/*
	 * @PathVariable获取占位符
	 * 
	 * @RequestParam获取参数get/post都可以Content-Type: 为
	 * application/x-www-form-urlencoded(http请求中默认)
	 * 
	 * @RequestBody不允许get允许post 一般处理非Content-Type: 为
	 * application/x-www-form-urlencoded(http请求中默认)
	 */
	@RequestMapping("/hello")
	public ResultDto hello(HttpSession session) {
		return userservice.hello(session);
	}

	@RequestMapping("/hello/{param}")
	public ResultDto hello2(@PathVariable String param) {
		return userservice.hello2(param);
	}

}
