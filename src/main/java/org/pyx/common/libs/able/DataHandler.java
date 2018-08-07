package org.pyx.common.libs.able;

/**
 *
 * @author pyx
 * @date 2018/8/1
 * @param <F>
 * @param <T>
 */
public interface DataHandler<F,T> {
    
    /**
     * 信息处理
     *
     * @param from 原始信息
     * @param to 转换后信息
     */
    void handle(F from, T to);
}
