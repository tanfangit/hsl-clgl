package com.hsl.clgl.app.cz.modules.sys.controller;

import com.hsl.clgl.app.cz.modules.sys.entity.CzEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CzService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.common.utils.UUIDUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;



/**
 * 车主管理表 接口
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-02 11:05:43
 */
@RestController
@RequestMapping("sys/cz")
public class CzController {
    @Autowired
    private CzService czService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:cz:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = czService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 通过车主id 查询车主信息
     */
    @RequestMapping(value="/info", method=RequestMethod.POST)
    @ApiOperation(value="查询车主信息", notes="通过车主id查询车主信息")
    public R info(@RequestBody Map<String, Object> params){
        CzEntity cz = czService.selectById(params.get("czId").toString());
        return R.ok().put("cz", cz);
    }

    /**
     * 新增车主信息
     */
    @ApiOperation(value="新增车主信息", notes="通过车主实体新增车主信息")
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public R save( CzEntity cz){
        cz.setCzId(UUIDUtil.generateUUID());
        cz.setCreateTime(new Date());
			czService.insert(cz);
        return R.ok();
    }

    /**
     * 修改车主信息
     */
    @ApiOperation(value="修改车主信息", notes="通过车主id修改车主信息")
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public R update(@RequestBody CzEntity cz){
        czService.updateById(cz);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("sys:cz:delete")
    public R delete(@RequestBody String[] czIds){
			czService.deleteBatchIds(Arrays.asList(czIds));

        return R.ok();
    }

}
