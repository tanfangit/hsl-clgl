package com.hsl.clgl.pc.admin.modules.supplier.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.hsl.clgl.pc.admin.modules.supplier.entity.SupplierEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 供应商维护
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-23 11:50:59
 */
@Repository
public interface SupplierDao extends BaseMapper<SupplierEntity> {
    List<SupplierEntity> querySupplierList (Page<SupplierEntity> page, Map<String, Object> params);
}
