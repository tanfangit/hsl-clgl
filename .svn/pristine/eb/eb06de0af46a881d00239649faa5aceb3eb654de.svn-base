package com.hsl.clgl.pc.admin.modules.maintenance.parts.controller;

import com.hsl.clgl.common.utils.MapUtils;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.maintenance.parts.entity.PartsEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.parts.service.PartsService;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;


/**
 * 配件数据维护
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-26 20:44:02
 */
@RestController
@RequestMapping("parts")
public class PartsController {
    @Autowired
    private PartsService partsService;

    /**
     * 所有配件列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:parts:list")
    public R list(@RequestParam Map<String, Object> params){
        if(params.get("key[brandName]")!=null){
            String brandName = params.get("key[brandName]").toString();
            params.put("brandName",brandName);
        }
        if(params.get("key[partsName]")!=null){
            String partsName = params.get("key[partsName]").toString();
            params.put("partsName",partsName);
        }
        if(params.get("key[carLine]")!=null){
            String carLine = params.get("key[carLine]").toString();
            params.put("carLine",carLine);
        }

        PageUtils page = partsService.queryPage(params);

        return R.ok().put("rows", page.getRows()).put("total", page.getTotal());
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{partsId}")
    @RequiresPermissions("sys:parts:info")
    public R info(@PathVariable("partsId") String partsId){
			PartsEntity parts = partsService.selectById(partsId);

        return R.ok().put("parts", parts);
    }

    /**
     * 新增保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("sys:parts:save")
    public R save(@RequestBody PartsEntity parts){
			partsService.save(parts);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:parts:update")
    public R update(@RequestBody PartsEntity parts){
			partsService.update(parts);

        return R.ok();
    }

    /**
     * 单条删除
     */
    @RequestMapping("/delete/{partsId}")
    //@RequiresPermissions("sys:parts:delete")
    public R delete(@PathVariable("partsId") String partsId){
        PartsEntity partsEntity=new PartsEntity();
        partsEntity.setPartsId(partsId);
        partsEntity.setStatus(new Integer(Constant.STATUS_DELETED));
        partsEntity.setUpdateTime(new Date());
        partsEntity.setUpdateUser(ShiroUtils.getUserId());
        partsService.updateById(partsEntity);

        return R.ok();
    }


}
