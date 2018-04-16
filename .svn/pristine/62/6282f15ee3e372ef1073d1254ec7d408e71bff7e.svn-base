
package com.hsl.clgl.pc.admin.modules.sys.controller;


import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysDeptEntity;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysUserEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysDeptService;
import com.hsl.clgl.pc.admin.modules.sys.service.SysUserRoleService;
import com.hsl.clgl.pc.admin.modules.sys.service.SysUserService;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author zhangqiao
 * @email
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysDeptService sysDeptService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	//@RequiresPermissions("sys:user:list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = sysUserService.queryPage(params);
		return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
	}


	/**
	 * 通过用户id 查询用户信息
	 */
	@RequestMapping("/info/{userId}")
	//@RequiresPermissions("sys:user:info")
	public R info(@PathVariable("userId") String userId){
		SysUserEntity user = sysUserService.selectById(userId);
		//获取部门名称
		SysDeptEntity sysDeptEntity=sysDeptService.selectById(user.getDept());
		//获取用户所属的角色列表
		List<String > roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);
		user.setDeptName(sysDeptEntity.getName());
		return R.ok().put("user", user);
	}




	/**
	 * 新增用户
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("businessmanager:sysrole:save")
	public R save(@RequestBody SysUserEntity sysUser){
		sysUserService.save(sysUser);
		return R.ok();
	}


	/**
	 * 删除用户
	 */
	@RequestMapping("/delete/{userId}")
	//@RequiresPermissions("sys:user:delete")
	public R delete(@PathVariable("userId") String userId){
		if(userId.equals("1")){
			return R.error("系统管理员不能删除");
		}
		if(userId.equals(ShiroUtils.getUserId())){
			return R.error("当前用户不能删除");
		}
		SysUserEntity sysUser=new SysUserEntity();
		sysUser.setUserId(userId);
		sysUser.setStatus(Constant.STATUS_DELETED);
		sysUserService.updateById(sysUser);
		return R.ok();
	}


	/**
	 * 更改用户
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("sys:user:update")
	public R update(@RequestBody SysUserEntity user){
		//ValidatorUtils.validateEntity(user, UpdateGroup.class);
		sysUserService.update(user);
		return R.ok();
	}
	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public R info(){
		return R.ok().put("user", getUser());
	}

}
