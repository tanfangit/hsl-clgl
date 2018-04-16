package com.hsl.clgl.pc.admin.modules.sys.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysDictEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysDictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 数据字典表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-29 13:39:56
 */
@RestController
@RequestMapping("/sysdict")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions(":sysdict:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDictService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions(":sysdict:info")
    public R info(@PathVariable("id") String id){
			SysDictEntity sysDict = sysDictService.selectById(id);

        return R.ok().put("sysDict", sysDict);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions(":sysdict:save")
    public R save(@RequestBody SysDictEntity sysDict){
			sysDictService.insert(sysDict);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions(":sysdict:update")
    public R update(@RequestBody SysDictEntity sysDict){
			sysDictService.updateById(sysDict);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions(":sysdict:delete")
    public R delete(@RequestBody String[] ids){
			sysDictService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 通用接口：  通过字典类型  查询字典数据
     */
    @RequestMapping("/select/{type}")
    //@RequiresPermissions("repair:repairitem:info")
    public R selectRepairPartDict(@PathVariable("type") String type){
        // RepairItemEntity repairItem = repairItemService.selectById(repairItemId);
        List<SysDictEntity> dictlist=sysDictService.selectDictListByType(type);
        return R.ok().put("dictlist", dictlist);
    }
}
