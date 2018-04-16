package com.hsl.clgl.app.cz.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.app.cz.modules.sys.entity.CarEntity;
import com.hsl.clgl.app.cz.modules.sys.entity.CzCarEntity;
import com.hsl.clgl.common.utils.PageUtils;

import java.util.Map;

/**
 * 车主与车辆关联表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-02 13:50:45
 */
public interface CzCarService extends IService<CzCarEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveOrupdate(CarEntity carEntity);
}

