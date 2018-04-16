package com.hsl.clgl.pc.admin.modules.trailer.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.trailer.dao.TrailerDriverDao;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerDriverEntity;
import com.hsl.clgl.pc.admin.modules.trailer.service.TrailerDriverService;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("trailerDriverService")
public class TrailerDriverServiceImpl extends ServiceImpl<TrailerDriverDao, TrailerDriverEntity> implements TrailerDriverService {

    @Autowired
    TrailerDriverDao trailerDriverDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TrailerDriverEntity> page = new Query<TrailerDriverEntity>(params).getPage();
        page.setRecords(trailerDriverDao.queryTrailerDriverList(page, params));
        return new PageUtils(page);
    }

}
