package com.hsl.clgl.pc.admin.modules.trailer.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerEntity;

import java.util.Map;

/**
 * 拖车表
 *
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-30 16:05:07
 */
public interface TrailerService extends IService<TrailerEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     *  新增拖车
     * @param trailerEntity
     */
    void save(TrailerEntity trailerEntity);
    /**
     *  修改拖车
     * @param trailerEntity
     */
    void update(TrailerEntity trailerEntity);
}

