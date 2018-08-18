package org.pyx.common.libs.core;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * support for {@link #toString()}
 * @author pyx
 * @date 2018/8/8
 */
public class ToStringSupport {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
