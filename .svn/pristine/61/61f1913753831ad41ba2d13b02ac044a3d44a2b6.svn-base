package com.hsl.clgl.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-03-17 15:19:54
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询所有角色 List
     * @return
     */
    public List<SysRoleEntity> queryRoleList();

    /**
     * 新增角色
     * @return
     */

    void save(SysRoleEntity role);

    /**
     * 通过角色id   删除角色
     * @param roleId
     */
    void deleteBatch(String  roleId);



    /**
     * 修改角色
     * @param role
     */
    void update(SysRoleEntity role);



}

