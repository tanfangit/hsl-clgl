package com.hsl.clgl.app.cz.modules.sys.controller;

import com.hsl.clgl.app.cz.modules.sys.entity.CarBrandEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CarBrandService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 车辆品牌表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-03 13:49:21
 */
@RestController
@RequestMapping("sys/carbrand")
public class CarBrandController {
    @Autowired
    private CarBrandService carBrandService;

    /**
     * 列表
     */
    @ApiOperation(value="查询出所有车辆品牌集合11", notes="查询出所有车辆品牌集合11")
    @RequestMapping("/list")
   // @RequiresPermissions("sys:carbrand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = carBrandService.queryPage(params);

        return R.ok().putResultDate("page", page);
    }

    /**
     * 查询出所有车辆品牌集合
     * @return
     */
    @ApiOperation(value="查询出所有车辆品牌集合", notes="查询出所有车辆品牌集合")
    @RequestMapping(value="/allBrand", method=RequestMethod.POST)
    public R queryAllCarBrand(){
        List<CarBrandEntity>  allCarBrand=carBrandService.queryAllCarBrand();
        return R.ok().put("allCarBrand", allCarBrand);
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
   // @RequiresPermissions("sys:carbrand:info")
    public R info(@PathVariable("brandId") String brandId){
			CarBrandEntity carBrand = carBrandService.selectById(brandId);

        return R.ok().put("carBrand", carBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("sys:carbrand:save")
    public R save(@RequestBody CarBrandEntity carBrand){
			carBrandService.insert(carBrand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("sys:carbrand:update")
    public R update(@RequestBody CarBrandEntity carBrand){
			carBrandService.updateById(carBrand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:carbrand:delete")
    public R delete(@RequestBody String[] brandIds){
			carBrandService.deleteBatchIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
