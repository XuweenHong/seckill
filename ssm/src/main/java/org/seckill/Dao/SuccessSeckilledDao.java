package org.seckill.Dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.Entities.SuccessSeckilled;

//对秒杀明细表的一系列增删改查操作
public interface SuccessSeckilledDao {
    /**
     * 插入一条秒杀成功明细表
     * @param seckillId  商品id
     * @param userPhone   用户手机信息
     * @return  是否插入成功 0表示失败
	 * 啊沙发沙发
     */
    int insertSuccessKilled(@Param("seckillId")long seckillId, @Param("userPhone")long userPhone);

    /**
     * 根据商品id查询秒杀成功明细
     * @param seckillId
     */
    SuccessSeckilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
}
