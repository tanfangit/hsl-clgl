package com.hsl.clgl.pc.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.sys.dao.SysUserRoleDao;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysUserRoleEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysUserRoleService;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.stereotype.Service;
import com.hsl.clgl.common.utils.MapUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUserRoleEntity> page = this.selectPage(
                new Query<SysUserRoleEntity>(params).getPage(),
                new EntityWrapper<SysUserRoleEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<String> queryRoleIdList(String userId) {
        return baseMapper.queryRoleIdList(userId);
    }



    public void saveOrUpdate(String userId, List<String> roleIdList) {
        //先删除用户与角色关系
        //this.deleteByMap(new MapUtils().put("user_id", userId));
          this.deleteByMap(new MapUtils().put("user_id", userId));
        if(roleIdList.size() == 0){
            return ;
        }
        //保存用户与角色关系
        List<SysUserRoleEntity> list = new ArrayList<>(roleIdList.size());
        for(String roleId : roleIdList){
            SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
            sysUserRoleEntity.setId(UUIDUtil.generateUUID());
            sysUserRoleEntity.setUserId(userId);
            sysUserRoleEntity.setRoleId(roleId);
            list.add(sysUserRoleEntity);
        }
        //批量插入
        this.insertBatch(list);
    }

}
