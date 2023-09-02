package con.huajia.clock.bean;

public class TimeRecordBean {
    private String serialNum;
    private String extraTime;
    private String recordTime;
    public TimeRecordBean(String serialNum,String extraTime,String recordTime){
        this.serialNum = serialNum;
        this.extraTime = extraTime;
        this.recordTime = recordTime;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(String extraTime) {
        this.extraTime = extraTime;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }
}
