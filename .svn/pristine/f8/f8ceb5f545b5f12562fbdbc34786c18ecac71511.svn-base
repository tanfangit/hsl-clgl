package com.hsl.clgl.sh.pc.admin.modules.sys.dao;

import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商户用户表
 * 
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 15:49:01
 */
@Component
public interface ShUserDao extends BaseMapper<ShUserEntity> {

    /**
     * 根据用户id查询用户权限
     * @param userId
     * @return
     */
   public List<String> queryAllPerms (String userId);

    /**
     * 根据用户名查询用户
     */
    public ShUserEntity selectUserByUsername(String username);

    /**
     * 查询用户的所有菜单ID
     */
    List<String> queryAllMenuId(String userId);
}
