package com.hsl.clgl.app.cz.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.app.cz.modules.sys.entity.CarTypeEntity;
import com.hsl.clgl.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 车型表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-02 15:42:02
 */
public interface CarTypeService extends IService<CarTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 通过车系id    查询该车系下的所属车型
     * @return
     */
    List<CarTypeEntity> queryAllCarTypeByTrainId(String trainId);
}

