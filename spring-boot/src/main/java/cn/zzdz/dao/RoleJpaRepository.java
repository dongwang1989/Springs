package cn.zzdz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.zzdz.domain.SysRoleEntity;

public interface RoleJpaRepository extends JpaRepository<SysRoleEntity, Long>, JpaSpecificationExecutor<SysRoleEntity> {
	// @Query("from SysRole u where u.username=:username and u.pwd=:pwd")
	// public List<SysRoleEntity> getRoleList();

}
