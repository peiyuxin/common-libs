package org.pyx.common.libs.able;

/**
 * 定义<code>Entry</code>，一般代表键值对
 * @param <K> key
 * @param <V> value
 * @author pyx
 * @date 2018/8/1
 */
public interface Entryable<K,V> {
    /**
     * return the key of entry
     *
     * @return key
     */
    K getKey();

    /**
     * return the value of entry
     *
     * @return value
     */
    V getValue();
}
