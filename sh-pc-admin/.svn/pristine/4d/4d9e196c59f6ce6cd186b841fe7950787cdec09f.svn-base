package com.hsl.clgl.sh.pc.admin.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShUserRoleEntity;

import java.util.List;

/**
 * 用户与角色对应关系
 * 
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
public interface ShUserRoleDao extends BaseMapper<ShUserRoleEntity> {
    /**
     * 根据用户ID，获取角色ID列表
     */
    List<String> queryRoleIdList(String userId);
}
