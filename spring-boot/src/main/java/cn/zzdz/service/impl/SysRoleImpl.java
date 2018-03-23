package cn.zzdz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import cn.zzdz.dao.RoleJpaRepository;
import cn.zzdz.domain.SysRoleEntity;
import cn.zzdz.dto.SysRoleDto;
import cn.zzdz.service.ISysRole;

public class SysRoleImpl implements ISysRole {

	@Autowired
	private RoleJpaRepository r;

	@Override
	public Page<SysRoleEntity> findBookNoCriteria(Integer page, Integer size) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		return r.findAll(pageable);
	}

	@Override
	public Page<SysRoleEntity> findBookCriteria(Integer page, Integer size, SysRoleDto bookQuery) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		Page<SysRoleEntity> bookPage = r.findAll(new Specification<SysRoleEntity>() {
			
			@Override
			public Predicate toPredicate(Root<SysRoleEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				 List<Predicate> list = new ArrayList<Predicate>();  
	                if(null!=bookQuery.getRoleName()&&!"".equals(bookQuery.getRoleName())){  
	                    list.add(cb.equal(root.get("name").as(String.class), bookQuery.getRoleName()));  
	                }  
	                Predicate[] p = new Predicate[list.size()];  
	                return cb.and(list.toArray(p));  
			}
		}, pageable);
		return bookPage;
	}

}
