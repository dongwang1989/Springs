package cn.zzdz.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cd.zzdz.permission.IPermission;
import cn.zzdz.domain.SysRoleEntity;
import cn.zzdz.service.ISysRole;

@RestController
@RequestMapping("/sys/role")
public class RoleController {

	@Autowired
	private ISysRole sysrole;

	@GetMapping("/list")
	@IPermission("getrolelist")
	public void getrolelist(@RequestParam Integer page, @RequestParam Integer size) {

		Page<SysRoleEntity> pages = sysrole.findBookNoCriteria(page, size);
		// 如果不是超级管理员，则只查询自己创建的角色列表
		// if(getUserId() != Constant.SUPER_ADMIN){
		// params.put("createUserId", getUserId());
		// }

		// PageUtils page = sysRoleService.queryPage(params);

		// return R.ok().put("page", page);
	}

	// /**
	// * 角色列表
	// */
	// @GetMapping("/select")
	// @RequiresPermissions("sys:role:select")
	// public R select(){
	// Map<String, Object> map = new HashMap<>();
	//
	// //如果不是超级管理员，则只查询自己所拥有的角色列表
	// if(getUserId() != Constant.SUPER_ADMIN){
	// map.put("createUserId", getUserId());
	// }
	// List<SysRoleEntity> list = sysRoleService.selectByMap(map);
	//
	// return R.ok().put("list", list);
	// }
	//
	// /**
	// * 角色信息
	// */
	// @GetMapping("/info/{roleId}")
	// @RequiresPermissions("sys:role:info")
	// public R info(@PathVariable("roleId") Long roleId){
	// SysRoleEntity role = sysRoleService.selectById(roleId);
	//
	// //查询角色对应的菜单
	// List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
	// role.setMenuIdList(menuIdList);
	//
	// return R.ok().put("role", role);
	// }
	//
	// /**
	// * 保存角色
	// */
	// @SysLog("保存角色")
	// @PostMapping("/save")
	// @RequiresPermissions("sys:role:save")
	// public R save(@RequestBody SysRoleEntity role){
	// ValidatorUtils.validateEntity(role);
	//
	// role.setCreateUserId(getUserId());
	// sysRoleService.save(role);
	//
	// return R.ok();
	// }
	//
	// /**
	// * 修改角色
	// */
	// @SysLog("修改角色")
	// @PostMapping("/update")
	// @RequiresPermissions("sys:role:update")
	// public R update(@RequestBody SysRoleEntity role){
	// ValidatorUtils.validateEntity(role);
	//
	// role.setCreateUserId(getUserId());
	// sysRoleService.update(role);
	//
	// return R.ok();
	// }
	//
	// /**
	// * 删除角色
	// */
	// @SysLog("删除角色")
	// @PostMapping("/delete")
	// @RequiresPermissions("sys:role:delete")
	// public R delete(@RequestBody Long[] roleIds){
	// sysRoleService.deleteBatch(roleIds);
	//
	// return R.ok();
	// }
}
