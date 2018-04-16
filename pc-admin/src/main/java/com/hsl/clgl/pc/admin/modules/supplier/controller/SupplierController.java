package com.hsl.clgl.pc.admin.modules.supplier.controller;

import java.util.Arrays;
import java.util.Map;

import com.hsl.clgl.common.utils.MapUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsl.clgl.pc.admin.modules.supplier.entity.SupplierEntity;
import com.hsl.clgl.pc.admin.modules.supplier.service.SupplierService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;


/**
 * 供应商维护
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-23 11:50:59
 */
@RestController
@RequestMapping("supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    /**
     * 所有供应商列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:supplier:list")
    public R list(@RequestParam Map<String, Object> params) {
        if(params.get("key[supplierName]")!=null){
            String supplierName = params.get("key[supplierName]").toString();
            params.put("supplierName",supplierName);
        }
        if(params.get("key[beginTime]")!=null){
            String beginTime = params.get("key[beginTime]").toString();
            params.put("createTime",beginTime);
        }
        if(params.get("key[endTime]")!=null){
            String endTime = params.get("key[endTime]").toString();
            params.put("updateTime",endTime);
        }
        if(params.get("key[status]")!=null){
            String status = params.get("key[status]").toString();
            params.put("cooperationStatus",status);
        }

        PageUtils page = supplierService.queryPage(params);
        return R.ok().put("rows", page.getRows()).put("total", page.getTotal());
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{supplierId}")
    @RequiresPermissions("sys:supplier:info")
    public R info(@PathVariable("supplierId") String supplierId) {
        SupplierEntity supplier = supplierService.selectById(supplierId);

        return R.ok().put("supplier", supplier);
    }

    /**
     * 新增保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:supplier:save")
    public R save(@RequestBody SupplierEntity supplierEntity) {
        supplierService.save(supplierEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:supplier:update")
    public R update(@RequestBody SupplierEntity supplierEntity) {
        supplierService.update(supplierEntity);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:supplier:delete")
    public R delete(@RequestBody String[] supplierIds) {
        supplierService.deleteBatchIds(Arrays.asList(supplierIds));

        return R.ok();
    }

}
