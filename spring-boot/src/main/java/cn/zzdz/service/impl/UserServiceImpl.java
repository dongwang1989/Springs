package cn.zzdz.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@Override
	public ResultDto saveUser(UserDto userDto) {
		ResultDto resultDto = new ResultDto();
		if (userJpaRepository.findUserinfoBylog(userDto.getUsername()) == null) {
			User user = new User();
			user.setAge(userDto.getAge());
			user.setName(userDto.getName());
			user.setUsername(user.getUsername());
			user.setSex(user.getSex());
			user.setPwd(user.getPwd());
			try {
				User us = userJpaRepository.save(user);

				System.out.println(us);
				resultDto.setResult("1");
			} catch (Exception e) {
				resultDto.setResult("0");
			}
		} else {
			resultDto.setResult("-1");
		}
		return resultDto;
	}

	@Override
	public ResultDto getUser(UserDto userDtolog, HttpSession session) {
		ResultDto resultDto = new ResultDto();
		String strses = session.getAttribute("username").toString();
		if (strses != null && !strses.equals("")) {
			resultDto.setResult("当前账号" + session.getAttribute("username") + "已经登陆！");
		} else {
			User user = userJpaRepository.getUser(userDtolog.getUsername(), userDtolog.getPwd());
			if (user != null) {
				resultDto.setResult("登陆成功");
				session.setAttribute("username", user.getUsername());
			} else {
				resultDto.setResult("登陆error");
			}
		}
		return resultDto;
	}

	@Override
	public UserDto findUserInfoByuser(String username) {
		UserDto userDto = new UserDto();
		String usernamea = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		User user = userJpaRepository.findUserInfoByuser(usernamea);
		if (user != null) {
			userDto.setName(user.getName());
			userDto.setAge(user.getAge());
			userDto.setSex(user.getSex());
			userDto.setUsername(user.getUsername());
			userDto.setPwd("***");
		}
		return userDto;
	}

	@Transactional
	@Override
	public int delUserInfo(int id) {
		return userJpaRepository.delUserInfo(id);
	}

	@Override
	public ResultDto logout(HttpSession session) {
		ResultDto resultDto = new ResultDto();
		session.removeAttribute("username");
		resultDto.setResult("退出登录！");
		return resultDto;
	}

	@Override
	public ResultDto sayHello() {
		ResultDto resultDto = new ResultDto();
		resultDto.setResult("Hello World");
		return resultDto;
	}

	@Override
	public ResultDto getHello(String param) {
		ResultDto resultDto = new ResultDto();
		resultDto.setResult(param);
		return resultDto;
	}

}
