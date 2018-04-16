package com.hsl.clgl.sh.pc.admin.utils;


import com.hsl.clgl.sh.pc.admin.modules.area.entity.AreaEntity;

import java.util.ArrayList;
import java.util.List;

public class AreaUtils {

    public static  List<AreaEntity> sjList;

    public static List<AreaEntity>  djList;

    public static List<AreaEntity>  xjList;



    public static void setSjList(List<AreaEntity> sjList) {
        AreaUtils.sjList = sjList;
    }

    public static void setDjList(List<AreaEntity> djList) {
        AreaUtils.djList = djList;
    }

    public static void setXjList(List<AreaEntity> xjList) {
        AreaUtils.xjList = xjList;
    }



    /**
     * 通过id查询省级
     * @param id
     * @return
     */
    public static AreaEntity getSjById(Integer id){
        for (AreaEntity area : sjList){
             if (id.intValue()==area.getId().intValue()){
                 return area;
             }
        }
        return new AreaEntity();
    }

    /**
     * 通过id查询地级
     * @param id
     * @return
     */
    public static AreaEntity getDjById(Integer id){
        for (AreaEntity area : djList){
            if (id.intValue()==area.getId().intValue()){
                return area;
            }
        }
        return new AreaEntity();
    }

    /**
     * 通过id查询区县
     * @param id
     * @return
     */
    public static AreaEntity getXjById(Integer id){
        for (AreaEntity area : xjList){
            if (id.intValue()==area.getId().intValue()){
                return area;
            }
        }
        return new AreaEntity();
    }

    /**
     * 通过省级id查询省级下面的地级
     * @param parentId
     * @return
     */
    public static List<AreaEntity> getDjByParentId(Integer parentId){
        List<AreaEntity> list = new ArrayList<>();
        for (AreaEntity area : djList){
            if (parentId.intValue()==area.getParentId().intValue()){
                list.add(area);
            }
        }
        return list;
    }


    /**
     * 通过地级id查询地级下面的区县
     * @param parentId
     * @return
     */
    public static List<AreaEntity> getXjByParentId(Integer parentId){
        List<AreaEntity> list = new ArrayList<>();
        for (AreaEntity area : xjList){
            if (parentId.intValue()==area.getParentId().intValue()){
                list.add(area);
            }
        }
        return list;
    }

}
