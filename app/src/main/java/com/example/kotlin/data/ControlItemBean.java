package com.example.kotlin.data;

public class ControlItemBean {
    private String warnAllResultId;

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void setWarnAllResultId(String warnAllResultId) {
        this.warnAllResultId = warnAllResultId;
    }

    public void setShotTime(String shotTime) {
        this.shotTime = shotTime;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setDataTypeDesc(String dataTypeDesc) {
        this.dataTypeDesc = dataTypeDesc;
    }

    private String shotTime;
    private String address;
    private String taskName;
    private String dataType;
    private String dataTypeDesc;

    public String getWarnAllResultId() {
        return warnAllResultId;
    }

    public String getName() {
        return name;
    }

    public String getShotTime() {
        return shotTime;
    }

    public String getAddress() {
        return address;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDataType() {
        return dataType;
    }

    public String getDataTypeDesc() {
        return dataTypeDesc;
    }
}
