/**
 * 
 */
package com.sm.common.libs.core;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 代表一个byte数组。
 * 
 * @author <a href="chenxu.xc@alibaba-inc.com">xc</a>
 * @version create on 2017年2月22日 下午4:05:18
 */
public class ByteArray {
  private final byte[] bytes;
  private final int offset;
  private final int length;

  public ByteArray(byte[] bytes) {
    this(bytes, 0, Integer.MIN_VALUE);
  }

  public ByteArray(byte[] bytes, int offset, int length) {
    if (length == Integer.MIN_VALUE) {
      length = bytes.length - offset;
    }

    this.bytes = bytes;
    this.offset = offset;
    this.length = length;
  }

  public byte[] getRawBytes() {
    return bytes;
  }

  public int getOffset() {
    return offset;
  }

  public int getLength() {
    return length;
  }

  public byte[] toByteArray() {
    byte[] copy = new byte[length];

    System.arraycopy(bytes, offset, copy, 0, length);

    return copy;
  }

  public InputStream toInputStream() {
    return new ByteArrayInputStream(bytes, offset, length);
  }

  public void writeTo(OutputStream out) throws IOException {
    out.write(bytes, offset, length);
  }

  @Override
  public String toString() {
    return "byte[" + length + "]";
  }
}
