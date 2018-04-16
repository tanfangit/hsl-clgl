package com.hsl.clgl.sh.pc.admin.modules.dictionary.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.sh.pc.admin.modules.dictionary.entity.SysDictTypeEntity;

import java.util.Map;

/**
 * 数据字典类型表
 *
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-04-02 15:10:26
 */
public interface SysDictTypeService extends IService<SysDictTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     *  新增字典
     * @param sysDictTypeEntity
     */
    void save(SysDictTypeEntity sysDictTypeEntity);

    /**
     * 修改字典
     */
    void update(SysDictTypeEntity sysDictTypeEntity);

    /**
     * 删除字典及其值
     */
    void delete(String Id);
}

