package com.hsl.clgl.pc.admin.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysRoleMenuEntity;

import java.util.List;

/**
 * 角色与菜单对应关系
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-27 12:48:09
 */
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenuEntity> {

    /**
     * 根据角色ID数组，批量删除
     */
    int deleteBatch(String[] roleIds);

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<String> queryMenuIdList(String roleId);
	
}
