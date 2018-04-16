package com.hsl.clgl.pc.admin.modules.trailerlist.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.trailerlist.entity.TrailerListEntity;

import java.util.Map;

/**
 * 拖车单表
 *
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-28 14:22:14
 */
public interface TrailerListService extends IService<TrailerListEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 新增拖车单
     */
     void save(TrailerListEntity trailerListEntity);
    /**
     * 修改拖车单
     */
    void update(TrailerListEntity trailerListEntity);
}

