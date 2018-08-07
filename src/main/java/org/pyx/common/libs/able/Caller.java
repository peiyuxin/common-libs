package org.pyx.common.libs.able;

import java.util.concurrent.Callable;

/**
 * 无抛出异常的“Callable”
 *
 * @author pyx
 * @date 2018/8/1
 */
public interface Caller<V> extends Callable{
    /**
     * 计算结果
     * @return 计算结果
     * @throws Exception
     */
    @Override
    V call() throws Exception;
}
