package com.hsl.clgl.pc.admin.modules.supplier.service.impl;

import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.utils.Query;

import com.hsl.clgl.pc.admin.modules.supplier.dao.SupplierDao;
import com.hsl.clgl.pc.admin.modules.supplier.entity.SupplierEntity;
import com.hsl.clgl.pc.admin.modules.supplier.service.SupplierService;
import org.springframework.transaction.annotation.Transactional;


@Service("supplierService")
public class SupplierServiceImpl extends ServiceImpl<SupplierDao, SupplierEntity> implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    /**
     * 查询所有供应商
     *
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SupplierEntity> page = new Query<SupplierEntity>(params).getPage();
        page.setRecords(supplierDao.querySupplierList(page,params));

        return new PageUtils(page);
    }

    /**
     * 新增供应商
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SupplierEntity supplierEntity) {
        String supplierID = UUIDUtil.generateUUID();
        supplierEntity.setSupplierId(supplierID);
        supplierEntity.setCreateTime(new Date());
        supplierEntity.setCreateUser(ShiroUtils.getUserId());
        this.insert(supplierEntity);
    }


    /**
     * 修改 供应商
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SupplierEntity supplierEntity) {
        supplierEntity.setUpdateUser(ShiroUtils.getUserId());
        supplierEntity.setUpdateTime(new Date());
        this.insertOrUpdate(supplierEntity);
    }
}
