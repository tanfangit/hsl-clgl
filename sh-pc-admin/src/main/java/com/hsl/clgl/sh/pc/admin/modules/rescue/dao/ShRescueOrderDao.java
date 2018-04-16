package com.hsl.clgl.sh.pc.admin.modules.rescue.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hsl.clgl.sh.pc.admin.modules.rescue.entity.ShRescueOrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 救援单表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-09 11:17:55
 */
public interface ShRescueOrderDao extends BaseMapper<ShRescueOrderEntity> {


    List<ShRescueOrderEntity> queryRescueOrderList(Page<ShRescueOrderEntity> page, Map<String, Object> params);


    ShRescueOrderEntity queryInfoByRescueId(Map<String, Object> params);
}
