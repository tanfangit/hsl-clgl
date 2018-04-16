package com.hsl.clgl.pc.admin.modules.maintenance.repair.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.entity.RepairTypeEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.service.RepairTypeService;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * 维修类别表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-28 18:28:55
 */
@RestController
@RequestMapping("repair/repairtype")
public class RepairTypeController {
    @Autowired
    private RepairTypeService repairTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("repair:repairtype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = repairTypeService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }


    /**
     * 查询所有维修类别
     */
    @RequestMapping("/all")
    //@RequiresPermissions("repair:repairtype:list")
    public R getAllRepairType(){
        List<RepairTypeEntity> list=repairTypeService.getAllRepairType();
        return R.ok().put("allRepairType", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{repairTypeId}")
    //@RequiresPermissions("repair:repairtype:info")
    public R info(@PathVariable("repairTypeId") String repairTypeId){
        RepairTypeEntity repairType = repairTypeService.selectById(repairTypeId);
        return R.ok().put("repairType", repairType);
    }

    /**
     * 新增
     */
    @RequestMapping("/save")
   // @RequiresPermissions("repair:repairtype:save")
    public R save(@RequestBody RepairTypeEntity repairType){
        repairType.setRepairTypeId(UUIDUtil.generateUUID());
        repairType.setCreateUser(ShiroUtils.getUserId());
        //生成维修类别编号
        String typeNo=Constant.WXLB+"-"+UUIDUtil.generate16UUID();
        repairType.setRepairTypeNo(typeNo);
        repairTypeService.insert(repairType);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("repair:repairtype:update")
    public R update(@RequestBody RepairTypeEntity repairType){
        repairType.setUpdateTime(new Date());
        repairType.setUpdateUser(ShiroUtils.getUserId());
        repairTypeService.updateById(repairType);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{repairTypeId}")
    //@RequiresPermissions("repair:repairtype:delete")
    public R delete(@PathVariable("repairTypeId") String repairTypeId){
			//repairTypeService.deleteBatchIds(Arrays.asList(repairTypeIds));
        RepairTypeEntity  repairTypeEntity=new RepairTypeEntity();
        repairTypeEntity.setRepairTypeId(repairTypeId);
        repairTypeEntity.setStatus(Constant.STATUS_DELETED);
        repairTypeService.updateById(repairTypeEntity);
        return R.ok();
    }

}
