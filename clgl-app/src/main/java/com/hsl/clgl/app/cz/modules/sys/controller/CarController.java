package com.hsl.clgl.app.cz.modules.sys.controller;

import com.hsl.clgl.app.cz.modules.sys.entity.CarEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CarService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 车主对应的车辆表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-02 13:47:43
 */
@RestController
@RequestMapping("sys/car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:car:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = carService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 通过车主id   查询所拥有的车辆List
     * @param  params
     * @return
     */
    @ApiOperation(value="查询车主所拥有的车辆", notes="通过车主ID查询来查询该车主所拥有的所有车辆")
    @RequestMapping(value="/cars", method=RequestMethod.POST)
    public R queryCarListById(@RequestBody Map<String, Object> params){
        List<CarEntity> carList= carService.queryCarListById(params.get("czId").toString());
        return R.ok().put("cars", carList);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{carId}")
    //@RequiresPermissions("sys:car:info")
    public R info(@PathVariable("carId") String carId){
			CarEntity car = carService.selectById(carId);

        return R.ok().put("car", car);
    }

    /**
     * 车主新增车辆
     */
    @ApiOperation(value="新增车主车辆", notes="新增车主车辆")
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public R save(@RequestBody CarEntity car){
        carService.addCar(car);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:car:update")
    public R update(@RequestBody CarEntity car){
			carService.updateById(car);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:car:delete")
    public R delete(@RequestBody String[] carIds){
			carService.deleteBatchIds(Arrays.asList(carIds));

        return R.ok();
    }




}
