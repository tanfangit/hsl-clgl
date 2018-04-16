package com.hsl.clgl.sh.pc.admin.modules.rescue.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.*;
import com.hsl.clgl.sh.pc.admin.modules.rescue.dao.ShRescueOrderDao;
import com.hsl.clgl.sh.pc.admin.modules.rescue.entity.ShRescueOrderEntity;
import com.hsl.clgl.sh.pc.admin.modules.rescue.service.ShRescueOrderService;
import com.hsl.clgl.sh.pc.admin.modules.rescuelog.entity.ShRescueLogEntity;
import com.hsl.clgl.sh.pc.admin.modules.rescuelog.service.ShRescueLogService;
import com.hsl.clgl.sh.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service("shRescueOrderService")
public class ShRescueOrderServiceImpl extends ServiceImpl<ShRescueOrderDao, ShRescueOrderEntity> implements ShRescueOrderService {
    @Autowired
    ShRescueLogService shRescueLogService;
    @Autowired
    ShRescueOrderDao shRescueOrderDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        params.put("rescue_type", SysDicTypeConstant.RESCUE_TYPE );
        //当前商户id  后续需要加上判断  每个商户只能看到自己的单子
       // String shId= ShiroUtils.getShId();
      //  params.put("shId", shId );
        Page<ShRescueOrderEntity> page = new Query<ShRescueOrderEntity>(params).getPage();
        page.setRecords(shRescueOrderDao.queryRescueOrderList(page,params));
        return new PageUtils(page);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void submitRescueOrder(ShRescueOrderEntity shRescueOrder) {
    //生成救援单id  JY开头时间戳加6位随机数JY20180409091000123456
       String rescue_id= IdUtil.getRescueId();
        shRescueOrder.setRescueId(rescue_id);
       //用户open_id  小程序到时候会带过来  写死
         shRescueOrder.setOpenId("11111111111111");
       //sh_id 商户id  这里会掉用接口 gis匹配到的最近的商户 此时就已经分配给对应的商户  id暂时写死
        //需要传入的参数    经度  纬度   城市id（cityId）
        String sh_id= "3142ced433b911e8b13fc85b769e33b2";
        shRescueOrder.setShId(sh_id);
        shRescueOrder.setRescueLngLat(LngLatUtils.getJson(shRescueOrder.getLng(),shRescueOrder.getLat()));
        //状态设置为  2：已派单
        shRescueOrder.setRescueStatus(2);
        // 1.插入一条救援单
        this.insert(shRescueOrder);
        //2.插入日志    rescue_id
        //已提交  1
        ShRescueLogEntity shRescueLogEntity1=new ShRescueLogEntity();
        shRescueLogEntity1.setRescueLogId(UUIDUtil.generateUUID());
        shRescueLogEntity1.setRescueStatus(1);
        shRescueLogEntity1.setRescueId(rescue_id);
        shRescueLogEntity1.setLogRemark("已提交");
        shRescueLogService.save(shRescueLogEntity1);
        // 已派单   2
        ShRescueLogEntity shRescueLogEntity=new ShRescueLogEntity();
        shRescueLogEntity.setRescueLogId(UUIDUtil.generateUUID());
        shRescueLogEntity.setRescueStatus(2);
        shRescueLogEntity.setRescueId(rescue_id);
        shRescueLogEntity.setLogRemark("已派单");
        shRescueLogService.save(shRescueLogEntity);


    }


    @Override
    public ShRescueOrderEntity queryInfoByRescueId(String rescueId) {
        String  rescue_type= SysDicTypeConstant.RESCUE_TYPE;
        ShRescueOrderEntity shRescueOrderEntity=
                shRescueOrderDao.queryInfoByRescueId(new MapUtils().put("rescueId",rescueId).put(rescue_type,rescue_type));
        return shRescueOrderEntity;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRescueOrder(ShRescueOrderEntity shRescueOrder) {
        //接单直接跳到救援状态
        //更新状态  到救援中 4
        if("4".equals(String.valueOf(shRescueOrder.getRescueStatus()))){
            this.updateById(shRescueOrder);

            //插入日志
            //已接单 3
            ShRescueLogEntity shRescueLogEntity1=new ShRescueLogEntity();
            shRescueLogEntity1.setRescueLogId(UUIDUtil.generateUUID());
            shRescueLogEntity1.setRescueStatus(3);
            shRescueLogEntity1.setRescueId(shRescueOrder.getRescueId());
            shRescueLogEntity1.setLogRemark("已接单");
            shRescueLogService.save(shRescueLogEntity1);
            // 救援中   4
            ShRescueLogEntity shRescueLogEntity=new ShRescueLogEntity();
            shRescueLogEntity.setRescueLogId(UUIDUtil.generateUUID());
            shRescueLogEntity.setRescueStatus(4);
            shRescueLogEntity.setRescueId(shRescueOrder.getRescueId());
            shRescueLogEntity.setLogRemark("救援中");
            shRescueLogService.save(shRescueLogEntity);

        }
        //完成
        if("5".equals(String.valueOf(shRescueOrder.getRescueStatus()))){
            this.updateById(shRescueOrder);

            //插入日志
            //完成  5
            ShRescueLogEntity shRescueLogEntity1=new ShRescueLogEntity();
            shRescueLogEntity1.setRescueLogId(UUIDUtil.generateUUID());
            shRescueLogEntity1.setRescueStatus(5);
            shRescueLogEntity1.setRescueId(shRescueOrder.getRescueId());
            shRescueLogEntity1.setLogRemark("已完成");
            shRescueLogService.save(shRescueLogEntity1);


        }

    }
}
