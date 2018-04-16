package com.hsl.clgl.pc.admin.modules.merchant.dao;

import com.hsl.clgl.common.utils.MapUtils;
import com.hsl.clgl.pc.admin.modules.merchant.entity.MerchantEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Component;

/**
 * 商户表
 * 
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-03-29 16:11:44
 */
@Component
public interface MerchantDao extends BaseMapper<MerchantEntity> {
    List<MerchantEntity> queryMerchantList(Page<MerchantEntity> page, Map<String, Object> params);
    List<MerchantEntity> queryMerchantList(Map<String, Object> params);
    List<MerchantEntity> queryByCityId(Map<String, Object> params);
    int insertMerchant(List<MapUtils> merchant);
    List<MapUtils> queryById(String merchantId);
    int deleteById(String merchantId);
    List<MapUtils> queryRepairById(MapUtils params);
    String polygonToJson(String jsonPolygon);
    List<MerchantEntity> checkPolygon(Map<String,Object> map);
}
