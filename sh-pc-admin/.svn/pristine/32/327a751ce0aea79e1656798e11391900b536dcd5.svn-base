package com.hsl.clgl.sh.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShRoleMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
public interface ShRoleMenuService extends IService<ShRoleMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存或新增  角色与菜单关系
     * @param roleId
     * @param menuIdList
     */
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

