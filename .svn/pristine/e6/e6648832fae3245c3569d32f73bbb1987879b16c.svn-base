package com.hsl.clgl.app.cz.modules.sys.controller;

import com.hsl.clgl.app.cz.modules.sys.entity.CzCarEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CzCarService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 车主与车辆关联表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-02 13:50:45
 */
@RestController
@RequestMapping("sys/czcar")
public class CzCarController {
    @Autowired
    private CzCarService czCarService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:czcar:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = czCarService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
   // @RequiresPermissions("sys:czcar:info")
    public R info(@PathVariable("id") String id){
			CzCarEntity czCar = czCarService.selectById(id);

        return R.ok().put("czCar", czCar);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("sys:czcar:save")
    public R save(@RequestBody CzCarEntity czCar){
			czCarService.insert(czCar);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("sys:czcar:update")
    public R update(@RequestBody CzCarEntity czCar){
			czCarService.updateById(czCar);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:czcar:delete")
    public R delete(@RequestBody String[] ids){
			czCarService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
