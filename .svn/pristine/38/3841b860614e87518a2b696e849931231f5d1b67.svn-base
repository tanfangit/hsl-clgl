package com.hsl.clgl.pc.admin.modules.sys.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysRoleEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysRoleMenuService;
import com.hsl.clgl.pc.admin.modules.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



/**
 * 角色控制层
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-22 15:14:28
 */
@RestController
@RequestMapping("sys/sysrole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("businessmanager:sysrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }

    /**
     * 查询所有角色List
     */
    @RequestMapping("/roles")
    //@RequiresPermissions("businessmanager:sysrole:list")
    public R listRoles(){
        List<SysRoleEntity> list= sysRoleService.queryRoleList();
        return R.ok().put("roles", list);
    }


    /**
     * 角色信息
     */
    @RequestMapping("/info/{roleId}")
    //@RequiresPermissions("sys:role:info")
    public R info(@PathVariable("roleId") String  roleId){
        SysRoleEntity role = sysRoleService.selectById(roleId);
        //查询角色对应的菜单
        List<String> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
        role.setMenusdList(menuIdList);
        return R.ok().put("role", role);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("businessmanager:sysrole:save")
    public R save(@RequestBody SysRoleEntity sysRole){
			sysRoleService.save(sysRole);
             return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("businessmanager:sysrole:update")
    public R update(@RequestBody SysRoleEntity sysRole){
			sysRoleService.update(sysRole);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{roleId}")
    //@RequiresPermissions("businessmanager:sysrole:delete")
    public R delete(@PathVariable("roleId") String roleId){
			//sysRoleService.deleteBatchIds(Arrays.asList(roleIds));
        if(roleId.equals("1")){
            return R.error("超级管理员不能删除");
        }
        sysRoleService.deleteBatch(roleId);
        return R.ok();
    }

}
