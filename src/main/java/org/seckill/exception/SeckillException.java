package org.seckill.exception;

/**
 * Created by gongshiyun
 * Date: 2018/4/9
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
