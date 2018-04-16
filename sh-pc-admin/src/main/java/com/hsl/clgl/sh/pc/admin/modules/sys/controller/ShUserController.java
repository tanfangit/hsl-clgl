package com.hsl.clgl.sh.pc.admin.modules.sys.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShDeptEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShUserEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShDeptService;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShUserRoleService;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShUserService;
import com.hsl.clgl.sh.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.sh.pc.admin.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



/**
 * 商户用户表
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 15:49:01
 */
@RestController
@RequestMapping("sys/shuser")
public class ShUserController {
    @Autowired
    private ShUserService shUserService;
    @Autowired
    private  ShDeptService  shDeptService;
    @Autowired
    private ShUserRoleService shUserRoleService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:shuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shUserService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    //@RequiresPermissions("sys:shuser:info")
    public R info(@PathVariable("userId") String userId){
        ShUserEntity user = shUserService.selectById(userId);
        //获取部门名称
        ShDeptEntity sysDeptEntity=shDeptService.selectById(user.getDept());
        //获取用户所属的角色列表
        List<String > roleIdList = shUserRoleService.queryRoleIdList(userId);
        user.setRoleIdList(roleIdList);
        user.setDeptName(sysDeptEntity.getName());
        return R.ok().put("user", user);

    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("sys:shuser:save")
    public R save(@RequestBody ShUserEntity shUser){
        shUserService.save(shUser);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:shuser:update")
    public R update(@RequestBody ShUserEntity shUser){
        shUserService.update(shUser);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{userId}")
   // @RequiresPermissions("sys:shuser:delete")
    public R delete(@PathVariable("userId") String userId){
        if(userId.equals("1")){
            return R.error("超级管理员不能删除");
        }
        if(userId.equals(ShiroUtils.getUserId())){
            return R.error("当前用户不能删除");
        }
        ShUserEntity sysUser=new ShUserEntity();
        sysUser.setUserId(userId);
        sysUser.setStatus(Constant.STATUS_DELETED);
        shUserService.updateById(sysUser);
        return R.ok();
    }

}
