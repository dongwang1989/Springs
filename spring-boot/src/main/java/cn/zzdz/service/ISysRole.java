package cn.zzdz.service;

import org.springframework.data.domain.Page;

import cn.zzdz.domain.SysRoleEntity;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.SysRoleDto;

public interface ISysRole {
	Page<SysRoleEntity> findRoleNoCriteria(Integer page, Integer size);

	Page<SysRoleEntity> findRoleCriteria(Integer page, Integer size, SysRoleDto roleQuery);

	public SysRoleDto findrolebyroleid(Long roleid);

	public ResultDto save(SysRoleDto role);

	public ResultDto delete(Long roleid);
	// 获取角色列表
	// public List<SysRoleDto> getRoleList();
	// 增加权限列表
	// public

}
