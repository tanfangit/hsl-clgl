package com.hsl.clgl.pc.admin.modules.merchant.controller;

import com.alibaba.fastjson.JSONObject;
import com.hsl.clgl.common.utils.*;
import com.hsl.clgl.pc.admin.modules.merchant.entity.MerchantEntity;
import com.hsl.clgl.pc.admin.modules.merchant.service.MerchantService;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 商户表
 *
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-03-29 16:11:44
 */
@RestController
@RequestMapping("merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("merchant:list")
    public R list(@RequestParam Map<String, Object> params){
        if(params.get("key[merchantName]") != null){
            String merchantName = params.get("key[merchantName]").toString();
            params.put("merchantName",merchantName);
        }
        if(params.get("key[type]") != null){
            String type = params.get("key[type]").toString();
            params.put("type",type);
        }
        if(params.get("key[beginTime]") != null){
            String beginTime = params.get("key[beginTime]").toString();
            params.put("beginTime",beginTime);
        }
        if(params.get("key[endTime]") != null){
            String endTime = params.get("key[endTime]").toString();
            params.put("endTime",endTime);
        }
        if(params.get("key[province]") != null){
            String province = params.get("key[province]").toString();
            params.put("province",province);
        }
        if(params.get("key[city]") != null){
            String city = params.get("key[city]").toString();
            params.put("city",city);
        }
        PageUtils page = merchantService.queryPage(params);

        return R.ok().put("rows", page.getRows()).put("total",page.getTotal());
    }

    /**
     * 绘图检测
     */
    @RequestMapping("/mapCheck")
//    @RequiresPermissions("merchant:mapCheck")
    public R mapCheck(@RequestParam Map<String, Object> params){
        String allLatiLongi = params.get("allLatiLongi").toString();
        String fmtPolygon = merchantService.polygonToJson(allLatiLongi);
        R r = new R();
        if(fmtPolygon==null){
            //您的绘图无法格式化，请检查
            return R.error("您的绘图无法格式化，请检查!").put("fmtPolygon", "");
        }else{
            //格式化后坐标系数据
            r = R.ok().put("fmtPolygon", fmtPolygon);
        }
        List<MerchantEntity> jiaoji = merchantService.checkPolygon(params);
        r.put("jiaoji",jiaoji);
        return r;
    }
    /**
     * 绘图保存
     */
    @RequestMapping("/polygonSave")
//    @RequiresPermissions("merchant:polygonSave")
    public R polygonSave(@RequestParam Map<String, Object> params){
        MerchantEntity oldMerchant = new MerchantEntity();
        MerchantEntity merchant = new MerchantEntity();
        String allLatiLongi = params.get("allLatiLongi").toString();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("merchantId",params.get("merchantId").toString());
        param.put(ColumnConstant.STATUS, Constant.STATUS_USED);
        oldMerchant = (merchantService.queryByMerchantId(param)).get(0);
        if (oldMerchant.getMappingVersion() == null) {
            oldMerchant.setMappingVersion(Integer.valueOf(0));
        }
        String oldAllLatiLongi = oldMerchant.getAllLatiLongi();
        if(!allLatiLongi.equals(oldAllLatiLongi) && !(allLatiLongi.equals("") && oldAllLatiLongi == null)) {
            merchant.setMappingVersion(oldMerchant.getMappingVersion()+1);
        }
        merchant.setUpdateTime(new Date());
        merchant.setUpdateUser(ShiroUtils.getUserId());
        merchant.setAllLatiLongi(allLatiLongi);
        merchant.setId(params.get("merchantId").toString());
        merchantService.updateById(merchant);

        return R.ok();
    }
    /**
     * 标点保存
     */
    @RequestMapping("/savePoint")
//    @RequiresPermissions("merchant:savePoint")
    public R savePoint(@RequestParam Map<String, Object> params){
        MerchantEntity merchant = new MerchantEntity();
        String lngLat = params.get("lngLat").toString();
        merchant.setUpdateTime(new Date());
        merchant.setUpdateUser(ShiroUtils.getUserId());
        merchant.setLngLat(lngLat);
        if(StringUtils.isNotBlank(lngLat)){
            JSONObject jsonObject = JSONObject.parseObject(lngLat);
            merchant.setLng(jsonObject.getDouble("lng"));
            merchant.setLat(jsonObject.getDouble("lat"));
        }
        merchant.setId(params.get("merchantId").toString());
        merchantService.updateById(merchant);

        return R.ok();
    }
    /**
     * 查询周边
     */
    @RequestMapping("/queryByCityCode")
//    @RequiresPermissions("merchant:queryByCityCode")
    public R queryByCityCode(@RequestParam Map<String, Object> params){
        params.put(ColumnConstant.STATUS, Constant.STATUS_USED);
        List<MerchantEntity> list = merchantService.queryByCityId(params);
        return R.ok().put("list",list);
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("merchant:info")
    public R info(@PathVariable("id") String id){
        MerchantEntity merchant = merchantService.selectById(id);

        return R.ok().put("merchant", merchant);
    }
    @RequestMapping("/repair/{merchantId}")
//    @RequiresPermissions("merchant:info")
    public R loadRepair(@PathVariable("merchantId") String merchantId){
        List<MapUtils> repairs = merchantService.queryById(merchantId);

        return R.ok().put("repairs", repairs);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("merchant:save")
    public R save(@RequestBody MerchantEntity merchant){
        String merchantID= UUIDUtil.generateUUID();
        merchant.setId(merchantID);
        merchant.setCreateTime(new Date());
        merchant.setCreateUser(ShiroUtils.getUserId());
//        if(StringUtils.isNotBlank(merchant.getLng()) && StringUtils.isNotBlank(merchant.getLat())){
//            String lngLat = "{\"lng\":"+merchant.getLng()+",\"lat\":"+merchant.getLat()+"}";
//            merchant.setLngLat(lngLat);
//        }
        merchantService.insertMerchant(merchant);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("merchant:update")
    public R update(@RequestBody MerchantEntity merchant){
            merchant.setUpdateTime(new Date());
            merchant.setUpdateUser(ShiroUtils.getUserId());
			merchantService.updateMerchant(merchant);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{merchantId}")
//    @RequiresPermissions("merchant:delete")
    public R delete(@PathVariable("merchantId") String merchantId){
        MerchantEntity merchant=new MerchantEntity();
        merchant.setId(merchantId);
        merchant.setStatus(Constant.STATUS_DELETED);
        merchant.setUpdateTime(new Date());
        merchant.setUpdateUser(ShiroUtils.getUserId());
        merchantService.updateById(merchant);

        return R.ok();
    }

}
