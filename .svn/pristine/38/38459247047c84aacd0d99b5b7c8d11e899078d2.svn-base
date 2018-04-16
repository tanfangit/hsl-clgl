package com.hsl.clgl.pc.admin.modules.dictionary.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hsl.clgl.pc.admin.modules.dictionary.entity.SysDictValueEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据字典值表
 * 
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-04-03 09:17:13
 */
@Repository
public interface SysDictValueDao extends BaseMapper<SysDictValueEntity> {
    /**
     * 根据父级id删除所有子级
     */
    List<SysDictValueEntity> deleteValueListByParentId (String Id);


    /**
     * 通过字典类型查询  所属字典值List
     * @param typeId
     * @return
     */
    List<SysDictValueEntity>  selectValueListByType(String typeId);
	
}
