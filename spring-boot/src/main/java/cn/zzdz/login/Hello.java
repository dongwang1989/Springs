package cn.zzdz.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class Hello {
	/*
	 * @PathVariable获取占位符
	 * @RequestParam获取参数get/post都可以Content-Type: 为 application/x-www-form-urlencoded(http请求中默认)
	 * @RequestBody不允许get允许post 一般处理非Content-Type: 为 application/x-www-form-urlencoded(http请求中默认)
	 * */
	@RequestMapping("/hello")
	public String hello(HttpSession session) {
		String values = "403";
		Object strses = session.getAttribute("username");
		if (strses != null && !strses.equals("")) {
			Map<String, String> ma = new HashMap<String, String>();
			ma.put("result", "Hello World");
			JSONObject jsonObject = JSONObject.fromObject(ma);
			values = jsonObject.toString();
			System.out.println(values);
		}
		return values;
	}
	@RequestMapping("/hello/{param}")
	public Map<String, String> hello2(@PathVariable String param) {
		Map<String, String> ma = new HashMap<String, String>();
		ma.put("result", param);
		return ma;
	}

}
