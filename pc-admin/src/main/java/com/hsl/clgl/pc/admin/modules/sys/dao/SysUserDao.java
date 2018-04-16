package com.hsl.clgl.pc.admin.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysUserEntity;

import java.util.List;

/**
 * 系统用户
 * 
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-03-17 15:19:55
 */
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    /**
     * 根据用户名查询用户
     */
    SysUserEntity selectUserByUsername(String username);

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(String userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<String> queryAllMenuId(String userId);
}
