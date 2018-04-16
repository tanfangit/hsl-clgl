package com.hsl.clgl.pc.admin.modules.maintenance.parts.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.maintenance.parts.entity.PartsEntity;

import java.util.Map;

/**
 * 配件数据维护
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-26 20:44:02
 */
public interface PartsService extends IService<PartsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     *  新增零配件
     * @param partsEntity
     */
    void save(PartsEntity partsEntity);

    /**
     * 修改零配件
     */
    void update(PartsEntity partsEntity);

}

