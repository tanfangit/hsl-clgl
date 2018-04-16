package com.hsl.clgl.app.cz.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.app.cz.modules.sys.entity.CarTrainEntity;
import com.hsl.clgl.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 车系表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-03 13:49:21
 */
public interface CarTrainService extends IService<CarTrainEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 通过车辆品牌id   查询所属该车辆品牌下的所有车系
     */
    List<CarTrainEntity> queryCarTrainByBranId(String brandId);
}

