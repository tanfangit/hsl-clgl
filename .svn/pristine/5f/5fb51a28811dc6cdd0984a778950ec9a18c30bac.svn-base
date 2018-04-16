package com.hsl.clgl.sh.pc.admin.modules.sys.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShDeptEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShDeptService;
import com.hsl.clgl.sh.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.sh.pc.admin.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * 部门表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-03 10:15:08
 */
@RestController
@RequestMapping("sys/shdept")
public class ShDeptController {
    @Autowired
    private ShDeptService shDeptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("sys:shdept:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shDeptService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }


    @RequestMapping("/tree")
    //@RequiresPermissions("businessmanager:sysdept:list")
    public R getDeptAll(){
        List<ShDeptEntity> list= shDeptService.getDeptAll();
        return R.ok().put("depts", list);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{deptId}")
    //@RequiresPermissions("sys:shdept:info")
    public R info(@PathVariable("deptId") String deptId){
			ShDeptEntity shDept = shDeptService.selectById(deptId);

        return R.ok().put("shDept", shDept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:shdept:save")
    public R save(@RequestBody ShDeptEntity shDept){
        //商户id
        String shId=ShiroUtils.getShId();
        shDept.setShId(shId);
        shDept.setDeptId(UUIDUtil.generateUUID());
        shDept.setCreateUser(ShiroUtils.getUserId());
        shDept.setCreateTime(new Date());
        shDeptService.insert(shDept);
        return R.ok();

    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:shdept:update")
        public R update(@RequestBody ShDeptEntity shDept){
        //更新人
        shDept.setUpdateUser(ShiroUtils.getUserId());
        //更新时间
        shDept.setUpdateTime(new Date());
        shDeptService.updateById(shDept);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{deptId}")
   // @RequiresPermissions("sys:shdept:delete")
    public R delete(@PathVariable("deptId") String deptId){
        //判断是否有子部门
        List<String> deptList = shDeptService.queryDetpIdList(deptId);
        if(deptList.size() > 0){
            return R.error("请先删除子部门");
        }
        ShDeptEntity  shDeptEntity=new ShDeptEntity();
        shDeptEntity.setDeptId(deptId);
        shDeptEntity.setStatus(Constant.STATUS_DELETED);
        shDeptService.updateById(shDeptEntity);
        return R.ok();
    }

}
