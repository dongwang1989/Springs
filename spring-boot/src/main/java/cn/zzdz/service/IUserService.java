package cn.zzdz.service;

import javax.servlet.http.HttpSession;

import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.UserDto;

public interface IUserService {

	public ResultDto getUser(UserDto userdto, HttpSession session);

	public ResultDto saveUser(UserDto userdto);

	public UserDto findUserInfoByuser(String username, HttpSession session);

	public int delUserInfo(int id);

	public ResultDto logout(HttpSession session);

	public ResultDto sayHello(HttpSession session);

	public ResultDto getHello(String param);
}
