package com.hsl.clgl.pc.admin.modules.sys.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysDeptEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysDeptService;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
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
 * @date 2018-03-24 17:24:13
 */
@RestController
@RequestMapping("/sys/dept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("businessmanager:sysdept:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDeptService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }


    @RequestMapping("/tree")
    //@RequiresPermissions("businessmanager:sysdept:list")
    public R getDeptAll(){
       // PageUtils page = sysDeptService.queryPage(params);
        List<SysDeptEntity> list= sysDeptService.getDeptAll();
        return R.ok().put("depts", list);
    }



    /**
     * 通过id查询部门信息
     */
    @RequestMapping("/info/{deptId}")
    //@RequiresPermissions("businessmanager:sysdept:info")
    public R info(@PathVariable("deptId") String deptId){
        SysDeptEntity sysDept = sysDeptService.selectById(deptId);
        return R.ok().put("sysDept", sysDept);
    }

    /**
     * 新增部门信息
     */
    @RequestMapping("/save")
   // @RequiresPermissions("businessmanager:sysdept:save")
    public R save(@RequestBody SysDeptEntity sysDept){
        sysDept.setDeptId(UUIDUtil.generateUUID());
        sysDept.setCreateUser(ShiroUtils.getUserId());
        sysDept.setCreateTime(new Date());
        sysDeptService.insert(sysDept);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("businessmanager:sysdept:update")
    public R update(@RequestBody SysDeptEntity sysDept){
        //更新人
        sysDept.setUpdateUser(ShiroUtils.getUserId());
        //更新时间
        sysDept.setUpdateTime(new Date());
        sysDeptService.updateById(sysDept);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{deptId}")
    //@RequiresPermissions("businessmanager:sysdept:delete")
    public R delete(@PathVariable("deptId") String deptId){
        //sysDeptService.deleteBatchIds(Arrays.asList(deptIds));

        //判断是否有子部门
        List<String> deptList = sysDeptService.queryDetpIdList(deptId);
        if(deptList.size() > 0){
            return R.error("请先删除子部门");
        }
        SysDeptEntity  sysDeptEntity=new SysDeptEntity();
        sysDeptEntity.setDeptId(deptId);
        sysDeptEntity.setStatus(Constant.STATUS_DELETED);
        sysDeptService.updateById(sysDeptEntity);
        return R.ok();
    }

}
