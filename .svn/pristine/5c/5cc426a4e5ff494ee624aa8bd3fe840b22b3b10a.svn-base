package com.hsl.clgl.pc.admin.modules.maintenance.repair.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.MapUtils;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.common.utils.UUIDUtil;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.dao.RepairTypeItemDao;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.entity.RepairItemEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.entity.RepairTypeItemEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.service.RepairTypeItemService;
import com.hsl.clgl.pc.admin.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;



@Service("repairTypeItemService")
public class RepairTypeItemServiceImpl extends ServiceImpl<RepairTypeItemDao, RepairTypeItemEntity> implements RepairTypeItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RepairTypeItemEntity> page = this.selectPage(
                new Query<RepairTypeItemEntity>(params).getPage(),
                new EntityWrapper<RepairTypeItemEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveOrupdate(RepairItemEntity repairItem) {
       //先删除维修项目与维修类别关系
        this.deleteByMap(new MapUtils().put((ColumnConstant.REPAIR_ITEM_ID),repairItem.getRepairItemId()));
       //在新增维修项目与维修类别关系
        RepairTypeItemEntity repairTypeItemEntity = new RepairTypeItemEntity();
        repairTypeItemEntity.setId(UUIDUtil.generateUUID());
       repairTypeItemEntity.setRepairItemId(repairItem.getRepairItemId());
       repairTypeItemEntity.setRepairTypeId(repairItem.getRepairTypeId());
       this.insert(repairTypeItemEntity);


    }
}
