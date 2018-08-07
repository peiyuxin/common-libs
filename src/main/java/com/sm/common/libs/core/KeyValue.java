/**
 * 
 */
package com.sm.common.libs.core;

/**
 * KeyValue
 * 
 * @author <a href="chenxu.xc@alibaba-inc.com">xc</a>
 * @version create on 2018年4月2日 下午3:42:00
 */
public class KeyValue<K, V> extends ToStringSupport {

  private final K key;

  private final V value;

  public KeyValue(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

}
