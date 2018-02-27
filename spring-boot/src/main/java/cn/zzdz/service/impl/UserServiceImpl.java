package cn.zzdz.service.impl;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.zzdz.domain.User;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.UserDto;
import cn.zzdz.repository.UserJpaRepository;
import cn.zzdz.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserJpaRepository userJpaRepository;
	@Autowired
	private ResultDto resultdto;
	@Autowired
	private UserDto userdto;
	public ResultDto saveUser(UserDto userdto) {
		if (userJpaRepository.findUserinfoByuser(userdto.getUsername()) == null) {
			User user = new User();
			user.setAge(userdto.getAge());
			user.setName(userdto.getName());
			user.setUsername(user.getUsername());
			user.setSex(user.getSex());
			user.setPwd(user.getPwd());
			try {
				userJpaRepository.save(user);
				resultdto.setResult("1");
			} catch (Exception e) {
				resultdto.setResult("0");
			}
		} else {
			resultdto.setResult("-1");
		}
		return resultdto;
	}


	@Override
	public User findUserinfoByuser(String username) {
		return userJpaRepository.findUserinfoByuser(username);
	}

	@Override
	public User getUser(String username, String pwd) {
		return userJpaRepository.getUser(username, pwd);
	}

	@Override
	public ResultDto getUser2(String username, String pwd, HttpSession session) {
		Object strses = session.getAttribute("username");
		if (strses != null && !strses.equals("")) {
			resultdto.setResult("当前账号" + session.getAttribute("username") + "已经登陆！");
		} else {
			User user = userJpaRepository.getUser(username, pwd);
			if (user != null) {
				resultdto.setResult("登陆成功");
				session.setAttribute("username", user.getUsername());
			} else {
				resultdto.setResult("登陆error");
			}
		}
		return resultdto;
	}

	@Override
	public List<User> findUserinfo2(String username) {
		return userJpaRepository.findUserinfo2(username);
	}

	@Override
	public UserDto findUserinfoByuser3(String username) {
		User user = userJpaRepository.findUserinfoByuser3(username);
		userdto.setName(user.getName());
		userdto.setAge(user.getAge());
		userdto.setSex(user.getSex());
		userdto.setUsername(user.getUsername());
		userdto.setPwd("***");
		return userdto;
	}

	@Transactional
	@Override
	public int delUserInfo(int id) {
		return userJpaRepository.delUserInfo(id);
	}

	@Override
	public ResultDto logout(HttpSession session) {
		session.removeAttribute("username");
		resultdto.setResult("退出登录！");
		return resultdto;
	}
	
	@Override
	public ResultDto hello(HttpSession session) {
		Object strses = session.getAttribute("username");
		if (strses != null && !strses.equals("")) {
			resultdto.setResult("Hello World");
		}
		else
		{
			resultdto.setResult("403");
		}
		return resultdto;
	}

	@Override
	public ResultDto hello2(String param) {
		resultdto.setResult(param);
		return resultdto;
	}

}
