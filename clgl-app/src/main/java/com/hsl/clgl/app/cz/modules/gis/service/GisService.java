package com.hsl.clgl.app.cz.modules.gis.service;

import java.util.Map;

/**
 * gis服务类
 *
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-04-10 15:11:44
 */
public interface GisService {
    //匹配距离最近的修理厂，同一地市范围内
    String gisMatchDis(Map<String, Object> params);
}
