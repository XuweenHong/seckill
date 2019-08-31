package org.seckill.Dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.Entities.Seckill;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {
    /**
     * 根据商品id查询库存信息
     * @param seckillId  商品id
     * @return  库存信息
     */
     Seckill queryById(long seckillId);

    /**
     * 根据商品id进行减库存，不用指定减多少库存，因为默认是每次只能秒杀一件，是更新操作
     * @param seckillId 商品id
     * @param killTime   秒杀成功的时间，也就是表中对应的create_time
     * @return 是否执行成功 0表示失败
     */
    int reduceNumber(@Param("seckillId")long seckillId, @Param("killTime")Date killTime);

    /**
     * 根据偏移量查询库存信息列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit")int limit);

    /**
     *
     * 使用存储过程执行秒杀
     * @param paramMap
     */
    void killByProcedure(Map<String, Object> paramMap);
}
