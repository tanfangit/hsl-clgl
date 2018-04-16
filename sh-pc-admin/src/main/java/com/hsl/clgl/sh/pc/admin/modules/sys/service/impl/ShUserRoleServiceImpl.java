package com.hsl.clgl.sh.pc.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.MapUtils;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.sh.pc.admin.modules.sys.dao.ShUserDao;
import com.hsl.clgl.sh.pc.admin.modules.sys.dao.ShUserRoleDao;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShUserRoleEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShUserRoleService;
import com.hsl.clgl.sh.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("shUserRoleService")
public class ShUserRoleServiceImpl extends ServiceImpl<ShUserRoleDao, ShUserRoleEntity> implements ShUserRoleService {

    @Autowired
    private ShUserDao shUserDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShUserRoleEntity> page = this.selectPage(
                new Query<ShUserRoleEntity>(params).getPage(),
                new EntityWrapper<ShUserRoleEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<String> queryAllPerms (String userId) {
       return this.shUserDao.queryAllPerms(userId);
    }


    @Override
    public void saveOrUpdate(String userId, List<String> roleIdList) {
        //先删除用户与角色关系
        this.deleteByMap(new MapUtils().put("user_id", userId));
        if(roleIdList.size() == 0){
            return ;
        }
        //保存用户与角色关系
        List<ShUserRoleEntity> list = new ArrayList<>(roleIdList.size());
        for(String roleId : roleIdList){
            ShUserRoleEntity sysUserRoleEntity = new ShUserRoleEntity();
            sysUserRoleEntity.setId(UUIDUtil.generateUUID());
            sysUserRoleEntity.setUserId(userId);
            sysUserRoleEntity.setRoleId(roleId);
            list.add(sysUserRoleEntity);
        }
        //批量插入
        this.insertBatch(list);
    }


    @Override
    public List<String> queryRoleIdList(String userId) {
        return baseMapper.queryRoleIdList(userId);
    }

}
