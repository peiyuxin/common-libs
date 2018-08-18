package org.pyx.common.libs.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 有关<code>Object</code>处理的工具类。
 * <p>
 * 这个类中的每个方法都可以“安全”地处理<code>null</code>，而不会抛出<code>NullPointerException</code>。
 * </p>
 * 抽象类意义
 * @author pyx
 * @date 2018/8/8
 */
public abstract class ObjectUtil {
    /**
     * 判断对象是否均为<code>null</code>
     *
     * @param objects 传入对象集
     * @return 均为<code>null</code>则返还<code>true</code>
     */
    public static boolean isAllNull(Object... objects) {
        if (objects == null) {
            return true;
        }

        for (Object object : objects) {
            if (object != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否有任一对象为<code>null</code>
     *
     * @param objects 传入对象集
     * @return 任一对象为<code>null</code>则返还<code>true</code>
     */
    public static boolean isAnyNull(Object... objects) {
        if (objects == null) {
            return true;
        }

        for (Object object : objects) {
            if (object == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断对象是否是空
     *
     * @param object 传入对象
     *
     * @return 如果<code>object.toString()</code>为<code>""</code>、 <code>null</code> 或者空数组,
     *         则返回<code>true</code>
     */
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }

        if (object instanceof String) {
            return StringUtils.isEmpty(object.toString());
        }
        //coll map array
        if (object instanceof Map) {
            return ((Map)object).isEmpty();
        }
        if (object instanceof Collection) {
            return ((Collection<?>)object).isEmpty();
        }
        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }
        return false;
    }
}
