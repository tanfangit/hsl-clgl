package com.hsl.clgl.sh.pc.admin.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShRoleMenuEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShRoleMenuService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;



/**
 * 角色与菜单对应关系
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
@RestController
@RequestMapping("sys/shrolemenu")
public class ShRoleMenuController {
    @Autowired
    private ShRoleMenuService shRoleMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:shrolemenu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shRoleMenuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:shrolemenu:info")
    public R info(@PathVariable("id") String id){
			ShRoleMenuEntity shRoleMenu = shRoleMenuService.selectById(id);

        return R.ok().put("shRoleMenu", shRoleMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:shrolemenu:save")
    public R save(@RequestBody ShRoleMenuEntity shRoleMenu){
			shRoleMenuService.insert(shRoleMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:shrolemenu:update")
    public R update(@RequestBody ShRoleMenuEntity shRoleMenu){
			shRoleMenuService.updateById(shRoleMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:shrolemenu:delete")
    public R delete(@RequestBody String[] ids){
			shRoleMenuService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
