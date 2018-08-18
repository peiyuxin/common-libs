package org.pyx.common.libs.bus;

import java.util.HashMap;

/**
 * @author pyx
 * @date 2018/8/8
 */
public class ActionData<T> extends HashMap<String,String> {

    /**
     * 默认的catalog
     */
    public static final String NO_CATALOG = "NO_CATALOG";

    /**
     * 类型
     */
    private String catalog;

    /**
     * 总线
     */
    private String bus;

    /**
     * 携带数据
     */
    private T payload;

    public ActionData(){
        this.catalog = NO_CATALOG;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
