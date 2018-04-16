package com.hsl.clgl.pc.admin.modules.maintenance.repair.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.entity.RepairItemEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.service.RepairItemService;
import com.hsl.clgl.pc.admin.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



/**
 * 维修项目表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-29 10:02:08
 */
@RestController
@RequestMapping("repair/repairitem")
public class RepairItemController {
    @Autowired
    private RepairItemService repairItemService;
    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("repair:repairitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = repairItemService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }


    /**
     * 通过维修项目id  查询维修项目信息
     */
    @RequestMapping("/info/{repairItemId}")
    //@RequiresPermissions("repair:repairitem:info")
    public R info(@PathVariable("repairItemId") String repairItemId){
        RepairItemEntity repairItem = repairItemService.selectInfoById(repairItemId);
        return R.ok().put("repairItem", repairItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("repair:repairitem:save")
    public R save(@RequestBody RepairItemEntity repairItem){
        repairItemService.save(repairItem);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("repair:repairitem:update")
    public R update(@RequestBody RepairItemEntity repairItem){
		//	repairItemService.updateById(repairItem);
        repairItemService.updateRepairItem(repairItem);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{repairItemId}")
   // @RequiresPermissions("repair:repairitem:delete")
    public R delete(@PathVariable("repairItemId") String repairItemId){
        //删除维修项目
        RepairItemEntity  repairItemEntity=new RepairItemEntity();
        repairItemEntity.setStatus(Constant.STATUS_DELETED);
        repairItemEntity.setRepairItemId(repairItemId);
        repairItemService.updateById(repairItemEntity);
        return R.ok();
    }




}
