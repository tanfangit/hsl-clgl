package com.hsl.clgl.sh.pc.admin.modules.dictionary.service;


import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.sh.pc.admin.modules.dictionary.entity.SysDictValueEntity;

import java.util.List;
import java.util.Map;

/**
 * 数据字典值表
 *
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-04-03 09:17:13
 */
public interface SysDictValueService extends IService<SysDictValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     *  新增字典值
     * @param sysDictValueEntity
     */
    void save(SysDictValueEntity sysDictValueEntity);



    /**
     * 通过字典类型查询  所属字典值List
     * @param typeId
     * @return
     */
    List<SysDictValueEntity> selectValueListByType(String typeId);
}

