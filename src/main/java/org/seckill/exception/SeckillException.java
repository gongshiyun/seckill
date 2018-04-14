package org.seckill.exception;

/**
 * @author gongshiyun
 * @date 2018/4/9
 * Time: 23:43
 * Description: 秒杀相关业务异常
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
