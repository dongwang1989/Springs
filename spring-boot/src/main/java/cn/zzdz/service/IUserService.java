package cn.zzdz.service;

import java.util.List;
import javax.servlet.http.HttpSession;
import cn.zzdz.domain.User;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.UserDto;

public interface IUserService {

	public User getUser(String username, String pwd);

	public ResultDto getUser2(String username, String pwd, HttpSession session);

	public ResultDto saveUser(UserDto userdto);

	public User findUserinfoByuser(String username);

	public List<User> findUserinfo2(String username);

	public UserDto findUserinfoByuser3(String username);

	public int delUserInfo(int id);

	public ResultDto logout(HttpSession session);

	public ResultDto hello(HttpSession session);

	public ResultDto hello2(String param);

}
