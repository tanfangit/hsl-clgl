package com.hsl.clgl.sh.pc.admin.config;

import com.hsl.clgl.sh.pc.admin.modules.area.service.AreaService;
import com.hsl.clgl.sh.pc.admin.utils.AreaUtils;
import com.hsl.clgl.sh.pc.admin.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 工程启动加载类,order=1表示第一个加载
 */
@Component
@Order(value=1)
public class AreaCommandLineRunner implements CommandLineRunner {


    @Autowired
    private AreaService areaService;
    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载地区表数据操作<<<<<<<<<<<<<");
        AreaUtils.setSjList(this.areaService.queryAreaListByLevel(Constant.SJ_LEVEL));
        AreaUtils.setDjList(this.areaService.queryAreaListByLevel(Constant.DJ_LEVEL));
        AreaUtils.setXjList(this.areaService.queryAreaListByLevel(Constant.XJ_LEVEL));
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载地区表数据操作完毕<<<<<<<<<<<<<");
    }
}
