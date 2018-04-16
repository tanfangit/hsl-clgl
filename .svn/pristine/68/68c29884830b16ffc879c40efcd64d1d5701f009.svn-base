package com.hsl.clgl.pc.admin.modules.maintenance.repair.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.dao.RepairTypeDao;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.entity.RepairTypeEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.service.RepairTypeService;
import com.hsl.clgl.pc.admin.utils.Constant;
import com.hsl.clgl.pc.admin.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("repairTypeService")
public class RepairTypeServiceImpl extends ServiceImpl<RepairTypeDao, RepairTypeEntity> implements RepairTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String  repairTypeName=(String)params.get("repairTypeName");
        Page<RepairTypeEntity> page = this.selectPage(
                new Query<RepairTypeEntity>(params).getPage(),
                new EntityWrapper<RepairTypeEntity>()
                        .like(StringUtils.isNotBlank(repairTypeName),ColumnConstant.REPAIR_TYPE_NAME, repairTypeName)
                        .eq(ColumnConstant.STATUS, Constant.STATUS_USED)
        );

        return new PageUtils(page);
    }


    @Override
    public List<RepairTypeEntity> getAllRepairType() {
        List<RepairTypeEntity> repairTypeList =
                this.selectList(new EntityWrapper<RepairTypeEntity>()
                        .eq(ColumnConstant.STATUS, Constant.STATUS_USED));
        return repairTypeList;
    }
}
