package com.hsl.clgl.sh.pc.admin.modules.sys.service.impl;

import com.hsl.clgl.sh.pc.admin.modules.sys.dao.ShRoleDao;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShRoleEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShUserService;
import com.hsl.clgl.sh.pc.admin.utils.Constant;
import com.hsl.clgl.sh.pc.admin.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;

import com.hsl.clgl.sh.pc.admin.modules.sys.dao.ShMenuDao;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShMenuEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShMenuService;


@Service("shMenuService")
public class ShMenuServiceImpl extends ServiceImpl<ShMenuDao, ShMenuEntity> implements ShMenuService {

    @Autowired
    private ShUserService shUserService;
    @Autowired
    private ShRoleDao shRoleDao;
    /**
     * 获取所有菜单列表
     */
    private List<ShMenuEntity> getAllMenuList(List<String> menuIdList, String contextPath,String shId){
        //查询根菜单列表
        List<ShMenuEntity> menuList = queryListParentId("0", menuIdList,shId);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList,contextPath,shId);

        return menuList;
    }

    @Override
    public List<ShMenuEntity> queryListParentIdBySh(String parentId,String shId) {
        return baseMapper.queryListParentId(parentId,shId);
    }

    @Override
    public List<ShMenuEntity> queryListParentId(String parentId, List<String> menuIdList,String shId) {
        List<ShMenuEntity> menuList = queryListParentIdBySh(parentId,shId);
        if(menuIdList == null){
            return menuList;
        }

        List<ShMenuEntity> userMenuList = new ArrayList<>();
        for(ShMenuEntity menu : menuList){
            if(menuIdList.contains(menu.getMenuId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    @Override
    public List<ShMenuEntity> getUserMenuList(String userId,String shId) {

        //根据用户id查询用户角色
        List<ShRoleEntity> userRoles = this.shRoleDao.queryUserRoleListByUserId(userId);
        boolean isAdmin = false;
        for (ShRoleEntity role : userRoles) {
            //判断用户是否是超级管理员
            if (Constant.SUPER_ADMIN.equalsIgnoreCase(role.getRoleName())){
                isAdmin = true;
                break;
            }
        }
        //系统管理员，拥有最高权限
        if(isAdmin){
            return getAllMenuList(null,null,shId);
        }

        //用户菜单列表
        List<String> menuIdList = shUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList,null,shId);
    }

    /**
     * 获取用户菜单方法，加上工程名拼接url路径
     * @param userId
     * @param contextPath
     * @return
     */
    public List<ShMenuEntity> getUserRequestMenuList(String userId,String contextPath,String shId) {
        //根据用户id查询用户角色
        List<ShRoleEntity> userRoles = this.shRoleDao.queryUserRoleListByUserId(userId);
        boolean isAdmin = false;
        for (ShRoleEntity role : userRoles) {
            //判断用户是否是超级管理员
            if (Constant.SUPER_ADMIN.equalsIgnoreCase(role.getRoleName())){
                isAdmin = true;
                break;
            }
        }
        //系统管理员，拥有最高权限
        if(isAdmin){
            return getAllMenuList(null,contextPath,shId);
        }

        //用户菜单列表
        List<String> menuIdList = this.shUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList,contextPath,shId);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShMenuEntity> page = this.selectPage(
                new Query<ShMenuEntity>(params).getPage(),
                new EntityWrapper<ShMenuEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 递归
     */
    private List<ShMenuEntity> getMenuTreeList(List<ShMenuEntity> menuList, List<String> menuIdList,String contextPath,String shId){
        List<ShMenuEntity> subMenuList = new ArrayList<ShMenuEntity>();

        for(ShMenuEntity entity : menuList){
            //目录
            if(entity.getType() == Constant.MenuType.CATALOG.getValue()){
                entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList,shId), menuIdList,contextPath,shId));
            }
            if (StringUtils.isNotBlank(contextPath) && StringUtils.isNotBlank(entity.getUrl())) {
                entity.setUrl(contextPath+entity.getUrl());
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }


    /**
     * 递归( 包括目录、菜单、按钮)
     */
    private List<ShMenuEntity> getAllMenuTreeList(List<ShMenuEntity> menuList, List<String> menuIdList,String shId){
        List<ShMenuEntity> subMenuList = new ArrayList<ShMenuEntity>();

        for(ShMenuEntity entity : menuList){
            //目录
            if(entity.getType() != Constant.MenuType.BUTTON.getValue()){
                entity.setList(getAllMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList,shId), menuIdList,shId));
            }
            if (null == entity.getList() || entity.getList().isEmpty()) {
                entity.setList(new ArrayList<>());
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }


    /**
     * 查询菜单树结构
     */
    public List<ShMenuEntity> getMenuAll(String shId){
        //查询根菜单列表
        List<ShMenuEntity> menuList = queryListParentId("0", null,shId);
        return getAllMenuTreeList(menuList,null,shId);
    }



    /**
     * 查询角色已拥有的菜单树结构
     */
    public List<ShMenuEntity> getSelectMenuAll(List<String> selectMenus,String shId){
        //查询根菜单列表
        List<ShMenuEntity> menuList = queryListParentId("0", null,shId);
        return getSelectMenuTreeList(menuList,selectMenus,null, shId);
    }

    /**
     * 递归( 包括目录、菜单、按钮)
     */
    private List<ShMenuEntity> getSelectMenuTreeList(List<ShMenuEntity> menuList, List<String> selectMenus, List<String> menuIdList,String shId){
        List<ShMenuEntity> subMenuList = new ArrayList<ShMenuEntity>();

        for(ShMenuEntity entity : menuList){
            //目录
            if(entity.getType() != Constant.MenuType.BUTTON.getValue()){
                entity.setList(getAllMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList,shId), menuIdList,shId));
            }
            subMenuList.add(entity);
        }
        Switch( subMenuList, selectMenus);
        return subMenuList;
    }



    /**
     * 递归  遍历   给角色已拥有的菜单 的checked赋值为true
     * @param list
     * @return
     */
    public List<ShMenuEntity> Switch(List<ShMenuEntity> list,List<String> selectMenuList) {
        for (int i = 0; i < list.size(); i++) {
            if(selectMenuList.contains(list.get(i).getMenuId())){
                list.get(i).setChecked(true);
            }else{
                Switch( list.get(i).getList(),selectMenuList);
            }

        }
        return list;
    }


}
