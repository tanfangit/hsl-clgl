package com.hsl.clgl.pc.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.sys.dao.SysUserDao;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysUserEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysUserRoleService;
import com.hsl.clgl.pc.admin.modules.sys.service.SysUserService;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import com.hsl.clgl.pc.admin.utils.Query;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public List<String> queryAllMenuId(String userId) {
        return baseMapper.queryAllMenuId(userId);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String)params.get("username");
        String name=(String)params.get("name");
        Page<SysUserEntity> page = this.selectPage(
                new Query<SysUserEntity>(params).getPage(),
                new EntityWrapper<SysUserEntity>().like(StringUtils.isNotBlank(username),"username", username)
                        .like(StringUtils.isNotBlank(name),"name", name).eq(ColumnConstant.STATUS, Constant.STATUS_USED)
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserEntity user) {
        user.setCreateTime(new Date());
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setSalt(salt);
        user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
        //用户id
        String userID= UUIDUtil.generateUUID();
        user.setUserId(userID);
        user.setCreateUser(ShiroUtils.getUserId());
        this.insert(user);
        //保存用户与角色关系

       sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysUserEntity user) {
       // if(StringUtils.isBlank(user.getPassword())){
            //user.setPassword(null);
       // }else{
        if(StringUtils.isNotBlank(user.getPassword())) {
            user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));

        }

        user.setUpdateUser(ShiroUtils.getUserId());
        user.setUpdateTime(new Date());
        this.updateById(user);
        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());

    }




}
