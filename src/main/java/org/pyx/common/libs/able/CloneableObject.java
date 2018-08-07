package org.pyx.common.libs.able;

/**
 * Since {@link Cloneable} is just a marker interface, it is not possible to clone different type of
 * objects at once. This interface helps for user objects, but, obviously, it can't change JDK
 * classes.
 * @author pyx
 * @date 2018/8/1
 */
public interface CloneableObject<T> extends Cloneable{

    /**
     * Performs instance cloning.
     *
     * @see Object#clone()
     */
    T clone() throws CloneNotSupportedException;
}
