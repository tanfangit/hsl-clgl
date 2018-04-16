package com.hsl.clgl.pc.admin.modules.sys.dao;

import com.hsl.clgl.pc.admin.modules.sys.entity.SysMenuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 菜单管理
 * 
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-03-17 15:19:55
 */
public interface SysMenuDao extends BaseMapper<SysMenuEntity> {
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(String parentId);

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();
}
