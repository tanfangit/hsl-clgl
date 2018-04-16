package com.hsl.clgl.app.cz.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.app.cz.modules.sys.dao.CzCarDao;
import com.hsl.clgl.app.cz.modules.sys.entity.CarEntity;
import com.hsl.clgl.app.cz.modules.sys.entity.CzCarEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CzCarService;
import com.hsl.clgl.app.utils.Query;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.MapUtils;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("czCarService")
public class CzCarServiceImpl extends ServiceImpl<CzCarDao, CzCarEntity> implements CzCarService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CzCarEntity> page = this.selectPage(
                new Query<CzCarEntity>(params).getPage(),
                new EntityWrapper<CzCarEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    public void saveOrupdate(CarEntity carEntity) {
        //先删除关联
        this.deleteByMap(new MapUtils().put(ColumnConstant.CZ_ID,carEntity.getCzId()));
        //在新增关联
        CzCarEntity  czCarEntity=new CzCarEntity();
        czCarEntity.setId(UUIDUtil.generateUUID());
        czCarEntity.setCzId(carEntity.getCzId());
        czCarEntity.setCarId(carEntity.getCarId());
        this.insert(czCarEntity);
    }
}
