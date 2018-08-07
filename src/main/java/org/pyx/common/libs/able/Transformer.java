package org.pyx.common.libs.able;

/**
 * 将一个对象转换成另一个对象的接口.
 * @author pyx
 * @date 2018/8/1
 */
public interface Transformer<FROM,TO> {
    /**
     * 对象转换，从<code>FROM</code>类型转变成<code>TO</code>类型
     * @param from 待转换对象
     * @return 转换后的类型<tt>TO</tt>
     */
    TO transform(FROM from);
}
