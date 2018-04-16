package com.hsl.clgl.pc.admin.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysRoleEntity;

import java.util.List;

/**
 * 角色
 * 
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-03-17 15:19:54
 */
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {

    public List<SysRoleEntity> queryRoleList();
	
}
