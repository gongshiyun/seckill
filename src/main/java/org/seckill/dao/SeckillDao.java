package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * @author gongshiyun
 * @date 2018/4/9
 */
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId 秒杀商品id
     * @param killTime 秒杀时间
     * @return 影响的行数
     */
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

    /**
     * 根据Id查询秒杀对象
     * @param seckillId 秒杀商品id
     * @return 秒杀对象
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset 偏移数
     * @param limit 数量
     * @return 秒杀对象列表
     */
    List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
}
