package com.hsl.clgl.sh.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 商户用户表
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 15:49:01
 */
public interface ShUserService extends IService<ShUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据用户名查询用户
     */
    public ShUserEntity selectUserByUsername(String username);

    /**
     * 查询用户的所有菜单ID
     * @param userId
     * @return
     */
    public List<String> queryAllMenuId(String userId);


    /**
     * 新增用户
     */
    void save(ShUserEntity user);


    /**
     * 修改用户
     */
    void update(ShUserEntity user);

}

