package com.hsl.clgl.pc.admin.modules.maintenance.parts.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hsl.clgl.pc.admin.modules.maintenance.parts.entity.PartsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 配件数据维护
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-26 20:44:02
 */
@Repository
public interface PartsDao extends BaseMapper<PartsEntity> {
    /**
     * 根据条件查询
     */
    List<PartsEntity> queryPartsList (Page<PartsEntity> page, Map<String, Object> params);
}
