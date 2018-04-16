package com.hsl.clgl.pc.admin.modules.trailerlist.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsl.clgl.pc.admin.modules.trailerlist.entity.TrailerListEntity;
import com.hsl.clgl.pc.admin.modules.trailerlist.service.TrailerListService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;



/**
 * 拖车单表
 *
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-28 14:22:14
 */
@RestController
@RequestMapping("trailerlist")
public class TrailerListController {
    @Autowired
    private TrailerListService trailerListService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:trailerlist:list")
    public R list(@RequestParam Map<String, Object> params){
        if(params.get("key[trailerCompanyId]")!=null){
            String trailerCompanyId = params.get("key[trailerCompanyId]").toString();
            params.put("trailerCompanyId",trailerCompanyId);
        }
        if(params.get("key[trailerListNo]")!=null){
            String trailerListNo = params.get("key[trailerListNo]").toString();
            params.put("trailerListNo",trailerListNo);
        }
        if(params.get("key[beginTime]")!=null){
            String beginTime = params.get("key[beginTime]").toString();
            params.put("createTime",beginTime);
        }
        if(params.get("key[endTime]")!=null){
            String endTime = params.get("key[endTime]").toString();
            params.put("updateTime",endTime);
        }
        PageUtils page = trailerListService.queryPage(params);

        return R.ok().put("rows", page.getRows()).put("total", page.getTotal());
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{trailerListId}")
    @RequiresPermissions("sys:trailerlist:info")
    public R info(@PathVariable("trailerListId") String trailerListId){
			TrailerListEntity trailerList = trailerListService.selectById(trailerListId);

        return R.ok().put("trailerList", trailerList);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:trailerlist:save")
    public R save(@RequestBody TrailerListEntity trailerList){
			trailerListService.save(trailerList);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:trailerlist:update")
    public R update(@RequestBody TrailerListEntity trailerList){
			trailerListService.update(trailerList);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:trailerlist:delete")
    public R delete(@RequestBody String[] trailerListIds){
			trailerListService.deleteBatchIds(Arrays.asList(trailerListIds));

        return R.ok();
    }

}
