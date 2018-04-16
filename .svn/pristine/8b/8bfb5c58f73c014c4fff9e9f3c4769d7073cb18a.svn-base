package com.hsl.clgl.pc.admin.modules.trailer.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 拖车表
 * 
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-30 16:05:07
 */
@Repository
public interface TrailerDao extends BaseMapper<TrailerEntity> {

    /**
     * 根据前台输入条件查询
     */
    List<TrailerEntity> queryTrailerList (Page<TrailerEntity> page, Map<String, Object> params);
}
