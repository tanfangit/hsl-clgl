package com.hsl.clgl.pc.admin.modules.trailer.service.impl;

import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.trailer.dao.TrailerDao;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerEntity;
import com.hsl.clgl.pc.admin.modules.trailer.service.TrailerService;
import org.springframework.transaction.annotation.Transactional;


@Service("trailerService")
public class TrailerServiceImpl extends ServiceImpl<TrailerDao, TrailerEntity> implements TrailerService {
    @Autowired
    private TrailerDao trailerDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TrailerEntity> page = new Query<TrailerEntity>(params).getPage();
        //将联表查询的公司名称set到实体的companyName属性里
        page.setRecords(trailerDao.queryTrailerList(page,params));
        return new PageUtils(page);
    }

    /**
     * 新增拖车
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TrailerEntity trailerEntity) {
        String supplierID = UUIDUtil.generateUUID();
        trailerEntity.setTrailerId(supplierID);
        trailerEntity.setCreateTime(new Date());
        trailerEntity.setCreateUser(ShiroUtils.getUserId());
        this.insert(trailerEntity);
    }
    /**
     * 新增拖车
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TrailerEntity trailerEntity) {
        trailerEntity.setUpdateTime(new Date());
        trailerEntity.setUpdateUser(ShiroUtils.getUserId());
        this.insertOrUpdate(trailerEntity);
    }
}
