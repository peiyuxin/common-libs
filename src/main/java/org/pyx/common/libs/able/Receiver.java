package org.pyx.common.libs.able;

/**
 * 消息接收
 * @author pyx
 * @date 2018/8/1
 */
public interface Receiver<T> {

    /**
     * 接受消息
     *
     * @param message 接收信息附带对象
     */
    void messageReceived(T message);
}
