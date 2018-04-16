package com.hsl.clgl.pc.admin.modules.maintenance.car.dao;

import com.hsl.clgl.pc.admin.modules.maintenance.car.entity.CarBrandEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 车辆品牌表
 * 
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-03-24 13:51:54
 */
@Component
public interface CarBrandDao extends BaseMapper<CarBrandEntity> {
    List<CarBrandEntity> queryBrand(Map<String, Object> params);
}
