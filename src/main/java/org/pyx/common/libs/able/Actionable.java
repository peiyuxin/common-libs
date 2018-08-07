package org.pyx.common.libs.able;

/**
 * 操作接口
 * @author pyx
 * @date 2018/7/31
 */
public interface Actionable<T,V> {

    /**
     * 具体操作
     * @param condition 操作条件
     * @return
     */
    V action(T condition);
}
