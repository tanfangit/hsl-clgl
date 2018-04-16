package com.hsl.clgl.common.utils;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * ClassName: UUIDUtil <br/>
 * Function: 生成主键ID <br/>
 * date: 2018年3月22日
 *
 * @author zhangqiao
 * @version
 */
public final class UUIDUtil {
    /**
     * generate uuid for log.
     * 
     * @return A string
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * numberGenerator:SecureRandom.
     * 
     * @since JDK 1.6
     */
    private static SecureRandom numberGenerator = new SecureRandom();

    /**
     * generate16UUID:生成长度16的UUID <br/>
     * 
     * @author st-gdq4556
     * @return 16长度UUID
     * @since JDK 1.6
     */
    public static String generate16UUID() {
        byte[] randomBytes = new byte[8];
        numberGenerator.nextBytes(randomBytes);
        long msb = 0;
        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | (randomBytes[i] & 0xff);
        }
        return digits(msb >> 32, 8) +
                digits(msb >> 16, 4) + digits(msb, 4);
    }

    /**
     * digits:返回16进制所代表的值 <br/>
     * 
     * @author st-gdq4556
     * @param val
     * @param digits
     * @return
     * @since JDK 1.6
     */
    private static String digits(long val, int digits) {
        long hi = 1L << (digits * 4);
        return Long.toHexString(hi | (val & (hi - 1))).substring(1);
    }
    
    
     public static void main(String[] args) {
         for (int i = 0; i < 20; i++) {
             System.out.println(generateUUID());
            
        }
    }
}
