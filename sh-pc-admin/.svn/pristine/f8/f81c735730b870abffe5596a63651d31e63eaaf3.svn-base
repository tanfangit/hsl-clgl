package com.hsl.clgl.sh.pc.admin.modules.dictionary.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.sh.pc.admin.modules.dictionary.dao.SysDictValueDao;
import com.hsl.clgl.sh.pc.admin.modules.dictionary.entity.SysDictValueEntity;
import com.hsl.clgl.sh.pc.admin.modules.dictionary.service.SysDictValueService;
import com.hsl.clgl.sh.pc.admin.utils.Constant;
import com.hsl.clgl.sh.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("sysDictValueService")
public class SysDictValueServiceImpl extends ServiceImpl<SysDictValueDao, SysDictValueEntity> implements SysDictValueService {
   @Autowired
    SysDictValueDao  sysDictValueDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        EntityWrapper<SysDictValueEntity> wrapper = new EntityWrapper<SysDictValueEntity>();
        if(params.get("parentId")!=null){
            String parentId = params.get("parentId").toString();
            wrapper.eq(ColumnConstant.PARENTID,parentId);
        }
        Page<SysDictValueEntity> page = this.selectPage(
                new Query<SysDictValueEntity>(params).getPage(),wrapper
        );

        return new PageUtils(page);
    }

    /**
     * 新增字典值
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysDictValueEntity sysDictValueEntity) {
        String id = UUIDUtil.generateUUID();
        sysDictValueEntity.setId(id);
        sysDictValueEntity.setDelFlag(Constant.STATUS_USED);
        this.insert(sysDictValueEntity);
    }


    @Override
    public List<SysDictValueEntity> selectValueListByType(String typeId) {
        List<SysDictValueEntity>  list= sysDictValueDao.selectValueListByType(typeId);
        return list;
    }
}
