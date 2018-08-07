package org.pyx.common.libs.able;

/**
 * 具有主键性质的接口，类似<code>DB</code>表中的<code>id</code>
 * @author pyx
 * @date 2018/7/31
 */
public interface Keyable<T> {
    /**
     * 返回ID
     * @return ID
     */
    public T getId();
}
