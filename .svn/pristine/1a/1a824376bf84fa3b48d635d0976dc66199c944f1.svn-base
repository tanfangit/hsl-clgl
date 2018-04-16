package com.hsl.clgl.app.cz.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.app.cz.modules.sys.dao.CarDao;
import com.hsl.clgl.app.cz.modules.sys.entity.CarEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CarService;
import com.hsl.clgl.app.cz.modules.sys.service.CzCarService;
import com.hsl.clgl.app.utils.Query;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("carService")
public class CarServiceImpl extends ServiceImpl<CarDao, CarEntity> implements CarService {
   @Autowired
    CarDao  carDao;
   @Autowired
   CzCarService czCarService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CarEntity> page = this.selectPage(
                new Query<CarEntity>(params).getPage(),
                new EntityWrapper<CarEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    public List<CarEntity> queryCarListById(String carId) {
          List<CarEntity>  list=carDao.queryCarList(carId);
            return list;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCar(CarEntity carEntity) {
         //插入一条车辆信息
        carEntity.setCreateTime(new Date());
        carEntity.setCarId(UUIDUtil.generateUUID());
           this.insert(carEntity);
           //在插入一条车主与车辆关系表
        czCarService.saveOrupdate(carEntity);

    }
}
