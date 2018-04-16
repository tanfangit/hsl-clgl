package com.hsl.clgl.pc.admin.modules.maintenance.car.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.maintenance.car.dao.CarTypeDao;
import com.hsl.clgl.pc.admin.modules.maintenance.car.entity.CarTypeEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.car.service.CarTypeService;
import com.hsl.clgl.pc.admin.utils.Constant;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("carTypeService")
public class CarTypeServiceImpl extends ServiceImpl<CarTypeDao, CarTypeEntity> implements CarTypeService {
    @Autowired
    private CarTypeDao carTypeDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        Page<CarTypeEntity> page = this.selectPage(
//                new Query<CarTypeEntity>(params).getPage(),
//                new EntityWrapper<CarTypeEntity>()
//        );
        params.put(ColumnConstant.STATUS, Constant.STATUS_USED);
        Page<CarTypeEntity> page = new Query<CarTypeEntity>(params).getPage();
        page.setRecords(carTypeDao.queryTypeList(page,params));
        return new PageUtils(page);
    }



    @Override
    public List<CarTypeEntity> queryAllCarType() {
        List<CarTypeEntity> List =
                this.selectList(new EntityWrapper<CarTypeEntity>()
                        .eq(ColumnConstant.STATUS, Constant.STATUS_USED));
        return  List;
    }

}
