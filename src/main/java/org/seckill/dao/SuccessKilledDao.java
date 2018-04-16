package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @author gongshiyun
 * @date 2018/4/9
 */
public interface SuccessKilledDao {
    /**
     * 插入购买明细,可过滤重复
     *
     * @param seckillId 秒杀商品id
     * @param userPhone 用户手机号
     * @return 插入的行数
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     *
     * @param seckillId 秒杀商品id
     * @param userPhone 用户手机号
     * @return SuccessKilled 秒杀成功对象
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
