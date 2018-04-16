package com.hsl.clgl.sh.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
public interface ShRoleService extends IService<ShRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    public List<ShRoleEntity> queryUserRoleListByUserId (String userId);

    /**
     * 查询所有角色
     */
    public List<ShRoleEntity> queryRoleList(String shId);

    /**
     * 新增角色
     * @return
     */

    void save(ShRoleEntity role);


    /**
     * 修改角色
     * @param role
     */
    void update(ShRoleEntity role);


    /**
     * 通过角色id   删除角色
     * @param roleId
     */
    void deleteBatch(String  roleId);


}

