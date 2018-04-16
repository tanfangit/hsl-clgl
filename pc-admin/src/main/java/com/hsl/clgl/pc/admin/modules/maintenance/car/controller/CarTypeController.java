package com.hsl.clgl.pc.admin.modules.maintenance.car.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.maintenance.car.entity.CarTypeEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.car.service.CarTypeService;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * 车型表
 *
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-03-28 15:14:25
 */
@RestController
@RequestMapping("car/type")
public class CarTypeController {
    @Autowired
    private CarTypeService carTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("car:cartype:list")
    public R list(@RequestParam Map<String, Object> params){
        if(params.get("key[carBrand]") != null){
            String brandId = params.get("key[carBrand]").toString();
            params.put("brandId",brandId);
        }
        if(params.get("key[carTrain]") != null){
            String trainId = params.get("key[carTrain]").toString();
            params.put("trainId",trainId);
        }
        if(params.get("key[typeName]") != null){
            String typeName = params.get("key[typeName]").toString();
            params.put("typeName",typeName);
        }
        PageUtils page = carTypeService.queryPage(params);

        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:cartype:info")
    public R info(@PathVariable("id") String id){
			CarTypeEntity carType = carTypeService.selectById(id);

        return R.ok().put("carType", carType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("car:cartype:save")
    public R save(@RequestBody CarTypeEntity carType){
        String carTypeID= UUIDUtil.generateUUID();
        carType.setId(carTypeID);
        carType.setCreateTime(new Date());
        carType.setCreateUser(ShiroUtils.getUserId());
        carTypeService.insert(carType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("car:cartype:update")
    public R update(@RequestBody CarTypeEntity carType){
        carType.setUpdateTime(new Date());
        carType.setUpdateUser(ShiroUtils.getUserId());
        carTypeService.updateById(carType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{typeId}")
//    @RequiresPermissions("car:cartype:delete")
    public R delete(@PathVariable("typeId") String typeId){
        CarTypeEntity carType=new CarTypeEntity();
        carType.setId(typeId);
        carType.setStatus(Constant.STATUS_DELETED);
        carType.setUpdateTime(new Date());
        carType.setUpdateUser(ShiroUtils.getUserId());
        carTypeService.updateById(carType);

        return R.ok();
    }




    /**
     * 查询所有车型
     */
    @RequestMapping(value="/allType", method=RequestMethod.POST)
    public R queryAllCarType(){
        List<CarTypeEntity> carTypes= carTypeService.queryAllCarType();
        return R.ok().put("carTypes", carTypes);
    }

}
