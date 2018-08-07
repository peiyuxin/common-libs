package org.pyx.common.libs.able;

/**
 * 回调接口
 * @author pyx
 * @date 2018/8/1
 */
public interface ResponseCallback<T> extends ExceptionListener {

    /**
     * 处理成功的回调
     * @param result 回调对象
     */
    void onSuccess(T result);
}
