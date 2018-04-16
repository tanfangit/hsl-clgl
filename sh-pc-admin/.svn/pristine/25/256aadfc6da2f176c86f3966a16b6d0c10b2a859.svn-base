package com.hsl.clgl.sh.pc.admin.modules.rescue.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.sh.pc.admin.modules.rescue.entity.ShRescueOrderEntity;

import java.util.Map;

/**
 * 救援单表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-09 11:17:55
 */
public interface ShRescueOrderService extends IService<ShRescueOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     *
     * 1.提交救援单    插入一条救援单记录
     * @param shRescueOrder
     */
    void submitRescueOrder(ShRescueOrderEntity shRescueOrder);

    /**
     * 通过救援单id  查询救援详细信息
     * @param rescueId
     * @return
     */
    ShRescueOrderEntity queryInfoByRescueId(String rescueId);

    /**
     *
     *  更新救援单状态
     * @param params
     */
    void updateRescueOrder(ShRescueOrderEntity shRescueOrder);

}

