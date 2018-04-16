package com.hsl.clgl.sh.pc.admin.modules.sys.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShRoleEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShRoleMenuService;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShRoleService;
import com.hsl.clgl.sh.pc.admin.modules.sys.shiro.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



/**
 * 角色
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
@RestController
@RequestMapping("sys/shrole")
public class ShRoleController {
    @Autowired
    private ShRoleService shRoleService;
    @Autowired
    ShRoleMenuService shRoleMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("sys:shrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shRoleService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }

    /**
     * 查询所有角色List
     */
    @RequestMapping("/roles")
    //@RequiresPermissions("businessmanager:sysrole:list")
    public R listRoles(){
        String shId= ShiroUtils.getShId();
        List<ShRoleEntity> list=shRoleService.queryRoleList(shId);
        return R.ok().put("roles", list);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")
   // @RequiresPermissions("sys:shrole:info")
    public R info(@PathVariable("roleId") String roleId){
        ShRoleEntity role = shRoleService.selectById(roleId);
        //查询角色对应的菜单
        List<String> menuIdList = shRoleMenuService.queryMenuIdList(roleId);
        role.setMenusdList(menuIdList);
        return R.ok().put("role", role);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
  //  @RequiresPermissions("sys:shrole:save")
    public R save(@RequestBody ShRoleEntity shRole){
        //shRoleService.insert(shRole);
        shRoleService.save(shRole);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
  //  @RequiresPermissions("sys:shrole:update")
    public R update(@RequestBody ShRoleEntity shRole){
        shRoleService.update(shRole);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{roleId}")
    //@RequiresPermissions("sys:shrole:delete")
    public R delete(@PathVariable("roleId") String roleId){
        if(roleId.equals("1")){
            return R.error("超级管理员不能删除");
        }
        shRoleService.deleteBatch(roleId);
        return R.ok();
    }

}
