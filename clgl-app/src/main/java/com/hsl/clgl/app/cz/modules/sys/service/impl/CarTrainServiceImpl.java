package com.hsl.clgl.app.cz.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.app.cz.modules.sys.dao.CarTrainDao;
import com.hsl.clgl.app.cz.modules.sys.entity.CarTrainEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CarTrainService;
import com.hsl.clgl.app.utils.Constant;
import com.hsl.clgl.app.utils.Query;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("carTrainService")
public class CarTrainServiceImpl extends ServiceImpl<CarTrainDao, CarTrainEntity> implements CarTrainService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CarTrainEntity> page = this.selectPage(
                new Query<CarTrainEntity>(params).getPage(),
                new EntityWrapper<CarTrainEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    public List<CarTrainEntity> queryCarTrainByBranId(String brandId) {
        List<CarTrainEntity> carTrainList =
                this.selectList(new EntityWrapper<CarTrainEntity>()
                        .eq(ColumnConstant.STATUS, Constant.STATUS_USED)
                        .eq(ColumnConstant.BRAND_ID,brandId));
        return carTrainList;
    }
}
