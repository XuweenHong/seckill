package org.seckill.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.Entities.Seckill;
import org.seckill.dto.Exposure;
import org.seckill.dto.SeckillExecution;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillRepeatException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() {
        long seckillId = 1000;
        Seckill seckill = seckillService.getById(seckillId);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() {
        long seckillId = 1000;
        Exposure exposure = seckillService.exportSeckillUrl(seckillId);
        logger.info("exposure={}", exposure);
    }

    //集成测试
    @Test
    public void testSeckillLogin() throws Exception {
        long seckillId = 1003;
        Exposure exposure = seckillService.exportSeckillUrl(seckillId);
        if (exposure.isExposed()) {
            // 秒杀开启
            long userPhone = 15244422525L;
            String md5 = exposure.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
                logger.info("result={}", seckillExecution);
            } catch (SeckillRepeatException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            }
        } else {
            //秒杀未开启
            logger.warn("exposure={}", exposure);
        }
    }

    @Test
    public void executeSeckillProcedure() {
        long seckillId = 1001;
        long phone = 18755961221L;
        Exposure exposure = seckillService.exportSeckillUrl(seckillId);
        if (exposure.isExposed()) {
            String mds = exposure.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, mds);
            logger.info(execution.getStateInfo());
        }
    }
}