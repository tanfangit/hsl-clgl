package com.hsl.clgl.sh.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShUserRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
public interface ShUserRoleService extends IService<ShUserRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据用户id查询用户权限
     * @param userId
     * @return
     */
    public List<String> queryAllPerms (String userId);


    /**
     * 保存用户角色关系
     * @param userId
     * @param roleIdList
     */
    void saveOrUpdate(String userId, List<String> roleIdList);


    /**
     * 根据用户ID，获取角色ID列表
     */
    List<String> queryRoleIdList(String userId);
}



