package org.pyx.common.libs.able;

/**
 * 异常监听器
 * @author pyx
 * @date 2018/8/1
 */
public interface ExceptionListener {

    /**
     * 异常处理
     * @param e 异常
     */
    void onException(Throwable e);
}
