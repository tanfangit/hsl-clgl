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

import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShUserRoleEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShUserRoleService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;



/**
 * 用户与角色对应关系
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
@RestController
@RequestMapping("sys/shuserrole")
public class ShUserRoleController {
    @Autowired
    private ShUserRoleService shUserRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:shuserrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shUserRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:shuserrole:info")
    public R info(@PathVariable("id") String id){
			ShUserRoleEntity shUserRole = shUserRoleService.selectById(id);

        return R.ok().put("shUserRole", shUserRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:shuserrole:save")
    public R save(@RequestBody ShUserRoleEntity shUserRole){
			shUserRoleService.insert(shUserRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:shuserrole:update")
    public R update(@RequestBody ShUserRoleEntity shUserRole){
			shUserRoleService.updateById(shUserRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:shuserrole:delete")
    public R delete(@RequestBody String[] ids){
			shUserRoleService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
