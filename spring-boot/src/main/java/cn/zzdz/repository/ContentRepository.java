package cn.zzdz.repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

import cn.zzdz.dto.UserDto;

public class ContentRepository implements SecurityContextRepository {
//	@Autowired
//	private UserDto userdto;
	@Override
	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
		UserDto userdto=new UserDto();
		System.out.println("session:");
		Object getcontext=requestResponseHolder.getRequest().getSession().getAttribute("username");
		System.out.println("session:"+getcontext);
		if(getcontext!=null)
		{
			
			userdto.setUsername(getcontext.toString());
			System.out.println("context:");
		}
		return (SecurityContext) userdto;
	}

	@Override
	public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsContext(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return true;
	}

}
