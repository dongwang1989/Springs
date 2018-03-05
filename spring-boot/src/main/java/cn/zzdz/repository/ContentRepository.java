package cn.zzdz.repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

@Component("ContentRepository")
public class ContentRepository implements SecurityContextRepository {
	@Override
	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
		Object getcontext = requestResponseHolder.getRequest().getSession().getAttribute("username");
		System.out.println("session:" + getcontext);
		if (getcontext == null) {
			getcontext = generateNewContext();
		}
		return (SecurityContext) getcontext;
	}

	@Override
	public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
	}

	@Override
	public boolean containsContext(HttpServletRequest request) {
		return true;
	}

	protected SecurityContext generateNewContext() {
		return SecurityContextHolder.createEmptyContext();
	}
}
