package com.hsl.clgl.sh.pc.admin.modules.sys.dao;

import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShRoleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色
 * 
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
@Component
public interface ShRoleDao extends BaseMapper<ShRoleEntity> {

    public List<ShRoleEntity> queryUserRoleListByUserId (String userId);

    /**
     * 查询所有角色
     * @return
     */
    public List<ShRoleEntity> queryRoleList(@Param("shId")String shId);
}
