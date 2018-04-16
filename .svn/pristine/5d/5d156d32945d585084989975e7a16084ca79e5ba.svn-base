package com.hsl.clgl.pc.admin.modules.trailer.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerCompanyEntity;
import com.hsl.clgl.pc.admin.modules.trailer.service.TrailerCompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 拖车公司表
 *
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-28 14:41:00
 */
@RestController
@RequestMapping("trailer/company")
public class TrailerCompanyController {
    @Autowired
    private TrailerCompanyService trailerCompanyService;

    /**
     * 所有拖车公司列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:trailer:list")
    public R list(@RequestParam Map<String, Object> params){
        if(params.get("key[trailerCompanyName]")!=null){
            String trailerCompanyName = params.get("key[trailerCompanyName]").toString();
            params.put("trailerCompanyName",trailerCompanyName);
        }
        if(params.get("key[beginTime]")!=null){
            String beginTime = params.get("key[beginTime]").toString();
            params.put("createTime",beginTime);
        }
        if(params.get("key[endTime]")!=null){
            String endTime = params.get("key[endTime]").toString();
            params.put("updateTime",endTime);
        }

        PageUtils page = trailerCompanyService.queryPage(params);

        return R.ok().put("rows", page.getRows()).put("total", page.getTotal());
    }


    /**
     * 查询所有拖车公司
     */
    @RequestMapping("/allTrailerCompany")
     public R  queryAllTrailerCompany(){
        List<TrailerCompanyEntity>  list=trailerCompanyService.queryAllTrailerCompany();
        return R.ok().put("trailerCompanyList", list);
     }
    /**
     * 信息
     */
    @RequestMapping("/info/{trailerCompanyId}")
    @RequiresPermissions("sys:trailer:info")
    public R info(@PathVariable("trailerCompanyId") String trailerCompanyId){
			TrailerCompanyEntity trailerCompany = trailerCompanyService.selectById(trailerCompanyId);

        return R.ok().put("trailerCompany", trailerCompany);
    }

    /**
     * 新增保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("sys:trailer:save")
    public R save(@RequestBody TrailerCompanyEntity trailerCompany){
			trailerCompanyService.save(trailerCompany);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:trailer:update")
    public R update(@RequestBody TrailerCompanyEntity trailerCompany){
			trailerCompanyService.update(trailerCompany);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:trailer:delete")
    public R delete(@RequestBody String[] trailerCompanyIds){
			trailerCompanyService.deleteBatchIds(Arrays.asList(trailerCompanyIds));

        return R.ok();
    }

}
