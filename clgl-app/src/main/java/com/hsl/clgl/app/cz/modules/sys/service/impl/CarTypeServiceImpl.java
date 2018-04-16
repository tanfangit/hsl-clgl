package com.hsl.clgl.app.cz.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.app.cz.modules.sys.dao.CarTypeDao;
import com.hsl.clgl.app.cz.modules.sys.entity.CarTypeEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CarTypeService;
import com.hsl.clgl.app.utils.Constant;
import com.hsl.clgl.app.utils.Query;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("carTypeService")
public class CarTypeServiceImpl extends ServiceImpl<CarTypeDao, CarTypeEntity> implements CarTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CarTypeEntity> page = this.selectPage(
                new Query<CarTypeEntity>(params).getPage(),
                new EntityWrapper<CarTypeEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    public List<CarTypeEntity> queryAllCarTypeByTrainId(String trainId) {
        List<CarTypeEntity> List =
                this.selectList(new EntityWrapper<CarTypeEntity>()
                        .eq(ColumnConstant.STATUS, Constant.STATUS_USED)
                        .eq(ColumnConstant.TRAIN_ID,trainId));
        return  List;
    }
}
