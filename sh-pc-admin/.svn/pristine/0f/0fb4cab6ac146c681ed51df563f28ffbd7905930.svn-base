package com.hsl.clgl.sh.pc.admin.modules.rescuelog.controller;

import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.sh.pc.admin.modules.rescuelog.entity.ShRescueLogEntity;
import com.hsl.clgl.sh.pc.admin.modules.rescuelog.service.ShRescueLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;



/**
 * 救援单日志表
 *
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-04-09 11:22:05
 */
@RestController
@RequestMapping("rescue/log")
public class ShRescueLogController {
    @Autowired
    private ShRescueLogService shRescueLogService;

    /**
     * 列表
     */
    /*@RequestMapping("/list")
    @RequiresPermissions("sys:shrescuelog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shRescueLogService.queryPage(params);

        return R.ok().put("page", page);
    }*/


    /**
     * 信息
     */
    @RequestMapping("/info/{rescueLogId}")
    //@RequiresPermissions("sys:shrescuelog:info")
    public R info(@PathVariable("rescueLogId") String rescueLogId){
			ShRescueLogEntity shRescueLog = shRescueLogService.selectById(rescueLogId);

        return R.ok().put("shRescueLog", shRescueLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("sys:shrescuelog:save")
    public R save(@RequestBody ShRescueLogEntity shRescueLog){
			shRescueLogService.save(shRescueLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:shrescuelog:update")
    public R update(@RequestBody ShRescueLogEntity shRescueLog){
			shRescueLogService.updateById(shRescueLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:shrescuelog:delete")
    public R delete(@RequestBody String[] rescueLogIds){
			shRescueLogService.deleteBatchIds(Arrays.asList(rescueLogIds));

        return R.ok();
    }

    /**
     * 通过 救援单id  查所有不分页List
     */
    @RequestMapping("/query/{rescueId}")
    //@RequiresPermissions("sys:parts:delete")
    public R selectValueListByType(@PathVariable("rescueId") String rescueId){
        List<ShRescueLogEntity> list=shRescueLogService.queryLogListById(rescueId);
        return R.ok().put("rescueLogList", list);
    }

}
