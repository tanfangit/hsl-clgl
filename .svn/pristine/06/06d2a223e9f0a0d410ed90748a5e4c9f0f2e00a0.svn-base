package com.hsl.clgl.pc.admin.modules.trailer.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.trailer.entity.TrailerCompanyEntity;

import java.util.List;
import java.util.Map;

/**
 * 拖车公司表
 *
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-28 14:41:00
 */
public interface TrailerCompanyService extends IService<TrailerCompanyEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     *  新增拖车公司
     * @param trailerCompanyEntity
     */
    void save(TrailerCompanyEntity trailerCompanyEntity);

    /**
     * 修改拖车公司
     */
    void update(TrailerCompanyEntity trailerCompanyEntity);

    /**
     * 查询所有过车公司
     * @return
     */
     List<TrailerCompanyEntity> queryAllTrailerCompany();
}

