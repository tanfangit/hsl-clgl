package com.hsl.clgl.pc.admin.modules.cz.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.cz.entity.CzEntity;

import java.util.Map;

/**
 * 车主管理表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-30 08:19:36
 */
public interface CzService extends IService<CzEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 通过车主id 查询车主信息
     * @param czId
     * @return
     */
    CzEntity selectInfoById(String czId);
}

