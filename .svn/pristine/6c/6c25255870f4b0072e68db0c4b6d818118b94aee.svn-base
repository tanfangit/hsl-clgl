package com.hsl.clgl.sh.pc.admin.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShDeptEntity;

import java.util.List;

/**
 * 部门表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-03 10:15:08
 */
public interface ShDeptDao extends BaseMapper<ShDeptEntity> {
    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<String> queryDetpIdList(String parentId);
}
