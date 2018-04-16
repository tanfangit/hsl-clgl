package com.hsl.clgl.sh.pc.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.sh.pc.admin.modules.sys.dao.ShRoleMenuDao;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShRoleMenuEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShRoleMenuService;
import com.hsl.clgl.sh.pc.admin.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("shRoleMenuService")
public class ShRoleMenuServiceImpl extends ServiceImpl<ShRoleMenuDao, ShRoleMenuEntity> implements ShRoleMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShRoleMenuEntity> page = this.selectPage(
                new Query<ShRoleMenuEntity>(params).getPage(),
                new EntityWrapper<ShRoleMenuEntity>()
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
        List<ShRoleMenuEntity> list = new ArrayList<>(menuIdList.size());
        for(String menuId : menuIdList){
            ShRoleMenuEntity shRoleMenuEntity = new ShRoleMenuEntity();
            shRoleMenuEntity.setId(UUIDUtil.generateUUID());
            shRoleMenuEntity.setMenuId(menuId);
            shRoleMenuEntity.setRoleId(roleId);
            list.add(shRoleMenuEntity);
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
