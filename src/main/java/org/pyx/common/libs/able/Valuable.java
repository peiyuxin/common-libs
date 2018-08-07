package org.pyx.common.libs.able;

/**
 * 定义返回值接口
 * @author pyx
 * @date 2018/7/31
 */
public interface Valuable<T> {

    /**
     * 取值
     *
     * @return the value
     */
    T value();
}