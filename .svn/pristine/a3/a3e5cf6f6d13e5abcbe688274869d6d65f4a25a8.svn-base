package com.hsl.clgl.app.cz.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.app.cz.modules.sys.entity.CarEntity;
import com.hsl.clgl.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 车主对应的车辆表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-02 13:47:43
 */
public interface CarService extends IService<CarEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 通过车主id  查询所拥有的车辆List
     * @param carId
     * @return
     */
    List<CarEntity>  queryCarListById(String carId);

    /**
     * 新增车主车辆
     * @param carEntity
     */
     void  addCar(CarEntity  carEntity);
}

