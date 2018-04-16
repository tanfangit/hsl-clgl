package com.hsl.clgl.pc.admin.modules.cz.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hsl.clgl.pc.admin.modules.cz.entity.CzEntity;

import java.util.List;
import java.util.Map;

/**
 * 车主管理表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-30 08:19:36
 */
public interface CzDao extends BaseMapper<CzEntity> {

    List<CzEntity> queryCzList(Page<CzEntity> page, Map<String, Object> params);
	
}
