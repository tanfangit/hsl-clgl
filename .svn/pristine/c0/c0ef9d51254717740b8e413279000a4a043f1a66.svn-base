package com.hsl.clgl.sh.pc.admin.modules.dictionary.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.sh.pc.admin.modules.dictionary.dao.SysDictTypeDao;
import com.hsl.clgl.sh.pc.admin.modules.dictionary.dao.SysDictValueDao;
import com.hsl.clgl.sh.pc.admin.modules.dictionary.entity.SysDictTypeEntity;
import com.hsl.clgl.sh.pc.admin.modules.dictionary.service.SysDictTypeService;
import com.hsl.clgl.sh.pc.admin.utils.Constant;
import com.hsl.clgl.sh.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service("sysDictTypeService")
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeDao, SysDictTypeEntity> implements SysDictTypeService {
    @Autowired
    private SysDictValueDao sysDictValueDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        EntityWrapper<SysDictTypeEntity> wrapper = new EntityWrapper<SysDictTypeEntity>();
        if(params.get("name")!=null){
            String name = params.get("name").toString();
            wrapper.like(ColumnConstant.NAME,name);
        }
        Page<SysDictTypeEntity> page = this.selectPage(
                new Query<SysDictTypeEntity>(params).getPage(),wrapper.eq(ColumnConstant.DEL_FLAG, Constant.STATUS_USED)
        );

        return new PageUtils(page);
    }

    /**
     * 新增字典
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysDictTypeEntity sysDictTypeEntity) {
        String id = UUIDUtil.generateUUID();
        sysDictTypeEntity.setId(id);
        sysDictTypeEntity.setDelFlag(Constant.STATUS_USED);
        this.insert(sysDictTypeEntity);
    }


    /**
     * 修改 字典
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDictTypeEntity sysDictTypeEntity) {
        sysDictTypeEntity.setDelFlag(Constant.STATUS_USED);
        this.insertOrUpdate(sysDictTypeEntity);
    }

    /**
     * 删除字典及其值
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String Id) {
        this.deleteById(Id);
        sysDictValueDao.deleteValueListByParentId(Id);

    }

}
