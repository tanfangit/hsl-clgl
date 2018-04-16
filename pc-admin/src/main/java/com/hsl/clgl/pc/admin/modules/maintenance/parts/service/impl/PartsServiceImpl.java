package com.hsl.clgl.pc.admin.modules.maintenance.parts.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.maintenance.parts.dao.PartsDao;
import com.hsl.clgl.pc.admin.modules.maintenance.parts.entity.PartsEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.parts.service.PartsService;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;


@Service("partsService")
public class PartsServiceImpl extends ServiceImpl<PartsDao, PartsEntity> implements PartsService {
    @Autowired
    private PartsDao partsDao;

    /**
     * 查询所有配件
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PartsEntity> page = new Query<PartsEntity>(params).getPage();
        //将联表查询出的品牌，车系名称set到实体相应属性里
        page.setRecords(partsDao.queryPartsList(page,params));
        return new PageUtils(page);
    }

    /**
     *  新增配件
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PartsEntity partsEntity) {
        String partsID = UUIDUtil.generateUUID();
        partsEntity.setPartsId(partsID);
        partsEntity.setStatus(Constant.STATUS_USED);//正常状态
        partsEntity.setCreateTime(new Date());
        partsEntity.setCreateUser(ShiroUtils.getUserId());
        this.insert(partsEntity);
    }

    /**
     * 修改配件
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PartsEntity partsEntity) {
        partsEntity.setUpdateUser(ShiroUtils.getUserId());
        partsEntity.setUpdateTime(new Date());
        partsEntity.setStatus(Constant.STATUS_USED);//正常状态
        this.insertOrUpdate(partsEntity);
    }

}
