package com.hsl.clgl.pc.admin.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysUserRoleEntity;

import java.util.List;

/**
 * 用户与角色对应关系
 * 
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-03-17 15:19:55
 */
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {
    /**
     * 根据用户ID，获取角色ID列表
     */
    List<String> queryRoleIdList(String userId);
}
