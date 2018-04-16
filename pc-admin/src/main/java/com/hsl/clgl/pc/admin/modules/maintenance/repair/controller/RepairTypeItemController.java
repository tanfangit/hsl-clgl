package com.hsl.clgl.pc.admin.modules.maintenance.repair.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.entity.RepairTypeItemEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.service.RepairTypeItemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 维修类别与维修项目对应关系
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-29 14:45:05
 */
@RestController
@RequestMapping("repair/repairtypeitem")
public class RepairTypeItemController {
    @Autowired
    private RepairTypeItemService repairTypeItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("repair:repairtypeitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = repairTypeItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("repair:repairtypeitem:info")
    public R info(@PathVariable("id") String id){
			RepairTypeItemEntity repairTypeItem = repairTypeItemService.selectById(id);

        return R.ok().put("repairTypeItem", repairTypeItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("repair:repairtypeitem:save")
    public R save(@RequestBody RepairTypeItemEntity repairTypeItem){
			repairTypeItemService.insert(repairTypeItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("repair:repairtypeitem:update")
    public R update(@RequestBody RepairTypeItemEntity repairTypeItem){
			repairTypeItemService.updateById(repairTypeItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("repair:repairtypeitem:delete")
    public R delete(@RequestBody String[] ids){
			repairTypeItemService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
