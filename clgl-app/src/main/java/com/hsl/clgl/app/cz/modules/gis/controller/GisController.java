package com.hsl.clgl.app.cz.modules.gis.controller;

import com.hsl.clgl.app.cz.modules.gis.service.GisService;
import com.hsl.clgl.app.utils.Constant;
import com.hsl.clgl.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * gis接口
 *
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-04-10 16:11:44
 */
@RestController
@RequestMapping("gis")
public class GisController {
    @Autowired
    private GisService gisService;
    @RequestMapping("/gisMatchDis")
    public R gisMatchDis(@RequestParam Map<String, Object> params){
        String merchantId = gisService.gisMatchDis(params);
        if( Constant.GIS_MQTS.equals(merchantId)){
            return R.error(Constant.GIS_MQTS);
        }
        return R.ok().put("merchantId", merchantId);
    }
}
