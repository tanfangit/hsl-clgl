package com.hsl.clgl.pc.admin.modules.trailer.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerCompanyEntity;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerDriverEntity;
import com.hsl.clgl.pc.admin.modules.trailer.service.TrailerCompanyService;
import com.hsl.clgl.pc.admin.modules.trailer.service.TrailerDriverService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;



/**
 * 拖车驾驶员表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-30 11:46:45
 */
@RestController
@RequestMapping("trailer/trailerdriver")
public class TrailerDriverController {
    @Autowired
    private TrailerDriverService trailerDriverService;
    @Autowired
    TrailerCompanyService  trailerCompanyService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("trailer:trailerdriver:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = trailerDriverService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total", page.getTotal());
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{trailerDriverId}")
   // @RequiresPermissions("trailer:trailerdriver:info")
    public R info(@PathVariable("trailerDriverId") String trailerDriverId){
        TrailerDriverEntity trailerDriver = trailerDriverService.selectById(trailerDriverId);
        TrailerCompanyEntity trailerCompanyEntity =trailerCompanyService.selectById(trailerDriver.getTrailerCompanyId());
        trailerDriver.setTrailerCompanyName(trailerCompanyEntity.getTrailerCompanyName());
        return R.ok().put("trailerDriver", trailerDriver);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("trailer:trailerdriver:save")
    public R save(@RequestBody TrailerDriverEntity trailerDriver){
        trailerDriver.setTrailerDriverId(UUIDUtil.generateUUID());
        trailerDriver.setCreateUser(ShiroUtils.getUserId());
        trailerDriverService.insert(trailerDriver);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("trailer:trailerdriver:update")
    public R update(@RequestBody TrailerDriverEntity trailerDriver){
        trailerDriver.setUpdateUser(ShiroUtils.getUserId());
        trailerDriver.setUpdateTime(new Date());
        trailerDriverService.updateById(trailerDriver);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("trailer:trailerdriver:delete")
    public R delete(@RequestBody String[] trailerDriverIds){
			trailerDriverService.deleteBatchIds(Arrays.asList(trailerDriverIds));

        return R.ok();
    }

}
