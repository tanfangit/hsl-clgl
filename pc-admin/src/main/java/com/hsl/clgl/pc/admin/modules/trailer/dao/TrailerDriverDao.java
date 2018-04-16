package com.hsl.clgl.pc.admin.modules.trailer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerDriverEntity;

import java.util.List;
import java.util.Map;

/**
 * 拖车驾驶员表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-30 11:46:45
 */
public interface TrailerDriverDao extends BaseMapper<TrailerDriverEntity> {

    List<TrailerDriverEntity> queryTrailerDriverList(Page<TrailerDriverEntity> page, Map<String, Object> params);
	
}
