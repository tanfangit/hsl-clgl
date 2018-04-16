package com.hsl.clgl.pc.admin.modules.area.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.pc.admin.modules.area.dao.AreaDao;
import com.hsl.clgl.pc.admin.modules.area.entity.AreaEntity;
import com.hsl.clgl.pc.admin.modules.area.service.AreaService;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;



@Service("areaService")
public class AreaServiceImpl extends ServiceImpl<AreaDao, AreaEntity> implements AreaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AreaEntity> page = this.selectPage(
                new Query<AreaEntity>(params).getPage(),
                new EntityWrapper<AreaEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<AreaEntity> queryAreaListByLevel(Integer level) {
        return this.selectList(new EntityWrapper<AreaEntity>().eq(ColumnConstant.AREA_LEVEL,level));
    }
}
