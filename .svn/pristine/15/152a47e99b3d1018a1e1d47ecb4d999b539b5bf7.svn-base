package com.hsl.clgl.sh.pc.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.sh.pc.admin.modules.sys.dao.ShUserDao;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShUserEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShUserRoleService;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShUserService;
import com.hsl.clgl.sh.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.sh.pc.admin.utils.Constant;
import com.hsl.clgl.sh.pc.admin.utils.Query;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("shUserService")
public class ShUserServiceImpl extends ServiceImpl<ShUserDao, ShUserEntity> implements ShUserService {

    @Autowired
    private ShUserDao shUserDao;
    @Autowired
    ShUserRoleService shUserRoleService;

    @Override
    public List<String> queryAllMenuId(String userId) {
        return baseMapper.queryAllMenuId(userId);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //当前商户id
        String  shId= ShiroUtils.getShId();
        //用户名
        String username = (String)params.get("username");
        //真实姓名
        String name=(String)params.get("name");
        Page<ShUserEntity> page = this.selectPage(
                new Query<ShUserEntity>(params).getPage(),
                new EntityWrapper<ShUserEntity>().eq(ColumnConstant.SH_ID,shId)
                        .like(StringUtils.isNotBlank(username),ColumnConstant.USERNAME, username)
                        .like(StringUtils.isNotBlank(name),ColumnConstant.NAME, name)
                        .eq(ColumnConstant.STATUS, Constant.STATUS_USED)
        );

        return new PageUtils(page);
    }

    @Override
    public ShUserEntity selectUserByUsername(String username) {
        return this.shUserDao.selectUserByUsername(username);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ShUserEntity user) {
        user.setCreateTime(new Date());
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setSalt(salt);
        user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
        //用户id
        String userID= UUIDUtil.generateUUID();
        user.setUserId(userID);
        user.setCreateUser(ShiroUtils.getUserId());
        //当前商户id
        String shId=ShiroUtils.getShId();
        user.setShId(shId);
        this.insert(user);
        //保存用户与角色关系
        shUserRoleService.saveOrUpdate(user.getUserId(),user.getRoleIdList());


    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ShUserEntity user) {
        if(StringUtils.isNotBlank(user.getPassword())) {
            user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));

        }
        user.setUpdateUser(ShiroUtils.getUserId());
        user.setUpdateTime(new Date());
        this.updateById(user);
        //保存用户与角色关系
        shUserRoleService.saveOrUpdate(user.getUserId(),user.getRoleIdList());

    }
}
