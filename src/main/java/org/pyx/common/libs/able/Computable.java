package org.pyx.common.libs.able;

import java.util.concurrent.Callable;

/**
 * 计算接口
 * @author pyx
 * @date 2018/7/31
 */
public interface Computable<K,V> {
    /**
     * 通过关键字来计算
     *
     * @param key 查找关键字
     * @param callable # @see Callable
     * @return 计算结果
     */
    V get(K key, Callable<V> callable);

    /**
     * 通过关键字移除内容
     *
     * @param key 查找关键字
     */
    void remove(K key);

    /**
     * 清空
     */
    void clear();
}
