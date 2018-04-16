package com.hsl.clgl.pc.admin.modules.trailer.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerEntity;
import com.hsl.clgl.pc.admin.modules.trailer.service.TrailerService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;



/**
 * 拖车表
 *
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-30 16:05:07
 */
@RestController
@RequestMapping("trailer/trailerList")
public class TrailerController {
    @Autowired
    private TrailerService trailerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:trailer:list")
    public R list(@RequestParam Map<String, Object> params){
        if(params.get("key[trailerNum]")!=null){
            String trailerNum = params.get("key[trailerNum]").toString();
            params.put("trailerCarNo",trailerNum);
        }
        if(params.get("key[beginTime]")!=null){
            String beginTime = params.get("key[beginTime]").toString();
            params.put("createTime",beginTime);
        }
        if(params.get("key[endTime]")!=null){
            String endTime = params.get("key[endTime]").toString();
            params.put("updateTime",endTime);
        }
        if(params.get("key[company]")!=null){
            String company = params.get("key[company]").toString();
            params.put("trailerCompanyId",company);
        }
        PageUtils page = trailerService.queryPage(params);

        return R.ok().put("rows", page.getRows()).put("total", page.getTotal());
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{trailerId}")
    @RequiresPermissions("sys:trailer:info")
    public R info(@PathVariable("trailerId") String trailerId){
			TrailerEntity trailer = trailerService.selectById(trailerId);

        return R.ok().put("trailer", trailer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("sys:trailer:save")
    public R save(@RequestBody TrailerEntity trailer){
			trailerService.save(trailer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:trailer:update")
    public R update(@RequestBody TrailerEntity trailer){
			trailerService.update(trailer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:trailer:delete")
    public R delete(@RequestBody String[] trailerIds){
			trailerService.deleteBatchIds(Arrays.asList(trailerIds));

        return R.ok();
    }

}
