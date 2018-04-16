package com.hsl.clgl.app.cz.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.app.cz.modules.sys.dao.CarBrandDao;
import com.hsl.clgl.app.cz.modules.sys.entity.CarBrandEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CarBrandService;
import com.hsl.clgl.app.utils.Constant;
import com.hsl.clgl.app.utils.Query;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("carBrandService")
public class CarBrandServiceImpl extends ServiceImpl<CarBrandDao, CarBrandEntity> implements CarBrandService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CarBrandEntity> page = this.selectPage(
                new Query<CarBrandEntity>(params).getPage(),
                new EntityWrapper<CarBrandEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    public List<CarBrandEntity> queryAllCarBrand() {
        List<CarBrandEntity> carBrandList =
                this.selectList(new EntityWrapper<CarBrandEntity>()
                        .eq(ColumnConstant.STATUS, Constant.STATUS_USED));
        return carBrandList;
    }
}
