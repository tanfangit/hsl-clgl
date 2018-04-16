package com.hsl.clgl.pc.admin.modules.maintenance.car.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.hsl.clgl.pc.admin.modules.maintenance.car.entity.CarTrainEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 车系表
 * 
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-03-27 10:06:21
 */
@Component
public interface CarTrainDao extends BaseMapper<CarTrainEntity> {
    List<CarTrainEntity> queryTrainList(Page<CarTrainEntity> page,Map<String, Object> params);
    List<CarTrainEntity> queryTrain(Map<String, Object> params);
}
