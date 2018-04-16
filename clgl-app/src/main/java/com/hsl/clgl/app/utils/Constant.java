
package com.hsl.clgl.app.utils;

/**
 * 常量
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.com
 */
public class Constant {
	/** 超级管理员ID */
	public static  String SUPER_ADMIN = "1";
    /** 数据权限过滤 */
	public static final String SQL_FILTER = "sql_filter";
    /** 正常状态 */
    public static final Integer STATUS_USED = 1;
    /** 废弃状态 */
    public static final Integer STATUS_DISABLE = 0;
    /** 已删除状态 */
    public static final Integer STATUS_DELETED = 2;
    /** 层级标识： 1  省份 */
    public static final Integer SJ_LEVEL=1;
    /** 层级标识： 2  市 */
    public static final Integer DJ_LEVEL=2;
    /** 层级标识： 3  区县 */
    public static final Integer XJ_LEVEL=3;
    /** 商户类别： 2  修理厂 */
    public static final String MERCHANT_XLC = "2";
    /** 商户类别： 1  快速处理中心 */
    public static final String MERCHANT_KSCLZX = "1";
    /** gis匹配： 盲区提示 */
    public static final String GIS_MQTS = "对不起，当前地市属于业务盲区，无匹配商户！";
    /** 维修类别常量*/
    public static final String WXLB="WXLB";
	/**
	 * 菜单类型
	 */
    public enum MenuType {
        /**
         * 目录
         */
    	CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    

}
