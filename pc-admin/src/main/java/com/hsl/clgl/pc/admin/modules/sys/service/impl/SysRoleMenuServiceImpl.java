package com.hsl.clgl.pc.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.sys.dao.SysRoleMenuDao;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysRoleMenuEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysRoleMenuService;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysRoleMenuEntity> page = this.selectPage(
                new Query<SysRoleMenuEntity>(params).getPage(),
                new EntityWrapper<SysRoleMenuEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(String roleId, List<String> menuIdList) {
        //先删除角色与菜单关系
        deleteBatch(new String[]{roleId});
        if(menuIdList.size() == 0){
            return ;
        }
        //保存角色与菜单关系
        List<SysRoleMenuEntity> list = new ArrayList<>(menuIdList.size());
        for(String menuId : menuIdList){
            SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
            sysRoleMenuEntity.setId(UUIDUtil.generateUUID());
            sysRoleMenuEntity.setMenuId(menuId);
            sysRoleMenuEntity.setRoleId(roleId);
            list.add(sysRoleMenuEntity);
        }
        this.insertBatch(list);
    }

    @Override
    public int deleteBatch(String[] roleIds){
        return baseMapper.deleteBatch(roleIds);
    }



    @Override
    public List<String > queryMenuIdList(String roleId) {
        return baseMapper.queryMenuIdList(roleId);
    }

}
