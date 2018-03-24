package cn.zzdz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.zzdz.domain.SysRoleEntity;
import cn.zzdz.dto.SysRoleDto;

public interface RoleJpaRepository extends JpaRepository<SysRoleEntity, Long>, JpaSpecificationExecutor<SysRoleDto> {
	// @Query("from SysRole u where u.username=:username and u.pwd=:pwd")
	// public List<SysRoleEntity> getRoleList();
	@Query("from sys_role u  where u.role_id=:id")
	public SysRoleEntity findroleinfo(@Param("role_id") Long role_id);
}
