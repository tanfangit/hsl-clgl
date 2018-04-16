package com.hsl.clgl.pc.admin.modules.maintenance.repair.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.maintenance.repair.entity.RepairItemEntity;

import java.util.Map;

/**
 * 维修项目表
 *
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-29 10:02:08
 */
public interface RepairItemService extends IService<RepairItemEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 新增维修项目
     * @param repairItem
     */
    void save( RepairItemEntity repairItem);

    /**
     * 通过维修项目id查询 维修项目信息
     */

    RepairItemEntity selectInfoById(String repairItemId);


    /**
     * 更新维修项目
     * @param repairItem
     */
    void updateRepairItem( RepairItemEntity repairItem);


}

