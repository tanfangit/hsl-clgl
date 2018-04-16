package com.hsl.clgl.sh.pc.admin.modules.area.controller;

import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.sh.pc.admin.modules.area.entity.AreaEntity;
import com.hsl.clgl.sh.pc.admin.utils.AreaUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 区县行政编码字典表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-28 11:58:15
 */
@RestController
@RequestMapping("area")
public class AreaController {

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    @RequiresPermissions("sys:area:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = areaService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 根据id查询省级
     */
    @RequestMapping("/sj/{id}")
//    @RequiresPermissions("sys:area:info")
    public R sj(@PathVariable("id") Integer id){
		AreaEntity area = AreaUtils.getSjById(id);
        return R.ok().put("area", area);
    }

    /**
     * 根据查询省级列表
     */
    @RequestMapping("/sj/list")
//    @RequiresPermissions("sys:area:info")
    public R sjList(){
        return R.ok().put("area", AreaUtils.sjList);
    }

    /**
     * 根据查询省级列表
     */
    @RequestMapping("/dj/list")
//    @RequiresPermissions("sys:area:info")
    public R djList(){
        return R.ok().put("area", AreaUtils.djList);
    }

    /**
     * 根据查询省级列表
     */
    @RequestMapping("/xj/list")
//    @RequiresPermissions("sys:area:info")
    public R xjList(){
        return R.ok().put("area", AreaUtils.xjList);
    }

    /**
     * 根据id查询地级
     */
    @RequestMapping("/dj/{id}")
//    @RequiresPermissions("sys:area:info")
    public R dj(@PathVariable("id") Integer id){
        AreaEntity area = AreaUtils.getDjById(id);
        return R.ok().put("area", area);
    }

    /**
     * 根据id查询县级
     */
    @RequestMapping("/xj/{id}")
//    @RequiresPermissions("sys:area:info")
    public R xj(@PathVariable("id") Integer id){
        AreaEntity area = AreaUtils.getXjById(id);
        return R.ok().put("area", area);
    }

    /**
     * 根据省级id查询地级
     */
    @RequestMapping("/dj/parentId/{id}")
//    @RequiresPermissions("sys:area:info")
    public R getDjByParentId(@PathVariable("id") Integer id){
        List<AreaEntity> area = AreaUtils.getDjByParentId(id);
        return R.ok().put("area", area);
    }

    /**
     * 根据地级id查询县级
     */
    @RequestMapping("/xj/parentId/{id}")
//    @RequiresPermissions("sys:area:info")
    public R getXjByParentId(@PathVariable("id") Integer id){
        List<AreaEntity> area = AreaUtils.getXjByParentId(id);
        return R.ok().put("area", area);
    }

}
