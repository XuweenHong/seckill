package org.seckill.Entities;

import java.util.Date;

public class SuccessSeckilled {
    private long seckillId;

    private long userPhone;

    private short state;

    private Date createTime;

    //多对一
    private Seckill seckill;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTIme() {
        return createTime;
    }

    public void setCreateTIme(Date createTIme) {
        this.createTime = createTIme;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckil(Seckill seckil) {
        this.seckill = seckil;
    }

    @Override
    public String toString() {
        return "SuccessSeckilled{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTIme=" + createTime +
                '}';
    }
}
