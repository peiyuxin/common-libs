package org.pyx.common.libs.util;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * Jmx相关工具类
 * @author pyx
 * @date 2018/7/31
 */
public class JmxUtil {
    /**
     * 获取当前进程号
     *
     * @return 当前进程号
     */
    public static int getPid() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        int index = name.indexOf("@");
        if(-1 != index){
            return Integer.parseInt(name.substring(0, index));
        }
        return -1;
    }
}
