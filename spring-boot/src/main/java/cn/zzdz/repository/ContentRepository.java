package cn.zzdz.repository;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

@Component("ContentRepository")
public class ContentRepository implements SecurityContextRepository {
	@Override
	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
		HttpSession session = requestResponseHolder.getRequest().getSession();
		SecurityContext getcontext = null;
		if (session == null || session.getAttribute("username") == null) {
			getcontext = generateNewContext();
		} else {// Authentication 令牌存信息用
			// Collections.emptyList();//kong list readonly not addd yanjinxiefa
			// Collections.unmodifiableList(list)//set readonly not change quanjuyingyong
			getcontext = generateNewContext();
			getcontext.setAuthentication(new UsernamePasswordAuthenticationToken(session.getAttribute("username"), "",
					Collections.emptyList()));
		}
		return getcontext;
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
