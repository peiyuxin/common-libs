package org.pyx.common.libs.able;

/**
 * 仿闭包，接口中的 {@link #execute(Object...)} 通过回调模拟闭包。
 * @author pyx
 * @date 2018/7/31
 */
public interface Closure {

    /**
     * Performs an action on the specified input object.
     *
     * @param input the input to execute on
     */
    public void execute(Object... input);
}
