package com.hsl.clgl.sh.pc.admin.modules.rescue.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.sh.pc.admin.modules.rescue.entity.ShRescueOrderEntity;
import com.hsl.clgl.sh.pc.admin.modules.rescue.service.ShRescueOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 救援单表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-09 11:17:55
 */
@RestController
@RequestMapping("rescue/order")
public class ShRescueOrderController {
    @Autowired
    private ShRescueOrderService shRescueOrderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:shrescueorder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shRescueOrderService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }


    /**
     * 通过救援单id  查询救援相关信息
     */
    @RequestMapping("/info/{rescueId}")
    //@RequiresPermissions("order:shrescueorder:info")
    public R info(@PathVariable("rescueId") String rescueId){
			//ShRescueOrderEntity shRescueOrder = shRescueOrderService.selectById(rescueId);
        ShRescueOrderEntity shRescueOrder =shRescueOrderService.queryInfoByRescueId(rescueId);
        return R.ok().put("shRescueOrderInfo", shRescueOrder);
    }

    /**
     *   步骤1：车主提交救援单
     */
    @RequestMapping("/submit")
    // @RequiresPermissions("order:shrescueorder:save")
    public R submitRescueOrder(@RequestBody ShRescueOrderEntity shRescueOrder){
        shRescueOrderService.submitRescueOrder(shRescueOrder);
        return R.ok();
    }


    /**
     * 步骤2： 更新救援单状态   ：（1）接单    （2）完成
     */
    @RequestMapping("/update")
    // @RequiresPermissions("order:shrescueorder:save")
    public R updateRescueOrder(@RequestBody ShRescueOrderEntity shRescueOrder){
       shRescueOrderService.updateRescueOrder(shRescueOrder);
        return R.ok();
    }

    /**
     * 修改
     */
   /* @RequestMapping("/update")
    @RequiresPermissions("order:shrescueorder:update")
    public R update(@RequestBody ShRescueOrderEntity shRescueOrder){
			shRescueOrderService.updateById(shRescueOrder);

        return R.ok();
    }*/

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:shrescueorder:delete")
    public R delete(@RequestBody String[] rescueIds){
			shRescueOrderService.deleteBatchIds(Arrays.asList(rescueIds));

        return R.ok();
    }

}
