package org.seckill.dto;

import org.seckill.Entities.SuccessSeckilled;
import org.seckill.enums.SeckillStateEnum;

/**
 * 封装秒杀执行后的结果
 * 秒杀是否成功，如果失败的话，失败原因是什么
 */
public class SeckillExecution {

    private long seckillId;

    //状态
    private int state;

    //状态信息
    private String stateInfo;

    //如果秒杀成功，返回秒杀成功对象
    private SuccessSeckilled successSeckilled;

    public SeckillExecution(long seckillId, SeckillStateEnum stateEnum, SuccessSeckilled successSeckilled) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successSeckilled = successSeckilled;
    }

    public SeckillExecution(long seckillId, SeckillStateEnum stateEnum) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public SuccessSeckilled getSuccessSeckilled() {
        return successSeckilled;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public void setSuccessSeckilled(SuccessSeckilled successSeckilled) {
        this.successSeckilled = successSeckilled;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successSeckilled=" + successSeckilled +
                '}';
    }

}
