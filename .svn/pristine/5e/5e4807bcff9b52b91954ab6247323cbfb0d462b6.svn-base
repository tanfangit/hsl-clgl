package com.hsl.clgl.sh.pc.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.sh.pc.admin.modules.sys.dao.ShRoleDao;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShRoleEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShRoleMenuService;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShRoleService;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShUserRoleService;
import com.hsl.clgl.sh.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.sh.pc.admin.utils.Constant;
import com.hsl.clgl.sh.pc.admin.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("shRoleService")
public class ShRoleServiceImpl extends ServiceImpl<ShRoleDao, ShRoleEntity> implements ShRoleService {

    @Autowired
    private ShRoleDao shRoleDao;
    @Autowired
    ShRoleMenuService shRoleMenuService;
    @Autowired
    ShUserRoleService shUserRoleService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String roleName=(String)params.get("rolename");
        //当前商户id
        String  shId= ShiroUtils.getShId();
        Page<ShRoleEntity> page = this.selectPage(
                new Query<ShRoleEntity>(params).getPage(),
                new EntityWrapper<ShRoleEntity>().eq(ColumnConstant.SH_ID,shId)
                        .eq(ColumnConstant.STATUS, Constant.STATUS_USED)
                        .like(StringUtils.isNotBlank(roleName),ColumnConstant.ROLE_NAME, roleName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<ShRoleEntity> queryUserRoleListByUserId (String userId) {
      return  this.shRoleDao.queryUserRoleListByUserId(userId);
    }

    @Override
    public List<ShRoleEntity> queryRoleList(String shId) {
        List<ShRoleEntity> list=shRoleDao.queryRoleList(shId);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ShRoleEntity role) {
        //角色id
        role.setRoleId(UUIDUtil.generateUUID());
        //当前用户
        role.setCreateUser(ShiroUtils.getUserId());
        //当前时间
        role.setCreateTime(new Date());
        //商户id
        String shId=ShiroUtils.getShId();
        role.setShId(shId);
        this.insert(role);
        //保存角色与菜单关系
        shRoleMenuService.saveOrUpdate(role.getRoleId(),role.getMenusdList());

    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ShRoleEntity role) {
        //更新时间
        role.setUpdateTime(new Date());
        role.setUpdateUser(ShiroUtils.getUserId());
        this.updateById(role);
        //更新角色与菜单关系
        shRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenusdList());

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(String roleId) {
        //删除角色
        ShRoleEntity sysRoleEntity=new ShRoleEntity();
        //设置删除状态
        sysRoleEntity.setStatus(Constant.STATUS_DELETED);
        sysRoleEntity.setRoleId(roleId);
        this.updateById(sysRoleEntity);
        //删除角色与菜单关联
        HashMap map=new HashMap();
        map.put("role_id",roleId);
        shRoleMenuService.deleteByMap(map);
        //删除角色与用户关联
        shUserRoleService.deleteByMap(map);

    }

}
