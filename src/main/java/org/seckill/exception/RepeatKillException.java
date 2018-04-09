package org.seckill.exception;

/**
 * Created by gongshiyun
 * Date: 2018/4/9
 * Time: 23:40
 * Description: 重复秒杀异常(运行期异常)
 */
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
