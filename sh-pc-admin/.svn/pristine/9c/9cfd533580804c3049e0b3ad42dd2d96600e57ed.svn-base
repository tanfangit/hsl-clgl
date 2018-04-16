package com.hsl.clgl.sh.pc.admin.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShRoleEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.shiro.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShMenuEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShMenuService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;

import javax.servlet.http.HttpServletRequest;


/**
 * 菜单
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
@RestController
@RequestMapping("sys/menu")
public class ShMenuController extends AbstractController{
    @Autowired
    private ShMenuService shMenuService;

    /**
     * 导航菜单
     */
    @RequestMapping("/nav")
    public R nav(HttpServletRequest request){
        String strDirPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
        List<ShMenuEntity> menuList = this.shMenuService.getUserRequestMenuList(getUserId(),strDirPath,ShiroUtils.getShId());
        return R.ok().put("menuList", menuList);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("sys:sysmenu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = this.shMenuService.queryPage(params);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("sys:sysmenu:info")
    public R info(@PathVariable("menuId") Long menuId){
        ShMenuEntity sysMenu = this.shMenuService.selectById(menuId);

        return R.ok().put("sysMenu", sysMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysmenu:save")
    public R save(@RequestBody ShMenuEntity sysMenu){
        this.shMenuService.insert(sysMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysmenu:update")
    public R update(@RequestBody ShMenuEntity sysMenu){
        this.shMenuService.updateById(sysMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysmenu:delete")
    public R delete(@RequestBody Long[] menuIds){
        this.shMenuService.deleteBatchIds(Arrays.asList(menuIds));

        return R.ok();
    }


    /**
     * 查询所有菜单树
     * @return
     */
    @RequestMapping("/tree")
    //@RequiresPermissions("businessmanager:sysdept:list")
    public R getMenuAll(){
        List<ShMenuEntity> list=this.shMenuService.getMenuAll(ShiroUtils.getShId());
        return R.ok().put("menusTree", list);
    }


    /**
     * 查询角色已拥有的菜单树
     * @return
     */
    @RequestMapping("/selectTree")
    //@RequiresPermissions("businessmanager:sysdept:list")
    public R getSelectMenuAll(@RequestBody ShRoleEntity sysRole){
        List<ShMenuEntity> list=this.shMenuService.getSelectMenuAll(sysRole.getMenusdList(), ShiroUtils.getShId());
        return R.ok().put("menusTree", list);
    }

}
