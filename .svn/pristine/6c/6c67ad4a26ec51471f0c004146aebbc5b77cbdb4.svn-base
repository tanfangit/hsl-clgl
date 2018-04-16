package com.hsl.clgl.pc.admin.modules.maintenance.car.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hsl.clgl.common.utils.MapUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsl.clgl.pc.admin.modules.maintenance.car.entity.CarTrainEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.car.service.CarTrainService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;



/**
 * 车系表
 *
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-03-27 10:06:21
 */
@RestController
@RequestMapping("car/train")
public class CarTrainController {
    @Autowired
    private CarTrainService carTrainService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("car:train:list")
    public R list(@RequestParam Map<String, Object> params){
        if(params.get("key[carBrand]") != null){
            String brandId = params.get("key[carBrand]").toString();
            params.put("brandId",brandId);
        }
        if(params.get("key[trainName]") != null){
            String trainName = params.get("key[trainName]").toString();
            params.put("trainName",trainName);
        }
        PageUtils page = carTrainService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }

    @RequestMapping("/select/{brandId}")
//    @RequiresPermissions("car:train:select")
    public R select(@PathVariable("brandId") String brandId){
        Map<String, Object> params = new MapUtils();
        params.put("brandId",brandId);
        List<CarTrainEntity> list = carTrainService.queryTrain(params);
        return R.ok().put("trains", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:train:info")
    public R info(@PathVariable("id") String id){
			CarTrainEntity carTrain = carTrainService.selectById(id);

        return R.ok().put("carTrain", carTrain);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("car:train:save")
    public R save(@RequestBody CarTrainEntity carTrain){
        String carTrainID= UUIDUtil.generateUUID();
        carTrain.setId(carTrainID);
        carTrain.setCreateTime(new Date());
        carTrain.setCreateUser(ShiroUtils.getUserId());
        carTrainService.insert(carTrain);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("car:train:update")
    public R update(@RequestBody CarTrainEntity carTrain){
        carTrain.setUpdateTime(new Date());
        carTrain.setUpdateUser(ShiroUtils.getUserId());
        carTrainService.updateById(carTrain);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{trainId}")
//    @RequiresPermissions("car:train:delete")
    public R delete(@PathVariable("trainId") String trainId){
        CarTrainEntity carTrain=new CarTrainEntity();
        carTrain.setId(trainId);
        carTrain.setStatus(Constant.STATUS_DELETED);
        carTrain.setUpdateTime(new Date());
        carTrain.setUpdateUser(ShiroUtils.getUserId());
        carTrainService.updateById(carTrain);

        return R.ok();
    }

}
