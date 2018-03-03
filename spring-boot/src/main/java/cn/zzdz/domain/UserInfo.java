package cn.zzdz.domain;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfo implements Serializable,UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	private String name;
	private int age;
	private String sex;
	private String username;
	private String pwd;
	//public UserInfo() {}
	public UserInfo(String name,int age,String sex,String username,String pwd)
	{
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.username=username;
		this.pwd=pwd;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getSex() {
		return sex;
	}
	public String getPwd() {
		return pwd;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return AuthorityUtils.commaSeparatedStringToAuthorityList("1");
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pwd;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
