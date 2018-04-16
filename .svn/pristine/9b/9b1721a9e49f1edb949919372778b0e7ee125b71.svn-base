package com.hsl.clgl.pc.admin.modules.dictionary.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.dictionary.entity.SysDictValueEntity;
import com.hsl.clgl.pc.admin.modules.dictionary.service.SysDictValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 数据字典值表
 *
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-04-03 09:17:13
 */
@RestController
@RequestMapping("dicvalue")
public class SysDictValueController {
    @Autowired
    private SysDictValueService sysDictValueService;

    /**
     * 根据字典类型id查其存在的值
     */
    @RequestMapping("/list")
     //@RequiresPermissions("sys:sysdictvalue:list")
    public R list(@RequestParam Map<String, Object> params){
        if(params.get("key[parentId]")!=null){
            String parentId = params.get("key[parentId]").toString();
            params.put("parentId",parentId);
        }
        PageUtils page = sysDictValueService.queryPage(params);

        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
   // @RequiresPermissions("sys:sysdictvalue:info")
    public R info(@PathVariable("id") String id){
			SysDictValueEntity sysDictValue = sysDictValueService.selectById(id);

        return R.ok().put("sysDictValue", sysDictValue);
    }

    /**
     * 新增保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("sys:sysdictvalue:save")
    public R save(@RequestBody SysDictValueEntity sysDictValue){
			sysDictValueService.save(sysDictValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("sys:sysdictvalue:update")
    public R update(@RequestBody SysDictValueEntity sysDictValue){
			sysDictValueService.updateById(sysDictValue);

        return R.ok();
    }

    /**
     * 单条删除
     */
    @RequestMapping("/delete/{Id}")
    //@RequiresPermissions("sys:parts:delete")
    public R delete(@PathVariable("Id") String Id){
        sysDictValueService.deleteById(Id);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("sys:sysdictvalue:delete")
    public R delete(@RequestBody String[] ids){
			sysDictValueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }




    /**
     * 通过字典类型查询  所属字典值List
     */
    @RequestMapping("/query/{typeId}")
    //@RequiresPermissions("sys:parts:delete")
    public R selectValueListByType(@PathVariable("typeId") String typeId){
        List<SysDictValueEntity> list=sysDictValueService.selectValueListByType(typeId);
        return R.ok().put("dictValueList", list);
    }

}
