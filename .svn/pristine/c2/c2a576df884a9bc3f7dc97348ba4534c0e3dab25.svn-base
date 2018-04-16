package com.hsl.clgl.pc.admin.modules.sys.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysMenuEntity;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysRoleEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 菜单管理
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-03-19 20:15:55
 */
@RestController
@RequestMapping("sys/menu")
public class SysMenuController extends AbstractController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 导航菜单
     */
    @RequestMapping("/nav")
    public R nav(HttpServletRequest request){
        String strDirPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
        List<SysMenuEntity> menuList = sysMenuService.getUserRequestMenuList(getUserId(),strDirPath);
        return R.ok().put("menuList", menuList);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("sys:sysmenu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysMenuService.queryPage(params);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("sys:sysmenu:info")
    public R info(@PathVariable("menuId") Long menuId){
			SysMenuEntity sysMenu = sysMenuService.selectById(menuId);

        return R.ok().put("sysMenu", sysMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysmenu:save")
    public R save(@RequestBody SysMenuEntity sysMenu){
			sysMenuService.insert(sysMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysmenu:update")
    public R update(@RequestBody SysMenuEntity sysMenu){
			sysMenuService.updateById(sysMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysmenu:delete")
    public R delete(@RequestBody Long[] menuIds){
			sysMenuService.deleteBatchIds(Arrays.asList(menuIds));

        return R.ok();
    }


    /**
     * 查询所有菜单树
     * @return
     */
    @RequestMapping("/tree")
    //@RequiresPermissions("businessmanager:sysdept:list")
    public R getMenuAll(){
        List<SysMenuEntity> list=sysMenuService.getMenuAll();
        return R.ok().put("menusTree", list);
    }


    /**
     * 查询角色已拥有的菜单树
     * @return
     */
    @RequestMapping("/selectTree")
    //@RequiresPermissions("businessmanager:sysdept:list")
    public R getSelectMenuAll(@RequestBody SysRoleEntity sysRole){
        List<SysMenuEntity> list=sysMenuService.getSelectMenuAll(sysRole.getMenusdList());
        return R.ok().put("menusTree", list);
    }
}
