package com.hsl.clgl.pc.admin.modules.maintenance.car.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.maintenance.car.entity.CarBrandEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.car.entity.CarTrainEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.car.service.CarBrandService;
import com.hsl.clgl.pc.admin.modules.sys.controller.AbstractController;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 车辆品牌表
 *
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-03-24 13:51:54
 */
@RestController
@RequestMapping("car/brand")
public class CarBrandController extends AbstractController {
    @Autowired
    private CarBrandService carBrandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("car:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        if(params.get("key[brandName]") != null){
            String brandName = params.get("key[brandName]").toString();
            params.put("brandName",brandName);
        }
        PageUtils page = carBrandService.queryPage(params);

        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }
    @RequestMapping("/select")
//    @RequiresPermissions("car:brand:select")
    public R select(@RequestParam Map<String, Object> params){
        List<CarBrandEntity> list = carBrandService.queryBrand(params);

        return R.ok().put("brands", list);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    @RequiresPermissions("car:brand:info")
    public R info(@PathVariable("brandId") String brandId){
			CarBrandEntity carBrand = carBrandService.selectById(brandId);

        return R.ok().put("carBrand", carBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("car:brand:save")
    public R save(@RequestBody CarBrandEntity carBrand){
            String carBrandID= UUIDUtil.generateUUID();
            carBrand.setBrandId(carBrandID);
            carBrand.setCreateTime(new Date());
            carBrand.setCreateUser(ShiroUtils.getUserId());
			carBrandService.insert(carBrand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("car:brand:update")
    public R update(@RequestBody CarBrandEntity carBrand){
            carBrand.setUpdateTime(new Date());
            carBrand.setUpdateUser(ShiroUtils.getUserId());
			carBrandService.updateById(carBrand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{brandId}")
//    @RequiresPermissions("car:brand:delete")
    public R delete(@PathVariable("brandId") String brandId){
        CarBrandEntity carBrand=new CarBrandEntity();
        carBrand.setBrandId(brandId);
        carBrand.setStatus(Constant.STATUS_DELETED);
        carBrand.setUpdateTime(new Date());
        carBrand.setUpdateUser(ShiroUtils.getUserId());
        carBrandService.updateById(carBrand);

        return R.ok();
    }

}
