package com.hsl.clgl.sh.pc.admin.modules.dictionary.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.sh.pc.admin.modules.dictionary.entity.SysDictTypeEntity;
import com.hsl.clgl.sh.pc.admin.modules.dictionary.service.SysDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 数据字典类型表
 *
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-04-02 15:10:26
 */
@RestController
@RequestMapping("sys/dictype")
public class SysDictTypeController {
    @Autowired
    private SysDictTypeService sysDictTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:sysdicttype:list")
    public R list(@RequestParam Map<String, Object> params){
        if(params.get("key[dicName]")!=null){
            String dicName = params.get("key[dicName]").toString();
            params.put("name",dicName);
        }
        PageUtils page = sysDictTypeService.queryPage(params);

        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:sysdicttype:info")
    public R info(@PathVariable("id") String id){
			SysDictTypeEntity sysDictType = sysDictTypeService.selectById(id);

        return R.ok().put("sysDictType", sysDictType);
    }

    /**
     * 新增保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:sysdicttype:save")
    public R save(@RequestBody SysDictTypeEntity sysDictType){
			sysDictTypeService.save(sysDictType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:sysdicttype:update")
    public R update(@RequestBody SysDictTypeEntity sysDictType){
			sysDictTypeService.update(sysDictType);

        return R.ok();
    }

    /**
     * 单条删除
     */
    @RequestMapping("/delete/{Id}")
    //@RequiresPermissions("sys:parts:delete")
    public R delete(@PathVariable("Id") String Id){
        sysDictTypeService.delete(Id);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysdicttype:delete")
    public R delete(@RequestBody String[] ids){
			sysDictTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
