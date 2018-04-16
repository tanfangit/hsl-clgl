package com.hsl.clgl.sh.pc.admin.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShRoleMenuEntity;

import java.util.List;

/**
 * 角色与菜单对应关系
 * 
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
public interface ShRoleMenuDao extends BaseMapper<ShRoleMenuEntity> {
    /**
     * 根据角色ID数组，批量删除
     */
    int deleteBatch(String[] roleIds);


    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<String> queryMenuIdList(String roleId);
}
