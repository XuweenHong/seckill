package org.seckill.service;

import org.seckill.Entities.Seckill;
import org.seckill.dto.Exposure;
import org.seckill.dto.SeckillExecution;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.exception.SeckillRepeatException;

import java.util.List;

/**
 * 业务接口：站在“使用者”角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型（return类型/异常）
 *
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 对给定的秒杀商品id
     * 如果符合秒杀条件，则输出秒杀地址
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     * @return
     */
    Exposure exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws SeckillRepeatException
     * @throws SeckillCloseException
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillRepeatException, SeckillCloseException;

    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillRepeatException, SeckillCloseException;
}
