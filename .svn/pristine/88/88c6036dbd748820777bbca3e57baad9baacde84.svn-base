package com.hsl.clgl.pc.admin.modules.maintenance.car.service.impl;

import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.MapUtils;
import com.hsl.clgl.pc.admin.utils.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.utils.Query;
import com.hsl.clgl.pc.admin.modules.maintenance.car.dao.CarTrainDao;
import com.hsl.clgl.pc.admin.modules.maintenance.car.entity.CarTrainEntity;
import com.hsl.clgl.pc.admin.modules.maintenance.car.service.CarTrainService;


@Service("carTrainService")
public class CarTrainServiceImpl extends ServiceImpl<CarTrainDao, CarTrainEntity> implements CarTrainService {
    @Autowired
    private CarTrainDao carTrainDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //多表关联查询
//        StringBuilder builder = new StringBuilder();
//        builder.append(" id AS id,");
//        builder.append(" train_name AS trainName,");
//        builder.append(" train_no AS trainNo,");
//        builder.append(" brand_id AS brandId,");
//        builder.append(" (select b.brand_name from tb_car_brand b where tb_car_train.brand_id = b.brand_id and b.`status` = 1 LIMIT 1) AS brandName,");
//        builder.append(" remark,");
//        builder.append(" `status`,");
//        builder.append(" create_time AS createTime,");
//        builder.append(" create_user AS `createUser`,");
//        builder.append(" update_time AS updateTime,");
//        builder.append(" update_user AS updateUser");
//        String trainName = "";
//        if(params.get("trainName") != null){
//            trainName = (String)params.get("trainName");
//        }
//        String brandId = "";
//        if(params.get("brandId") != null){
//            brandId = (String)params.get("brandId");
//        }
//        Page<CarTrainEntity> page = this.selectPage(
//                new Query<CarTrainEntity>(params).getPage(),
//                new EntityWrapper<CarTrainEntity>().setSqlSelect(builder.toString()).like(StringUtils.isNotBlank(trainName), ColumnConstant.TRAIN_NAME, trainName).eq(StringUtils.isNotBlank(brandId),ColumnConstant.BRAND_ID, brandId).eq(ColumnConstant.STATUS, Constant.STATUS_USED)
//        );
//        MapUtils map = new MapUtils();
        params.put(ColumnConstant.STATUS, Constant.STATUS_USED);
        Page<CarTrainEntity> page = new Query<CarTrainEntity>(params).getPage();
        page.setRecords(carTrainDao.queryTrainList(page,params));
        return new PageUtils(page);
    }
    @Override
    public List<CarTrainEntity> queryTrain(Map<String, Object> params) {
        params.put(ColumnConstant.STATUS, Constant.STATUS_USED);
        List<CarTrainEntity> list = carTrainDao.queryTrain(params);
        return list;
    }

}
