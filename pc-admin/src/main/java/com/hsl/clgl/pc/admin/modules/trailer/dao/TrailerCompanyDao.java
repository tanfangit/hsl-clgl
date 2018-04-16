package com.hsl.clgl.pc.admin.modules.trailer.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerCompanyEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 拖车公司表
 * 
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-28 14:41:00
 */
@Repository
public interface TrailerCompanyDao extends BaseMapper<TrailerCompanyEntity> {

    /**
     * 根据id查询名字
     */
    List<TrailerCompanyEntity> queryTrailerCompanyByName (Page<TrailerCompanyEntity> page, Map<String, Object> params);

}
