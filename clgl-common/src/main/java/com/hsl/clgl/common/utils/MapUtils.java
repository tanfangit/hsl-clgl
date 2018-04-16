
package com.hsl.clgl.common.utils;

import java.util.HashMap;


/**
 * Map工具类
 * @author zhoucheng
 * @email zhoucheng@hsl56.com
 */
public class MapUtils extends HashMap<String, Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
