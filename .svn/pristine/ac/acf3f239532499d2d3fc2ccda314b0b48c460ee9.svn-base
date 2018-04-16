package com.hsl.clgl.app.cz.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.app.cz.modules.sys.dao.CzDao;
import com.hsl.clgl.app.cz.modules.sys.entity.CzEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CzService;
import com.hsl.clgl.app.utils.Query;
import com.hsl.clgl.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("czService")
public class CzServiceImpl extends ServiceImpl<CzDao, CzEntity> implements CzService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CzEntity> page = this.selectPage(
                new Query<CzEntity>(params).getPage(),
                new EntityWrapper<CzEntity>()
        );

        return new PageUtils(page);
    }

}
