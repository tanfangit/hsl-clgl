package com.hsl.clgl.pc.admin.modules.maintenance.repair.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.dictionary.entity.SysDictValueEntity;
import com.hsl.clgl.pc.admin.modules.dictionary.service.SysDictValueService;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.dao.RepairItemDao;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.entity.RepairItemEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.entity.RepairTypeEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.entity.RepairTypeItemEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.service.RepairItemService;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.service.RepairTypeItemService;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.service.RepairTypeService;
import com.hsl.clgl.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;


@Service("repairItemService")
public class RepairItemServiceImpl extends ServiceImpl<RepairItemDao, RepairItemEntity> implements RepairItemService {
     @Autowired
    RepairItemDao   repairItemDao;
    @Autowired
    RepairTypeItemService repairTypeItemService;
    @Autowired
    RepairTypeService RepairTypeService;
    @Autowired
    SysDictValueService sysDictValueService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        params.put("status", Constant.STATUS_USED);
        Page<RepairItemEntity> page = new Query<RepairItemEntity>(params).getPage();
        page.setRecords(repairItemDao.queryRepairItemList(page, params));
        return new PageUtils(page);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(RepairItemEntity repairItem) {
        //插入一条维修项目记录
        repairItem.setCreateUser(ShiroUtils.getUserId());
        repairItem.setRepairItemId(UUIDUtil.generateUUID());
        //维修项目编号
        String repairNo=Constant.WXXM+"-"+UUIDUtil.generate16UUID();
        repairItem.setRepairItemNo(repairNo);
         this.insert(repairItem);
       //保存维修项目与维修类别关系
        repairTypeItemService.saveOrupdate(repairItem);

    }

    @Override
    public RepairItemEntity selectInfoById(String repairItemId) {
        RepairItemEntity repairItemEntity =this.selectById(repairItemId);
        //查询维修类别名称
        RepairTypeItemEntity  repairTypeItemEntity=
                repairTypeItemService.selectOne( new EntityWrapper<RepairTypeItemEntity>().eq(ColumnConstant.REPAIR_ITEM_ID,repairItemId));
        RepairTypeEntity repairTypeEntity=RepairTypeService.selectById(repairTypeItemEntity.getRepairTypeId());
        repairItemEntity.setRepairTypeName(repairTypeEntity.getRepairTypeName());
        //维修类型id
        repairItemEntity.setRepairTypeId(repairTypeEntity.getRepairTypeId());
       //查询维修部件名称
        SysDictValueEntity  sysDictValueEntity =sysDictValueService.selectById(repairItemEntity.getRepairItemPosition());
         repairItemEntity.setRepairItemPositionName(sysDictValueEntity.getName());
        repairItemEntity.setRepairItemPosition(sysDictValueEntity.getId());

        return repairItemEntity;
    }


    @Override
    public void updateRepairItem(RepairItemEntity repairItem) {
        //更新维修项目
        repairItem.setUpdateUser(ShiroUtils.getUserId());
        repairItem.setUpdateTime(new Date());
        this.updateById(repairItem);
       //保存维修项目与维修类别关系
        repairTypeItemService.saveOrupdate(repairItem);

    }

}
