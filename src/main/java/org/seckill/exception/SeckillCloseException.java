package org.seckill.exception;

/**
 * @author gongshiyun
 * @date 2018/4/9
 * Time: 23:42
 * Description: 秒杀关闭异常
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
