package org.pyx.common.libs.able;

/**
 * 消息发送接口
 * @author pyx
 * @date 2018/8/1
 */
public interface Sender<T> {

    /**
     * 发送消息
     * @param message 消息
     */
    void sendMessage(T message);
}
