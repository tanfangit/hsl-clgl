package com.hsl.clgl.pc.admin.modules.maintenance.repair.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.entity.RepairItemEntity;

import java.util.List;
import java.util.Map;

/**
 * 维修项目表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-29 10:02:08
 */
public interface RepairItemDao extends BaseMapper<RepairItemEntity> {

    List<RepairItemEntity> queryRepairItemList(Page<RepairItemEntity> page, Map<String, Object> params);
	
}
