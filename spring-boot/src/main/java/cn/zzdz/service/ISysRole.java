package cn.zzdz.service;

import org.springframework.data.domain.Page;

import cn.zzdz.domain.SysRoleEntity;
import cn.zzdz.dto.SysRoleDto;

public interface ISysRole {
	Page<SysRoleEntity> findBookNoCriteria(Integer page, Integer size);

	Page<SysRoleEntity> findBookCriteria(Integer page, Integer size, SysRoleDto bookQuery);
	// 获取角色列表
	// public List<SysRoleDto> getRoleList();
	// 增加权限列表
	// public

}
