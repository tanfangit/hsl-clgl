package com.hsl.clgl.pc.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.sys.dao.SysMenuDao;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysMenuEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysMenuService;
import com.hsl.clgl.pc.admin.modules.sys.service.SysUserService;
import com.hsl.clgl.pc.admin.utils.Constant;
import com.hsl.clgl.pc.admin.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    @Autowired
    private SysUserService sysUserService;
    /**
     * 获取所有菜单列表
     */
    private List<SysMenuEntity> getAllMenuList(List<String> menuIdList,String contextPath){
        //查询根菜单列表
        List<SysMenuEntity> menuList = queryListParentId("0", menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList,contextPath);

        return menuList;
    }

    @Override
    public List<SysMenuEntity> queryListParentId(String parentId) {
        return baseMapper.queryListParentId(parentId);
    }

    @Override
    public List<SysMenuEntity> queryListParentId(String parentId, List<String> menuIdList) {
        List<SysMenuEntity> menuList = queryListParentId(parentId);
        if(menuIdList == null){
            return menuList;
        }

        List<SysMenuEntity> userMenuList = new ArrayList<>();
        for(SysMenuEntity menu : menuList){
            if(menuIdList.contains(menu.getMenuId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    @Override
    public List<SysMenuEntity> getUserMenuList(String userId) {
        //系统管理员，拥有最高权限
        if(Constant.SUPER_ADMIN.equalsIgnoreCase(userId)){
            return getAllMenuList(null,null);
        }

        //用户菜单列表
        List<String> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList,null);
    }

    /**
     * 获取用户菜单方法，加上工程名拼接url路径
     * @param userId
     * @param contextPath
     * @return
     */
    public List<SysMenuEntity> getUserRequestMenuList(String userId,String contextPath) {
        //系统管理员，拥有最高权限
        if(Constant.SUPER_ADMIN.equalsIgnoreCase(userId)){
            return getAllMenuList(null,contextPath);
        }

        //用户菜单列表
        List<String> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList,contextPath);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysMenuEntity> page = this.selectPage(
                new Query<SysMenuEntity>(params).getPage(),
                new EntityWrapper<SysMenuEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 递归
     */
    private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<String> menuIdList,String contextPath){
        List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();

        for(SysMenuEntity entity : menuList){
            //目录
            if(entity.getType() == Constant.MenuType.CATALOG.getValue()){
                entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList,contextPath));
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
    private List<SysMenuEntity> getAllMenuTreeList(List<SysMenuEntity> menuList, List<String> menuIdList){
        List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();

        for(SysMenuEntity entity : menuList){
            //目录
            if(entity.getType() != Constant.MenuType.BUTTON.getValue()){
                entity.setList(getAllMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
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
    public List<SysMenuEntity> getMenuAll(){
        //查询根菜单列表
        List<SysMenuEntity> menuList = queryListParentId("0", null);
        return getAllMenuTreeList(menuList,null);
    }



    /**
     * 查询角色已拥有的菜单树结构
     */
    public List<SysMenuEntity> getSelectMenuAll(List<String> selectMenus){
        //查询根菜单列表
        List<SysMenuEntity> menuList = queryListParentId("0", null);
        return getSelectMenuTreeList(menuList,selectMenus,null);
    }

    /**
     * 递归( 包括目录、菜单、按钮)
     */
    private List<SysMenuEntity> getSelectMenuTreeList(List<SysMenuEntity> menuList, List<String> selectMenus, List<String> menuIdList){
        List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();

        for(SysMenuEntity entity : menuList){
            //目录
            if(entity.getType() != Constant.MenuType.BUTTON.getValue()){
                entity.setList(getAllMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
            }
            if (null == entity.getList() || entity.getList().isEmpty()) {
                entity.setList(new ArrayList<>());
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
    public List<SysMenuEntity> Switch(List<SysMenuEntity> list,List<String> selectMenuList) {
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
