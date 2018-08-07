package org.pyx.common.libs.able;

/**
 * 代表一个引导程序，可激活关闭
 * @author pyx
 * @date 2018/7/31
 */
public interface Bootstrap extends Startable,Stopable{
    /**
     * 是否激活
     * @return 如果是则返回<code>true</code>
     */
    boolean isActive();
}
