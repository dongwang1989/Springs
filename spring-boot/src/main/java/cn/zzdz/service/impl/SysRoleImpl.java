package cn.zzdz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import cn.zzdz.dao.RoleJpaRepository;
import cn.zzdz.domain.SysRoleEntity;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.SysRoleDto;
import cn.zzdz.service.ISysRole;

public class SysRoleImpl implements ISysRole {

	@Autowired
	private RoleJpaRepository r;

	@Override
	public Page<SysRoleEntity> findRoleNoCriteria(Integer page, Integer size) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		return r.findAll(pageable);
	}

	@Override
	public Page<SysRoleEntity> findRoleCriteria(Integer page, Integer size, SysRoleDto sysroledto) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		Page<SysRoleEntity> rolePage = r.findAll(pageable);
		// Page<SysRoleEntity> rolePage = r.findAll((Specification<SysRoleEntity>)
		// (root, query, cb) -> {
		// List<Predicate> list = new ArrayList<>();
		// if (null != sysroledto.getRoleName() && !"".equals(sysroledto.getRoleName()))
		// {
		// list.add(cb.equal(root.get("name").as(String.class),
		// sysroledto.getRoleName()));
		// }
		// list.add(cb.like(root.get("name").as(String.class),
		// sysroledto.getRoleName()));
		// Predicate[] p = new Predicate[list.size()];
		// return cb.and(list.toArray(p));
		// }, pageable);
		return rolePage;
	}

	@Override
	public SysRoleDto findrolebyroleid(Long roleid) {
		SysRoleEntity role = r.findroleinfo(roleid);
		SysRoleDto dto = new SysRoleDto();
		dto.setRole_id(role.getRole_id());
		dto.setRole_name(role.getRole_name());
		dto.setCreate_time(role.getCreate_time());
		dto.setCreate_user_id(role.getCreate_user_id());
		dto.setRemark(role.getRemark());
		return null;
	}

	@Override
	public ResultDto save(SysRoleDto role) {
		SysRoleEntity roleentity = new SysRoleEntity();
		roleentity.setRole_id(role.getRole_id());
		roleentity.setRole_name(role.getRole_name());
		roleentity.setCreate_time(role.getCreate_time());
		roleentity.setCreate_user_id(role.getCreate_user_id());
		roleentity.setRemark(role.getRemark());
		ResultDto resdto = new ResultDto();
		SysRoleEntity roleentity2 = r.save(roleentity);
		if (roleentity2 != null) {
			resdto.setResult("1");
		} else {
			resdto.setResult("0");
		}
		return resdto;
	}

	@Override
	public ResultDto delete(Long roleid) {
		r.deleteById(roleid);
		return null;
	}

}
