package org.pyx.common.libs.exception;

/**
 * 代表不可能到达的代码的异常
 * @author pyx
 * @date 2018/8/14
 */
public class UnreachableCodeException extends RuntimeException{

    /**
     * 空构造函数
     */
    public UnreachableCodeException(){
        super();
    }

    /**
     * 构造一个异常,指明引起这个异常的起因
     * @param message 详细信息
     */
    public UnreachableCodeException(String message){
        super(message);
    }

    /**
     * 构造一个异常,指明引起这个异常的起因
     * @param cause 异常的起因
     */
    public UnreachableCodeException(Throwable cause){
        super(cause);
    }

    /**
     * 构造一个异常,指明引起这个异常的起因
     * @param message 详细原因
     * @param cause 异常的起因
     */
    public UnreachableCodeException(String message,Throwable cause){
        super(message, cause);
    }
}
