package com.hsl.clgl.pc.admin.modules.sys.service.impl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.sys.dao.SysDictDao;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysDictEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysDictService;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictEntity> implements SysDictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysDictEntity> page = this.selectPage(
                new Query<SysDictEntity>(params).getPage(),
                new EntityWrapper<SysDictEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SysDictEntity> selectDictListByType(String type) {
        HashMap<String,Object>  map=new HashMap();
        map.put("type",type);
        List<SysDictEntity> list=baseMapper.selectByMap(map);
        return list;
    }
}
