package com.hsl.clgl.pc.admin.modules.cz.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.cz.dao.CzDao;
import com.hsl.clgl.pc.admin.modules.cz.entity.CzEntity;
import com.hsl.clgl.pc.admin.modules.cz.service.CzService;
import com.hsl.clgl.pc.admin.modules.maintenance.car.service.CarTypeService;
import com.hsl.clgl.pc.admin.utils.Constant;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("czService")
public class CzServiceImpl extends ServiceImpl<CzDao, CzEntity> implements CzService {
    @Autowired
    CzDao  czDao;
    @Autowired
    private CarTypeService carTypeService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        params.put("status", Constant.STATUS_USED);
        Page<CzEntity> page = new Query<CzEntity>(params).getPage();
        page.setRecords(czDao.queryCzList(page, params));
        return new PageUtils(page);
    }


    @Override
    public CzEntity selectInfoById(String czId) {
        CzEntity  czEntity=this.selectById(czId);
        return czEntity;
    }
}
