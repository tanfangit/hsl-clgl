package com.hsl.clgl.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-03-17 15:19:55
 */
public interface SysUserService extends IService<SysUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询用户的所有菜单ID
     * @param userId
     * @return
     */
    public List<String> queryAllMenuId(String userId);


    /**
     * 新增用户
     */
    void save(SysUserEntity user);



    /**
     * 修改用户
     */
    void update(SysUserEntity user);



}

