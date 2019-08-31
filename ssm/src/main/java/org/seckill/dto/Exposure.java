package org.seckill.dto;

/**
 * 暴露秒杀地址url
 */
public class Exposure {

    private long seckillId;

    // 是否开始秒杀
    private boolean exposed;

    //加密后的地址
    private String md5;

    //系统时间
    private long now;

    //秒杀开始时间
    private long start;

    //秒杀结束时间
    private long end;

    public Exposure(long seckillId, boolean exposed, String md5) {
        this.seckillId = seckillId;
        this.exposed = exposed;
        this.md5 = md5;
    }

    public Exposure(long seckillId, boolean exposed, long now, long start, long end) {
        this.seckillId = seckillId;
        this.exposed = exposed;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposure(long seckillId, boolean exposed) {
        this.seckillId = seckillId;
        this.exposed = exposed;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public String getMd5() {
        return md5;
    }

    public long getNow() {
        return now;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Exposure{" +
                "seckillId=" + seckillId +
                ", exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

}
