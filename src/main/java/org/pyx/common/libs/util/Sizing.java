package org.pyx.common.libs.util;

/**
 * 字节单位大小计算
 * @author pyx
 * @date 2018/8/14
 */
public abstract class Sizing {
    private static final int KILOBYTE_UNIT = 1024;

    public static int getGB(double giga){
        return (int)(giga * KILOBYTE_UNIT * KILOBYTE_UNIT * KILOBYTE_UNIT);
    }

    public static int getMB(double mega){
        return (int)(mega * KILOBYTE_UNIT * KILOBYTE_UNIT);
    }

    public static int getKB(double kilo){
        return (int)(kilo * KILOBYTE_UNIT);
    }

    public static int unlimited(){
        return -1;
    }

    public static String inGB(long bytes) {
        //以“,”对数字分组 使用括号包含负数 .1保存1位小数
        return String.format("%(,.1fGB", (double) bytes / KILOBYTE_UNIT / KILOBYTE_UNIT / KILOBYTE_UNIT);
    }

    public static String inMB(long bytes) {
        return String.format("%(,.1fMB", (double) bytes / KILOBYTE_UNIT / KILOBYTE_UNIT);
    }

    public static String inKB(long bytes) {
        return String.format("%(,.1fKB", (double) bytes / KILOBYTE_UNIT);
    }
}
