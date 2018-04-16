package com.hsl.clgl.pc.admin.modules.trailerlist.service.impl;

import com.hsl.clgl.common.utils.IdUtil;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerCompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.utils.Query;

import com.hsl.clgl.pc.admin.modules.trailerlist.dao.TrailerListDao;
import com.hsl.clgl.pc.admin.modules.trailerlist.entity.TrailerListEntity;
import com.hsl.clgl.pc.admin.modules.trailerlist.service.TrailerListService;
import org.springframework.transaction.annotation.Transactional;


@Service("trailerListService")
public class TrailerListServiceImpl extends ServiceImpl<TrailerListDao, TrailerListEntity> implements TrailerListService {
    @Autowired
    private TrailerListDao trailerListDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TrailerListEntity> page = new Query<TrailerListEntity>(params).getPage();
        //将联表查询的公司，司机名称，司机电话,set到实体对应的属性里
        page.setRecords(trailerListDao.queryTrailerListList(page,params));
        return new PageUtils(page);
    }

    /**
     * 新增拖车单
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TrailerListEntity trailerListEntity) {
        trailerListEntity.setTrailerCompanyId(IdUtil.getTrailerId());
        trailerListEntity.setCreateTime(new Date());
        trailerListEntity.setCreateUser(ShiroUtils.getUserId());
        this.insert(trailerListEntity);
    }
    /**
     * 修改拖车单
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TrailerListEntity trailerListEntity) {
        trailerListEntity.setTrailerListStatus(1);//已完成
        trailerListEntity.setUpdateTime(new Date());
        trailerListEntity.setUpdateUser(ShiroUtils.getUserId());
        this.insertOrUpdate(trailerListEntity);
    }

}
