package cn.zzdz.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zzdz.domain.User;
import cn.zzdz.domain.UserInfo;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.UserDto;
import cn.zzdz.repository.UserJpaRepository;
import cn.zzdz.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserJpaRepository userJpaRepository;

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
				userJpaRepository.save(user);
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
	public UserDto findUserInfoByuser(String username, HttpSession session) {
		UserDto userDto = new UserDto();
		if (session.getAttribute("username") != null && session.getAttribute("username").equals(username)) {
			User user = userJpaRepository.findUserInfoByuser(username);
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
		if (session.getAttribute("username") != null) {
			resultDto.setResult("退出登录！");
		} else {
			resultDto.setResult("403");
		}
		return resultDto;
	}
	@Override
	public ResultDto sayHello(HttpSession session) {
		ResultDto resultDto = new ResultDto();
		if (session.getAttribute("username") != null) {
			resultDto.setResult("Hello World");
		} else {
			resultDto.setResult("403");
		}
		return resultDto;
	}
//	@Override
//	public ResultDto sayHello(HttpSession session) {
//		ResultDto resultDto = new ResultDto();
//		if (session.getAttribute("username") != null) {
//			resultDto.setResult("Hello World");
//		} else {
//			resultDto.setResult("403");
//		}
//		return resultDto;
//	}

	@Override
	public ResultDto getHello(String param) {
		ResultDto resultDto = new ResultDto();
		resultDto.setResult(param);
		return resultDto;
	}

	@Override
	public UserInfo log(String username) {
		
		UserInfo userinfo=null;
		User user = userJpaRepository.findUserInfoByuser(username);//findUserinfoBylog
		System.out.println(user.getName());
		if(user!=null)
		{
			userinfo = new UserInfo(user.getName(), user.getAge(), user.getSex(), user.getUsername(), user.getPwd());
		}
		
		return userinfo;
	}

}
