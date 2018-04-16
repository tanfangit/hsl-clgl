package com.hsl.clgl.pc.admin.modules.merchant.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.MapUtils;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.merchant.entity.MerchantEntity;

import java.util.List;
import java.util.Map;

/**
 * 商户表
 *
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-03-29 16:11:44
 */
public interface MerchantService extends IService<MerchantEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int insertMerchant(MerchantEntity merchant);
    int updateMerchant(MerchantEntity merchant);
    List<MapUtils> queryById(String merchantId);
    List<MerchantEntity> queryByMerchantId(Map<String, Object> params);
    List<MerchantEntity> queryByCityId(Map<String, Object> params);
    String polygonToJson(String jsonPolygon);
    List<MerchantEntity> checkPolygon(Map<String,Object> map);
}

