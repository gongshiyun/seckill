package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by gongshiyun
 * Date: 2018/4/11
 * Time: 21:26
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> seckills = seckillService.getSeckillList();
        logger.info("list={}",seckills);
    }

    @Test
    public void getById() {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void exportSeckillUrl() {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
    }

    @Test
    public void executeSeckill() {
        long id = 1000;
        long userPhone1 = 12354234541L;
        long userPhone2 = 12354234542L;
        String md51 = "b2d2415fd2eb74a02d8b5cb5fce9f589";
        String md52 = "b2d2415fd2eb74a02d8b5cb5fce9f512";

        SeckillExecution seckillExecution1 = seckillService.executeSeckill(id,userPhone1,md51);
        logger.info("seckillExecution1={}",seckillExecution1);

        SeckillExecution seckillExecution2 = seckillService.executeSeckill(id,userPhone1,md51);
        logger.info("seckillExecution2={}",seckillExecution2);
    }

    /**
     * 集成测试代码完整逻辑,注意可重复执行
     */
    @Test
    public void seckillLogicTest(){
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long phone = 1235423454122L;
            String md5 = exposer.getMd5();
            try{
                SeckillExecution seckillExecution1 = seckillService.executeSeckill(id,phone,md5);
                logger.info("seckillExecution1={}",seckillExecution1);
            } catch (RepeatKillException e){
                logger.error(e.getMessage());
            } catch (SeckillCloseException e){
                logger.error(e.getMessage());
            } catch (SeckillException e){
                logger.error(e.getMessage());
            }
        } else {
            logger.warn("exposer={}",exposer);
        }
    }
}