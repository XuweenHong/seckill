package org.seckill.Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.Entities.SuccessSeckilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class SuccessSeckilledDaoTest {
    @Resource
    private SuccessSeckilledDao successSeckilledDao;

    @Test
    public void insertKilledInfoTest() throws Exception {
        long id = 1001L;
        long userPhone = 123456789L;
        int insertCount = successSeckilledDao.insertSuccessKilled(id, userPhone);
        System.out.println(insertCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1001L;
        long userPhone = 123456789L;
        SuccessSeckilled successSeckilled = successSeckilledDao.queryByIdWithSeckill(id, userPhone);
        System.out.println(successSeckilled);
        System.out.println(successSeckilled.getSeckill());
    }

}