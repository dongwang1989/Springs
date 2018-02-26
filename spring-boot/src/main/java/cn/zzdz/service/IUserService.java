package cn.zzdz.service;

import java.util.List;

import cn.zzdz.domain.User;

public interface IUserService {

	public User getUser(String username, String pwd);

	public List<User> findUserinfo(String username, String pwd);

	public void updateUsernameById(String username, Integer id);

	public void saveUser(User user);

	public User findUserinfoByuser(String username);

	public List<User> findUserinfo2(String username);

}
