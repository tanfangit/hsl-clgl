package com.hsl.clgl.sh.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShDeptEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-03 10:15:08
 */
public interface ShDeptService extends IService<ShDeptEntity> {

    PageUtils queryPage(Map<String, Object> params);


    /**
     * 查询部门树
     * @return
     */
    List<ShDeptEntity> getDeptAll();

    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<String> queryDetpIdList(String parentId);

}

