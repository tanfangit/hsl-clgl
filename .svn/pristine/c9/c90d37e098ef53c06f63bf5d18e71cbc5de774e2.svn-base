package com.hsl.clgl.pc.admin.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysDeptEntity;

import java.util.List;

/**
 * 部门表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-24 17:24:13
 */
public interface SysDeptDao extends BaseMapper<SysDeptEntity> {
    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<String> queryDetpIdList(String parentId);
	
}
