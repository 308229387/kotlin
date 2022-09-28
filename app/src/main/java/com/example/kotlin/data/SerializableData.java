package com.example.kotlin.data;

import java.io.Serializable;

public class SerializableData implements Serializable {
    private String ZCZLBH;  // 侦查指令编号 Z01000005130020210408QU
    private String ZLWH; // 指令文号 公刑指【2021】824898号
    private String YWDXBH; // 业务对象编号

    public String getZCZLBH() {
        return ZCZLBH;
    }

    public void setZCZLBH(String ZCZLBH) {
        this.ZCZLBH = ZCZLBH;
    }

    public String getZLWH() {
        return ZLWH;
    }

    public void setZLWH(String ZLWH) {
        this.ZLWH = ZLWH;
    }

    public String getYWDXBH() {
        return YWDXBH;
    }

    public void setYWDXBH(String YWDXBH) {
        this.YWDXBH = YWDXBH;
    }
}
