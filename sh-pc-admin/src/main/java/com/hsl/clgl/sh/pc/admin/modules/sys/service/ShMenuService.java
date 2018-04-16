package com.hsl.clgl.sh.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 菜单
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
public interface ShMenuService extends IService<ShMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<ShMenuEntity> queryListParentIdBySh(String parentId,String shId);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @param menuIdList  用户菜单ID
     */
    List<ShMenuEntity> queryListParentId(String parentId, List<String> menuIdList,String shId);

    /**
     * 获取用户菜单列表
     */
    List<ShMenuEntity> getUserMenuList(String userId,String shId);

    /**
     * 获取用户菜单方法，加上工程名拼接url路径
     */
    public List<ShMenuEntity> getUserRequestMenuList(String userId, String contextPath,String shId);

    /**
     * 查询所有菜单树结构
     */
    List<ShMenuEntity> getMenuAll(String shId);


    /**
     * 查询角色已拥有的菜单树结构
     */
    List<ShMenuEntity> getSelectMenuAll(List<String> selectMenus,String shId);
}

