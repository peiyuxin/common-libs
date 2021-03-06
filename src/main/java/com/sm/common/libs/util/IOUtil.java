/**
 * 
 */
package com.sm.common.libs.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;

import com.sm.common.libs.core.ByteArray;
import com.sm.common.libs.util.io.ByteArrayOutputStream;
import com.sm.common.libs.util.io.IOConstant;

/**
 * IO相关的工具类
 * 
 * <p>
 * 这个类中的每个方法都可以“安全”地处理 <code>null</code> ，而不会抛出 <code>NullPointerException</code>。
 * </p>
 * 
 * @author <a href="chenxu.xc@alibaba-inc.com">xc</a>
 * @version create on 2016年11月15日 下午3:26:08
 */
public abstract class IOUtil implements IOConstant {

  private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(IOUtil.class);

  /**
   * 从输入流读取内容, 写入到输出流中. 此方法使用大小为8192字节的默认的缓冲区.
   * 
   * @param in 输入流
   * @param out 输出流
   * 
   * @throws IOException 输入输出异常
   */
  public static void io(InputStream in, OutputStream out) throws IOException {
    io(in, out, -1);
  }

  /**
   * 从输入流读取内容, 写入到输出流中. 使用指定大小的缓冲区.
   * 
   * @param in 输入流
   * @param out 输出流
   * @param bufferSize 缓冲区大小(字节数)
   * 
   * @throws IOException 输入输出异常
   */
  public static void io(InputStream in, OutputStream out, int bufferSize) throws IOException {
    if (bufferSize == -1) {
      bufferSize = DEFAULT_BUFFER_SIZE;
    }

    byte[] buffer = new byte[bufferSize];
    int amount;

    while ((amount = in.read(buffer)) >= 0) {
      out.write(buffer, 0, amount);
    }

    out.flush();
  }

  /**
   * 从输入流读取内容, 写入到输出流中. 此方法使用大小为8192字符的默认的缓冲区.
   * 
   * @param in 输入流
   * @param out 输出流
   * 
   * @throws IOException 输入输出异常
   */
  public static void io(Reader in, Writer out) throws IOException {
    io(in, out, -1);
  }

  /**
   * 从输入流读取内容, 写入到输出流中. 使用指定大小的缓冲区.
   * 
   * @param in 输入流
   * @param out 输出流
   * @param bufferSize 缓冲区大小(字符数)
   * 
   * @throws IOException 输入输出异常
   */
  public static void io(Reader in, Writer out, int bufferSize) throws IOException {
    if (bufferSize == -1) {
      bufferSize = DEFAULT_BUFFER_SIZE >> 1;
    }

    char[] buffer = new char[bufferSize];
    int amount;

    while ((amount = in.read(buffer)) >= 0) {
      out.write(buffer, 0, amount);
    }

    out.flush();
  }

  /**
   * 从输入流读取内容, 写入到输出流中. 此方法使用大小为8192字节的默认的缓冲区.
   * 
   * @param in 输入流
   * @param out 输出流
   * @param closeIn 是否关闭输入流
   * @param closeOut 是否关闭输出流
   * @throws IOException 输入输出异常
   */
  public static void io(InputStream in, OutputStream out, boolean closeIn, boolean closeOut) throws IOException {

    try {
      io(in, out);
    } finally {
      if (closeIn) {
        close(in);
      }

      if (closeOut) {
        close(out);
      }
    }
  }

  /**
   * 从输入流读取内容, 写入到输出流中. 此方法使用大小为8192字节的默认的缓冲区.
   * 
   * @param in 输入流
   * @param out 输出流
   * @param closeIn 是否关闭输入流
   * @param closeOut 是否关闭输出流
   * @throws IOException 输入输出异常
   */
  public static void io(Reader in, Writer out, boolean closeIn, boolean closeOut) throws IOException {
    try {
      io(in, out);
    } finally {
      if (closeIn) {
        close(in);
      }

      if (closeOut) {
        close(out);
      }
    }
  }

  /** 从输入流读取内容, 写入到目标文件 */
  public static void io(InputStream in, File dest) throws IOException {
    OutputStream out = new FileOutputStream(dest);
    io(in, out);
  }

  /** 从输入流读取内容, 写入到目标文件 */
  public static void io(InputStream in, File dest, boolean closeIn, boolean closeOut) throws IOException {
    OutputStream out = new FileOutputStream(dest);
    try {
      io(in, out);
    } finally {
      if (closeIn) {
        close(in);
      }

      if (closeOut) {
        close(out);
      }
    }
  }

  /** 从输入流读取内容, 写入到目标文件 */
  public static void io(InputStream in, String dest) throws IOException {
    OutputStream out = new FileOutputStream(dest);
    io(in, out);
  }

  /** 从输入流读取内容, 写入到目标文件 */
  public static void io(InputStream in, String dest, boolean closeIn, boolean closeOut) throws IOException {
    OutputStream out = new FileOutputStream(dest);
    try {
      io(in, out);
    } finally {
      if (closeIn) {
        close(in);
      }

      if (closeOut) {
        close(out);
      }
    }
  }

  /** 从输入流读取内容, 写入到目标文件 */
  public static void io(Reader in, File dest) throws IOException {
    Writer out = new FileWriter(dest);
    io(in, out);
  }

  /** 从输入流读取内容, 写入到目标文件 */
  public static void io(Reader in, File dest, boolean closeIn, boolean closeOut) throws IOException {
    Writer out = new FileWriter(dest);
    try {
      io(in, out);
    } finally {
      if (closeIn) {
        close(in);
      }

      if (closeOut) {
        close(out);
      }
    }
  }

  /** 从输入流读取内容, 写入到目标文件 */
  public static void io(Reader in, String dest) throws IOException {
    Writer out = new FileWriter(dest);
    io(in, out);
  }

  /** 从输入流读取内容, 写入到目标文件 */
  public static void io(Reader in, String dest, boolean closeIn, boolean closeOut) throws IOException {
    Writer out = new FileWriter(dest);
    try {
      io(in, out);
    } finally {
      if (closeIn) {
        close(in);
      }

      if (closeOut) {
        close(out);
      }
    }
  }

  /**
   * 从<code>URL</code>读取内容, 写入到目标文件
   * 
   * @param source @see URL
   * @param dest 目标文件
   * @throws IOException
   */
  public static void io(URL source, File dest) throws IOException {
    OutputStream out = new FileOutputStream(dest);
    io(source.openStream(), out);
  }

  /**
   * 从<code>URL</code>读取内容, 写入到目标文件
   * 
   * @param source source @see URL
   * @param dest 目标文件
   * @param closeIn 是否关闭输入流
   * @param closeOut 是否关闭输出流
   * @throws IOException
   */
  public static void io(URL source, File dest, boolean closeIn, boolean closeOut) throws IOException {
    OutputStream out = new FileOutputStream(dest);
    InputStream in = source.openStream();
    try {
      io(in, out);
    } finally {
      if (closeIn) {
        close(in);
      }

      if (closeOut) {
        close(out);
      }
    }
  }

  /**
   * 从<code>URL</code>读取内容, 写入到目标文件
   * 
   * @param source @see URL
   * @param dest 目标文件
   * @throws IOException
   */
  public static void io(URL source, String dest) throws IOException {
    OutputStream out = new FileOutputStream(dest);
    io(source.openStream(), out);
  }

  public static void io(InputStream input, Writer output, String encoding) throws IOException {
    io(new InputStreamReader(input, encoding), output);
  }

  /**
   * 从<code>URL</code>读取内容, 写入到目标文件
   * 
   * @param source source @see URL
   * @param dest 目标文件
   * @param closeIn 是否关闭输入流
   * @param closeOut 是否关闭输出流
   * @throws IOException
   */
  public static void io(URL source, String dest, boolean closeIn, boolean closeOut) throws IOException {
    OutputStream out = new FileOutputStream(dest);
    InputStream in = source.openStream();
    try {
      io(in, out);
    } finally {
      if (closeIn) {
        close(in);
      }

      if (closeOut) {
        close(out);
      }
    }
  }

  /**
   * 取得同步化的输出流.
   * 
   * @param out 要包裹的输出流
   * 
   * @return 线程安全的同步化输出流
   */
  public static OutputStream synchronizedOutputStream(OutputStream out) {
    return new SynchronizedOutputStream(out);
  }

  /**
   * 取得同步化的输出流.
   * 
   * @param out 要包裹的输出流
   * @param lock 同步锁
   * 
   * @return 线程安全的同步化输出流
   */
  public static OutputStream synchronizedOutputStream(OutputStream out, Object lock) {
    return new SynchronizedOutputStream(out, lock);
  }

  /**
   * 将指定输入流的所有文本全部读出到一个字符串中.
   * 
   * @param in 要读取的输入流
   * 
   * @return 从输入流中取得的文本
   * 
   * @throws IOException 输入输出异常
   */
  public static String readText(InputStream in) throws IOException {
    return readText(in, null, -1);
  }

  public static String readText(String filePath) throws IOException {
    return readText(new FileInputStream(filePath), null, -1);
  }

  /**
   * 将指定输入流的所有文本全部读出到一个字符串中.
   * 
   * @param in 要读取的输入流
   * @param encoding 文本编码方式
   * 
   * @return 从输入流中取得的文本
   * 
   * @throws IOException 输入输出异常
   */
  public static String readText(InputStream in, String encoding) throws IOException {
    return readText(in, encoding, -1);
  }

  /**
   * 将指定输入流的所有文本全部读出到一个字符串中.
   * 
   * @param in 要读取的输入流
   * @param charset 文本编码方式
   * @param bufferSize 缓冲区大小(字符数)
   * 
   * @return 从输入流中取得的文本
   * 
   * @throws IOException 输入输出异常
   */
  public static String readText(InputStream in, String charset, int bufferSize) throws IOException {
    Reader reader = (charset == null) ? new InputStreamReader(in) : new InputStreamReader(in, charset);

    return readText(reader, bufferSize);
  }

  /**
   * 将指定输入流的所有文本全部读出到一个字符串中.
   * 
   * @param in 要读取的输入流
   * @param charset 文本编码方式
   * @param closeIn 是否关闭输入流
   * @return 从输入流中取得的文本
   * @throws IOException 输入输出异常
   */
  public static String readText(InputStream in, String charset, boolean closeIn) throws IOException {
    Reader reader = charset == null ? new InputStreamReader(in) : new InputStreamReader(in, charset);

    return readText(reader, closeIn);
  }

  /**
   * 将指定输入流的所有文本全部读出到一个字符串中.
   * 
   * @param in 要读取的输入流
   * @param closeIn 是否关闭输入流
   * @return 从输入流中取得的文本
   * @throws IOException 输入输出异常
   */
  public static String readText(Reader in, boolean closeIn) throws IOException {
    StringWriter out = new StringWriter();

    io(in, out, closeIn, true);

    return out.toString();
  }

  /**
   * 将指定<code>Reader</code>的所有文本全部读出到一个字符串中.
   * 
   * @param reader 要读取的<code>Reader</code>
   * 
   * @return 从<code>Reader</code>中取得的文本
   * 
   * @throws IOException 输入输出异常
   */
  public static String readText(Reader reader) throws IOException {
    return readText(reader, -1);
  }

  /**
   * 将指定<code>Reader</code>的所有文本全部读出到一个字符串中.
   * 
   * @param reader 要读取的<code>Reader</code>
   * @param bufferSize 缓冲区的大小(字符数)
   * 
   * @return 从<code>Reader</code>中取得的文本
   * 
   * @throws IOException 输入输出异常
   */
  public static String readText(Reader reader, int bufferSize) throws IOException {
    StringWriter writer = new StringWriter();

    io(reader, writer, bufferSize);

    return writer.toString();
  }

  /**
   * 将指定<code>InputStream</code>的所有内容全部读出到一个byte数组中。
   * 
   * @param in 要读取的<code>InputStream</code>
   * @return ByteArray # @see ByteArray
   * @throws IOException
   */
  public static ByteArray readBytes(InputStream in) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    io(in, out);

    return out.toByteArray();
  }

  /** 将指定<code>InputStream</code>的所有内容全部读出到一个byte数组中。 */
  public static ByteArray readBytes(InputStream in, boolean closeIn) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    io(in, out, closeIn, true);

    return out.toByteArray();
  }

  /**
   * 将指定<code>File</code>的所有内容全部读出到一个byte数组中。
   * 
   * @param file 要读取的文件
   * @return ByteArray # @see ByteArray
   * @throws IOException
   */
  public static ByteArray readBytes(String file) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    io(new FileInputStream(file), out);

    return out.toByteArray();
  }

  /**
   * 将指定<code>File</code>的所有内容全部读出到一个byte数组中。
   * 
   * @param file 要读取的文件
   * @param closeIn 是否关闭流
   * @return ByteArray # @see ByteArray
   * @throws IOException
   */
  public static ByteArray readBytes(String file, boolean closeIn) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    io(new FileInputStream(file), out, closeIn, true);

    return out.toByteArray();
  }

  /**
   * 将指定<code>File</code>的所有内容全部读出到一个byte数组中。
   * 
   * @param file 要读取的文件
   * @return ByteArray # @see ByteArray
   * @throws IOException
   */
  public static ByteArray readBytes(File file) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    io(new FileInputStream(file), out);

    return out.toByteArray();
  }

  /** 将指定<code>File</code>的所有内容全部读出到一个byte数组中。 */
  public static ByteArray readBytes(File file, boolean closeIn) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    io(new FileInputStream(file), out, closeIn, true);

    return out.toByteArray();
  }

  /** 将字符串写入到指定输出流中。 */
  public static void writeText(CharSequence chars, OutputStream out, String charset, boolean closeOut)
      throws IOException {
    Writer writer = charset == null ? new OutputStreamWriter(out) : new OutputStreamWriter(out, charset);

    writeText(chars, writer, closeOut);
  }

  /** 将字符串写入到指定<code>Writer</code>中。 */
  public static void writeText(CharSequence chars, Writer out, boolean closeOut) throws IOException {
    try {
      out.write(chars.toString());
      out.flush();
    } finally {
      if (closeOut) {
        try {
          out.close();
        } catch (IOException e) {
          // ignore
        }
      }
    }
  }

  public static void writeText(CharSequence chars, String filePath, boolean closeOut) throws IOException {
    writeText(chars, new FileWriter(filePath), closeOut);
  }

  /** 将byte数组写入到指定<code>filePath</code>中。 */
  public static void writeBytes(byte[] bytes, String filePath, boolean closeOut) throws IOException {
    writeBytes(new ByteArray(bytes), new FileOutputStream(filePath), closeOut);
  }

  /** 将byte数组写入到指定<code>File</code>中。 */
  public static void writeBytes(byte[] bytes, File file, boolean closeOut) throws IOException {
    writeBytes(new ByteArray(bytes), new FileOutputStream(file), closeOut);
  }

  /** 将byte数组写入到指定<code>OutputStream</code>中。 */
  public static void writeBytes(byte[] bytes, OutputStream out, boolean closeOut) throws IOException {
    writeBytes(new ByteArray(bytes), out, closeOut);
  }

  /** 将byte数组写入到指定<code>OutputStream</code>中。 */
  public static void writeBytes(ByteArray bytes, OutputStream out, boolean closeOut) throws IOException {
    try {
      out.write(bytes.getRawBytes(), bytes.getOffset(), bytes.getLength());
      out.flush();
    } finally {
      if (closeOut) {
        try {
          out.close();
        } catch (IOException e) {
          logger.error("close error", e);
        }
      }
    }
  }

  /**
   * 关闭流
   * 
   * @param closed 可关闭的流
   */
  public static void close(Closeable closed) {
    if (closed != null) {
      try {
        closed.close();
      } catch (IOException ignore) {
        logger.error("close error", ignore);
      }
    }
  }

  public static IOException closeAndGetEx(Closeable closed) {
    if (closed != null) {
      try {
        closed.close();
      } catch (IOException e) {
        return e;
      }
    }

    return null;
  }

  /**
   * 同步化的输出流包裹器.
   */
  private static class SynchronizedOutputStream extends OutputStream {
    private OutputStream out;
    private Object lock;

    SynchronizedOutputStream(OutputStream out) {
      this(out, out);
    }

    SynchronizedOutputStream(OutputStream out, Object lock) {
      this.out = out;
      this.lock = lock;
    }

    public void write(int datum) throws IOException {
      synchronized (lock) {
        out.write(datum);
      }
    }

    public void write(byte[] data) throws IOException {
      synchronized (lock) {
        out.write(data);
      }
    }

    public void write(byte[] data, int offset, int length) throws IOException {
      synchronized (lock) {
        out.write(data, offset, length);
      }
    }

    public void flush() throws IOException {
      synchronized (lock) {
        out.flush();
      }
    }

    public void close() throws IOException {
      synchronized (lock) {
        out.close();
      }
    }
  }

}
