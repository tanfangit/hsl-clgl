package com.hsl.clgl.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysRoleMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-27 12:48:09
 */
public interface SysRoleMenuService extends IService<SysRoleMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveOrUpdate(String roleId, List<String> menuIdList);

    /**
     * 根据角色ID数组，批量删除
     */
    int deleteBatch(String[] roleIds);

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<String > queryMenuIdList(String  roleId);
}

