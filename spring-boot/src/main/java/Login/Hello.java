package Login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

@RestController
@SpringBootApplication
public class Hello {
	@RequestMapping("/hello")
	 public String hello(HttpSession session){
		String values="403";
		Object strses=session.getAttribute("username");
		if(strses!=null&&!strses.equals(""))
		{
			Map<String, String> ma = new HashMap<String, String>();
			ma.put("result", "Hello World");
			JSONObject jsonObject = JSONObject.fromObject(ma);  
		    values=jsonObject.toString();
		    System.out.println(values);
		}
	     return values;
	 }

}
