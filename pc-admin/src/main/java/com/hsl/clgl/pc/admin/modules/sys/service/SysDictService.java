package com.hsl.clgl.pc.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysDictEntity;

import java.util.List;
import java.util.Map;

/**
 * 数据字典表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-29 13:39:56
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 通过接口： 通过字典类型type   查询字典list
     */
    List<SysDictEntity>  selectDictListByType(String type);
}

