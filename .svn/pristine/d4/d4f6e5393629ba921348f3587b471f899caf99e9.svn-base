package com.hsl.clgl.pc.admin.modules.area.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.area.entity.AreaEntity;

import java.util.List;
import java.util.Map;

/**
 * 区县行政编码字典表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-28 11:58:15
 */
public interface AreaService extends IService<AreaEntity> {

    PageUtils queryPage(Map<String, Object> params);


    public List<AreaEntity> queryAreaListByLevel(Integer level);
}

