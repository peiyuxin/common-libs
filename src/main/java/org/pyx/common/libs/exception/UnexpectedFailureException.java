package org.pyx.common.libs.exception;

/**
 * 代表未预期失败的异常。
 * @author pyx
 * @date 2018/8/14
 */
public class UnexpectedFailureException extends RuntimeException{


    private UnexpectedFailureException(){
        super();
    }

    private UnexpectedFailureException(String message){
        super(message);
    }

    private UnexpectedFailureException(Throwable cause){
        super(cause);
    }

    private UnexpectedFailureException(String message, Throwable cause){
        super(message, cause);
    }

}
