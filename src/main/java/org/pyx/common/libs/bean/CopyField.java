package org.pyx.common.libs.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 源对象拷贝字段
 * @author pyx
 * @date 2018/8/8
 */
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CopyField {

    /**
     * 支持的类型数组
     * @return 支持的类型数组
     */
    Class<?>[] supportFor() default Object.class;
}
