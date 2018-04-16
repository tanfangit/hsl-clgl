package com.hsl.clgl.pc.admin.modules.merchant.service.impl;

import com.hsl.clgl.common.utils.*;
import com.hsl.clgl.pc.admin.utils.Constant;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.hsl.clgl.pc.admin.modules.merchant.dao.MerchantDao;
import com.hsl.clgl.pc.admin.modules.merchant.entity.MerchantEntity;
import com.hsl.clgl.pc.admin.modules.merchant.service.MerchantService;
import org.springframework.transaction.annotation.Transactional;


@Service("merchantService")
public class MerchantServiceImpl extends ServiceImpl<MerchantDao, MerchantEntity> implements MerchantService {
    @Autowired
    private MerchantDao merchantDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        params.put(ColumnConstant.STATUS, Constant.STATUS_USED);
        params.put("merchantTypeName", SysDicTypeConstant.MERCHANT_TYPE);
        params.put(ColumnConstant.DEL_FLAG, Constant.DEL_FLAG_USED);
        Page<MerchantEntity> page = new Query<MerchantEntity>(params).getPage();
        page.setRecords(merchantDao.queryMerchantList(page,params));

        return new PageUtils(page);
    }
    @Transactional(rollbackFor = Exception.class)
    public int insertMerchant(MerchantEntity merchant){
        List<String> repairTypes= merchant.getRepairType();
        List<MapUtils> list = new ArrayList<MapUtils>();
        this.insert(merchant);
        for (String repairType:repairTypes){
            MapUtils params =  new MapUtils();
            String id= UUIDUtil.generateUUID();
            params.put("id",id);
            params.put("merchantId",merchant.getId());
            params.put("repairTypeId",repairType);
            list.add(params);
        }
        return merchantDao.insertMerchant(list);
    }
    @Transactional(rollbackFor = Exception.class)
    public int updateMerchant(MerchantEntity merchant){
        List<String> repairTypes= merchant.getRepairType();
        this.updateById(merchant);
        List<MapUtils> repairResults = merchantDao.queryById(merchant.getId());
        boolean updateFlag = false;
        if(repairResults.size() != repairTypes.size()){
            updateFlag = true;
        }

        if(!updateFlag){
            int count = 0;//匹配计数器
            for (String repairType:repairTypes){
                for(MapUtils repairResult:repairResults){
                    if(repairType.equals(repairResult.get("repairTypeId"))){
                        count = count+1;
                    }
                }
            }
            for(MapUtils repairResult:repairResults){
                for (String repairType:repairTypes){
                    if(repairType.equals(repairResult.get("repairTypeId"))){
                        count = count+1;
                    }
                }
            }
            if(count != (repairResults.size()+repairTypes.size())){
                updateFlag = true;
            }
        }
        //只有维护类型完全相同时才不予更新
        int results = 0;
        if(updateFlag){
            merchantDao.deleteById(merchant.getId());
            List<MapUtils> list = new ArrayList<MapUtils>();
            for (String repairType:repairTypes){
                MapUtils params =  new MapUtils();
                String id= UUIDUtil.generateUUID();
                params.put("id",id);
                params.put("merchantId",merchant.getId());
                params.put("repairTypeId",repairType);
                list.add(params);
            }
            results = merchantDao.insertMerchant(list);
        }
        return results;
    }
    public List<MapUtils> queryById(String merchantId){
        return merchantDao.queryById(merchantId);
    }
    public List<MerchantEntity> queryByMerchantId(Map<String, Object> params){
       return merchantDao.queryMerchantList(params);
    }
    public List<MerchantEntity> queryByCityId(Map<String, Object> params){
        return merchantDao.queryByCityId(params);
    }

    @Override
    public String polygonToJson(String jsonPolygon){
        return merchantDao.polygonToJson(jsonPolygon);
    }
    @Override
    public List<MerchantEntity> checkPolygon(Map<String, Object> map) {
        // TODO Auto-generated method stub
        map.put(ColumnConstant.STATUS, Constant.STATUS_USED);
        return merchantDao.checkPolygon(map);
    }
}
