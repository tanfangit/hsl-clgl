package com.hsl.clgl.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysDeptEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-24 17:24:13
 */
public interface SysDeptService extends IService<SysDeptEntity> {

    PageUtils queryPage(Map<String, Object> params);


    /**
     * 查询部门树
     * @return
     */
     List<SysDeptEntity> getDeptAll();

    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<String> queryDetpIdList(String parentId);
}

