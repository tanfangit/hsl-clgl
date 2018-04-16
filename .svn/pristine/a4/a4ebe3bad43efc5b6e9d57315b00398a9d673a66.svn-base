package com.hsl.clgl.pc.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.sys.dao.SysRoleDao;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysRoleEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysRoleMenuService;
import com.hsl.clgl.pc.admin.modules.sys.service.SysRoleService;
import com.hsl.clgl.pc.admin.modules.sys.service.SysUserRoleService;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import com.hsl.clgl.pc.admin.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String roleName=(String)params.get("rolename");
        Page<SysRoleEntity> page = this.selectPage(
                new Query<SysRoleEntity>(params).getPage(),
                new EntityWrapper<SysRoleEntity>() .like(StringUtils.isNotBlank(roleName),ColumnConstant.ROLE_NAME, roleName).eq(ColumnConstant.STATUS, Constant.STATUS_USED)
        );

        return new PageUtils(page);
    }

    public List<SysRoleEntity> queryRoleList(){
        List<SysRoleEntity> roles=baseMapper.queryRoleList();

       return roles;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysRoleEntity role) {
        //角色id
        role.setRoleId(UUIDUtil.generateUUID());
        //当前用户
        role.setCreateUser(ShiroUtils.getUserId());
        //当前时间
        role.setCreateTime(new Date());
        this.insert(role);
        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenusdList());

    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(String roleId) {
       //删除角色
        SysRoleEntity sysRoleEntity=new SysRoleEntity();
        //设置删除状态
        sysRoleEntity.setStatus(Constant.STATUS_DELETED);
        sysRoleEntity.setRoleId(roleId);
        this.updateById(sysRoleEntity);
        //删除角色与菜单关联
        HashMap map=new HashMap();
        map.put("role_id",roleId);
        sysRoleMenuService.deleteByMap(map);
        //删除角色与用户关联
        sysUserRoleService.deleteByMap(map);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleEntity role) {
        //更新时间
        role.setUpdateTime(new Date());
        role.setUpdateUser(ShiroUtils.getUserId());
        this.updateById(role);
        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenusdList());

    }
}
