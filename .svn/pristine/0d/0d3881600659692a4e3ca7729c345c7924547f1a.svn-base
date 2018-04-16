package com.hsl.clgl.pc.admin.modules.sys.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysRoleMenuEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysRoleMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 角色与菜单对应关系
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-27 12:48:09
 */
@RestController
@RequestMapping("sys/sysrolemenu")
public class SysRoleMenuController {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysrolemenu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleMenuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:sysrolemenu:info")
    public R info(@PathVariable("id") String id){
			SysRoleMenuEntity sysRoleMenu = sysRoleMenuService.selectById(id);

        return R.ok().put("sysRoleMenu", sysRoleMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysrolemenu:save")
    public R save(@RequestBody SysRoleMenuEntity sysRoleMenu){
			sysRoleMenuService.insert(sysRoleMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysrolemenu:update")
    public R update(@RequestBody SysRoleMenuEntity sysRoleMenu){
			sysRoleMenuService.updateById(sysRoleMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysrolemenu:delete")
    public R delete(@RequestBody String[] ids){
			sysRoleMenuService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
