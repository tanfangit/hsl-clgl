package com.hsl.clgl.app.cz.modules.gis.service.imp;

import com.hsl.clgl.app.cz.modules.gis.dao.GisDao;
import com.hsl.clgl.app.cz.modules.gis.service.GisService;
import com.hsl.clgl.app.utils.Constant;
import com.hsl.clgl.common.utils.ColumnConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
/**
 * gis服务类
 *
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-04-10 15:11:44
 */
@Service("GisService")
public class GisServiceImp implements GisService {
    @Autowired
    private GisDao gisDao;
    //匹配距离最近的修理厂，同一地市范围内
    public String gisMatchDis(Map<String, Object> params){
//        String lng = params.get("lng").toString();
//        String lat = params.get("lat").toString();
//        String cityId = params.get("cityId").toString();
        params.put(ColumnConstant.STATUS, Constant.STATUS_USED);
//        params.put("merchantType", Constant.MERCHANT_XLC);
        String result = gisDao.gisMatchDis(params);

        if(StringUtils.isBlank(result)){
            result = Constant.GIS_MQTS;
        }
        return result;
    }
}
