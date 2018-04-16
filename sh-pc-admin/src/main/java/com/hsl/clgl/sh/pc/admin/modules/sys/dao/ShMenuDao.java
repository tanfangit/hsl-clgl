package com.hsl.clgl.sh.pc.admin.modules.sys.dao;

import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShMenuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单
 * 
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-04-02 16:00:29
 */
public interface ShMenuDao extends BaseMapper<ShMenuEntity> {

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<ShMenuEntity> queryListParentId(@Param("parentId") String parentId, @Param("shId")String shId);

    /**
     * 获取不包含按钮的菜单列表
     */
    List<ShMenuEntity> queryNotButtonList(String shId);
	
}
