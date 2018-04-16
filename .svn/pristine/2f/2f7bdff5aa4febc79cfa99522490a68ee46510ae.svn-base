package com.hsl.clgl.app.cz.modules.sys.controller;

import com.hsl.clgl.app.cz.modules.sys.entity.CarTrainEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CarTrainService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 车系表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-03 13:49:21
 */
@RestController
@RequestMapping("sys/cartrain")
public class CarTrainController {
    @Autowired
    private CarTrainService carTrainService;

    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("sys:cartrain:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = carTrainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 通过车辆品牌查询  该品牌下的所有车系
     */
    @RequestMapping(value="/allTrain", method=RequestMethod.POST)
    @ApiOperation(value="查询车系集合", notes="通过车辆品牌id查询该车辆品牌下的所有车系")
    public R queryCarBrandBy(@RequestBody Map<String, Object> params){
        List<CarTrainEntity> list=carTrainService.queryCarTrainByBranId(params.get("brandId").toString());
        return R.ok().put("carBrands", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
   // @RequiresPermissions("sys:cartrain:info")
    public R info(@PathVariable("id") String id){
			CarTrainEntity carTrain = carTrainService.selectById(id);

        return R.ok().put("carTrain", carTrain);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:cartrain:save")
    public R save(@RequestBody CarTrainEntity carTrain){
			carTrainService.insert(carTrain);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("sys:cartrain:update")
    public R update(@RequestBody CarTrainEntity carTrain){
			carTrainService.updateById(carTrain);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:cartrain:delete")
    public R delete(@RequestBody String[] ids){
			carTrainService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
