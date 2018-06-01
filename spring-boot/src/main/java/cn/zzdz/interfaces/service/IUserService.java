package cn.zzdz.interfaces.service;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import cn.zzdz.domain.User;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.UserDto;

public interface IUserService {

	public ResultDto getUser(UserDto userdto, HttpSession session);

	public ResultDto saveUser(UserDto userdto);

	public UserDto findUserInfoByuser(String username);

	public int delUserInfo(int id);

	public ResultDto logout(HttpSession session);

	public ResultDto sayHello();

	public ResultDto getHello(String param);

	public User findUserPermission(Integer id);

	// @Cacheable(value = "users")
	public Set<String> cafindUserInfoByuser(String username);

	public List<User> Likenames(String username);
}
