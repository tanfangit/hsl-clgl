package com.hsl.clgl.pc.admin.modules.supplier.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.R;
import com.hsl.clgl.pc.admin.modules.supplier.entity.SupplierEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 供应商维护
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-23 11:50:59
 */
public interface SupplierService extends IService<SupplierEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     *  新增供应商
     * @param supplierEntity
     */
    void save(SupplierEntity supplierEntity);

    /**
     * 修改供应商
     */
     void update(SupplierEntity supplierEntity);

}

