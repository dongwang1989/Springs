package cn.zzdz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zzdz.domain.User;
import cn.zzdz.repository.UserJpaRepository;
import cn.zzdz.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserJpaRepository userJpaRepository;

	@Override
	public List<User> findUserinfo(String username, String pwd) {
		userJpaRepository.findUserinfo(username, pwd);
		return null;
	}

	public void saveUser(User user) {
		userJpaRepository.save(user);
	}

	@Override
	public void updateUsernameById(String username, Integer id) {
		// TODO Auto-generated method stub

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
	public List<User> findUserinfo2(String username) {
		return userJpaRepository.findUserinfo2(username);
	}

	@Override
	public User findUserinfoByuser3(String username) {
		// TODO Auto-generated method stub
		return userJpaRepository.findUserinfoByuser3(username);
	}

	@Override
	public void delUserInfo(String id) {
		// TODO Auto-generated method stub
		userJpaRepository.delUserInfo(id);
	}

	

}
