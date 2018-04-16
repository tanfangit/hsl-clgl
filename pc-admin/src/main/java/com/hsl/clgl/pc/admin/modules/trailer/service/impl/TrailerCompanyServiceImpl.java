package com.hsl.clgl.pc.admin.modules.trailer.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.modules.trailer.dao.TrailerCompanyDao;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerCompanyEntity;
import com.hsl.clgl.pc.admin.modules.trailer.service.TrailerCompanyService;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("trailerCompanyService")
public class TrailerCompanyServiceImpl extends ServiceImpl<TrailerCompanyDao, TrailerCompanyEntity> implements TrailerCompanyService {
    @Autowired
    private TrailerCompanyDao trailerCompanyDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TrailerCompanyEntity> page = new Query<TrailerCompanyEntity>(params).getPage();
        //将联表查询出的省市县名称set到实体province、city、area属性里
        page.setRecords(trailerCompanyDao.queryTrailerCompanyByName(page,params));
        return new PageUtils(page);
    }

    /**
     * 新增拖车公司
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TrailerCompanyEntity trailerCompanyEntity) {
        String supplierID = UUIDUtil.generateUUID();
        trailerCompanyEntity.setTrailerCompanyId(supplierID);
        trailerCompanyEntity.setCreateTime(new Date());
        trailerCompanyEntity.setCreateUser(ShiroUtils.getUserId());
        this.insert(trailerCompanyEntity);
    }

    /**
     * 修改 拖车公司
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TrailerCompanyEntity trailerCompanyEntity) {
        trailerCompanyEntity.setUpdateUser(ShiroUtils.getUserId());
        trailerCompanyEntity.setUpdateTime(new Date());
        this.insertOrUpdate(trailerCompanyEntity);
    }

    @Override
    public List<TrailerCompanyEntity> queryAllTrailerCompany() {
        List<TrailerCompanyEntity> allTrailerCompanyList =
                this.selectList(new EntityWrapper<TrailerCompanyEntity>());

        return allTrailerCompanyList;
    }
}
