package com.hsl.clgl.pc.admin.modules.maintenance.car.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.maintenance.car.dao.CarBrandDao;
import com.hsl.clgl.pc.admin.modules.maintenance.car.entity.CarBrandEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.car.service.CarBrandService;
import com.hsl.clgl.pc.admin.utils.Constant;
import com.hsl.clgl.pc.admin.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("carBrandService")
public class CarBrandServiceImpl extends ServiceImpl<CarBrandDao, CarBrandEntity> implements CarBrandService {
    @Autowired
    private CarBrandDao carBrandDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String brandName = "";
        if(params.get("brandName") != null){
            brandName = (String)params.get("brandName");
        }
        Page<CarBrandEntity> page = this.selectPage(
                new Query<CarBrandEntity>(params).getPage(),
                new EntityWrapper<CarBrandEntity>().like(StringUtils.isNotBlank(brandName), ColumnConstant.BRAND_NAME, brandName).
                        eq(ColumnConstant.STATUS, Constant.STATUS_USED)
        );

        return new PageUtils(page);
    }
    @Override
    public List<CarBrandEntity> queryBrand(Map<String, Object> params) {
        params.put(ColumnConstant.STATUS, Constant.STATUS_USED);
        List<CarBrandEntity> list = carBrandDao.queryBrand(params);
        return list;
    }

}
