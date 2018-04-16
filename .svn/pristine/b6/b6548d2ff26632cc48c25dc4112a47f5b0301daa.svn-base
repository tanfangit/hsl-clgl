package com.hsl.clgl.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-03-17 15:19:55
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(String parentId);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @param menuIdList  用户菜单ID
     */
    List<SysMenuEntity> queryListParentId(String parentId, List<String> menuIdList);

    /**
     * 获取用户菜单列表
     */
    List<SysMenuEntity> getUserMenuList(String userId);

    /**
     * 获取用户菜单方法，加上工程名拼接url路径
     */
    public List<SysMenuEntity> getUserRequestMenuList(String userId, String contextPath);

    /**
     * 查询所有菜单树结构
     */
    List<SysMenuEntity> getMenuAll();


    /**
     * 查询角色已拥有的菜单树结构
     */
    List<SysMenuEntity> getSelectMenuAll(List<String> selectMenus);
}

