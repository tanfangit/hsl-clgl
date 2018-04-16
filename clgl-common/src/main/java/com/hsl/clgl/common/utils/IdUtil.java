package com.hsl.clgl.common.utils;

import java.util.Date;

/**
 * ClassName: IdUtil <br/>
 * Function: 生成主键ID <br/>
 * date: 2018年3月22日
 *
 * @author zhangqiao
 * @version
 */
public final class IdUtil {
    /**
     * 生成救援单id  JY开头时间戳加6位随机数JY20180409091000123456
     * @return
     */
    public static String getRescueId() {
       String id= "JY"+DateUtils.format(new Date(),"yyyyMMdd")+System.currentTimeMillis()+(int)((Math.random()*9+1)*100000);
       return id;
    }


    public static void main(String[] args) {
        System.out.println(getRescueId());
    }

    /**
     * 生成拖车单id  TC开头时间戳加6位随机数TC20180409091000123456
     */
    public static String getTrailerId() {
        String id= "TC"+DateUtils.format(new Date(),"yyyyMMddHHmmss")+((int)((Math.random()*9+1)*100000));
        return id;
    }
}
