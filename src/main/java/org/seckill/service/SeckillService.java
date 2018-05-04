package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * @author gongshiyun
 * @date 2018/4/9
 * Time: 23:21
 * Description:
 * 业务接口:站在'使用者'角度设计接口
 * 三个方面:方法定义粒度,参数,返回类型(return 类型友好/异常)
 *
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     *
     * @return List<Seckill> 秒杀对象列表
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId 秒杀对象id
     * @return Seckill 秒杀对象
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址,
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId 秒杀对象id
     * @return Exposer 暴露秒杀地址的对象
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId 秒杀对象id
     * @param userPhone 用户手机号
     * @param md5 md5加密字符串
     * @return SeckillExecution 秒杀执行结果对象
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException,RepeatKillException,SeckillCloseException;

    /**
     * 执行秒杀操作 by 存储过程
     *
     * @param seckillId 秒杀对象id
     * @param userPhone 用户手机号
     * @param md5 md5加密字符串
     * @return SeckillExecution 秒杀执行结果对象
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
}
