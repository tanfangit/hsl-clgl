package com.hsl.clgl.pc.admin.modules.trailerlist.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.hsl.clgl.pc.admin.modules.trailerlist.entity.TrailerListEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 拖车单表
 * 
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-28 14:22:14
 */
@Repository
public interface TrailerListDao extends BaseMapper<TrailerListEntity> {
    /**
     * 根据前台输入条件查询
     */
    List<TrailerListEntity> queryTrailerListList (Page<TrailerListEntity> page, Map<String, Object> params);
}
