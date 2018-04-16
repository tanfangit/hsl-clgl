package com.hsl.clgl.app.cz.modules.sys.controller;

import com.hsl.clgl.app.cz.modules.sys.entity.CarTypeEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CarTypeService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 车型表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-02 15:42:02
 */
@RestController
@RequestMapping("sys/cartype")
public class CarTypeController {
    @Autowired
    private CarTypeService carTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = carTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 通过车系id   查询该车系下的所有车型
     */
    @ApiOperation(value="查询所属车系下的车型", notes="通过车系id查询出该车系下的所有车型")
    @RequestMapping(value="/allType", method=RequestMethod.POST)
    public R queryAllCarType(@RequestBody Map<String, Object> params){
        List<CarTypeEntity> carTypes= carTypeService.queryAllCarTypeByTrainId(params.get("trainId").toString());
        return R.ok().put("carTypes", carTypes);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
			CarTypeEntity carType = carTypeService.selectById(id);

        return R.ok().put("carType", carType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CarTypeEntity carType){
			carTypeService.insert(carType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CarTypeEntity carType){
			carTypeService.updateById(carType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] ids){
			carTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
