package com.hsl.clgl.pc.admin.modules.cz.controller;

import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.cz.entity.CzEntity;
import com.hsl.clgl.pc.admin.modules.cz.service.CzService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 车主管理表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-30 08:19:36
 */
@RestController
@RequestMapping("cz")
public class CzController {
    @Autowired
    private CzService czService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("cz:cz:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = czService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{czId}")
   // @RequiresPermissions("cz:cz:info")
    public R info(@PathVariable("czId") String czId){
        CzEntity cz =czService.selectInfoById(czId);
        return R.ok().put("cz", cz);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cz:cz:save")
    public R save(@RequestBody CzEntity cz){
			czService.insert(cz);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cz:cz:update")
    public R update(@RequestBody CzEntity cz){
			czService.updateById(cz);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cz:cz:delete")
    public R delete(@RequestBody String[] czIds){
			czService.deleteBatchIds(Arrays.asList(czIds));

        return R.ok();
    }

}
