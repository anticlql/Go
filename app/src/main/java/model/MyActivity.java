package Model;
import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */
public class MyActivity implements Serializable {
    private String id;

    private String name;

    private Date timeStart;

    private Date timeEnd;

    private String baiduPoint;

    private String positon;

    private Boolean isOffical;

    private Boolean isCharge;

    private Boolean isShow;

    private Boolean isAvailable;

    private Boolean isIssued;

    private Integer enrollNumber;

    private Integer maxEnrollNumber;

    private String activityId;

    private String promulgtorId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getBaiduPoint() {
        return baiduPoint;
    }

    public void setBaiduPoint(String baiduPoint) {
        this.baiduPoint = baiduPoint;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public Boolean getIsOffical() {
        return isOffical;
    }

    public void setIsOffical(Boolean isOffical) {
        this.isOffical = isOffical;
    }

    public Boolean getIsCharge() {
        return isCharge;
    }

    public void setIsCharge(Boolean isCharge) {
        this.isCharge = isCharge;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Boolean getIsIssued() {
        return isIssued;
    }

    public void setIsIssued(Boolean isIssued) {
        this.isIssued = isIssued;
    }

    public Integer getEnrollNumber() {
        return enrollNumber;
    }

    public void setEnrollNumber(Integer enrollNumber) {
        this.enrollNumber = enrollNumber;
    }

    public Integer getMaxEnrollNumber() {
        return maxEnrollNumber;
    }

    public void setMaxEnrollNumber(Integer maxEnrollNumber) {
        this.maxEnrollNumber = maxEnrollNumber;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getPromulgtorId() {
        return promulgtorId;
    }

    public void setPromulgtorId(String promulgtorId) {
        this.promulgtorId = promulgtorId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MyActivity other = (MyActivity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getTimeStart() == null ? other.getTimeStart() == null : this.getTimeStart().equals(other.getTimeStart()))
                && (this.getTimeEnd() == null ? other.getTimeEnd() == null : this.getTimeEnd().equals(other.getTimeEnd()))
                && (this.getBaiduPoint() == null ? other.getBaiduPoint() == null : this.getBaiduPoint().equals(other.getBaiduPoint()))
                && (this.getPositon() == null ? other.getPositon() == null : this.getPositon().equals(other.getPositon()))
                && (this.getIsOffical() == null ? other.getIsOffical() == null : this.getIsOffical().equals(other.getIsOffical()))
                && (this.getIsCharge() == null ? other.getIsCharge() == null : this.getIsCharge().equals(other.getIsCharge()))
                && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()))
                && (this.getIsAvailable() == null ? other.getIsAvailable() == null : this.getIsAvailable().equals(other.getIsAvailable()))
                && (this.getIsIssued() == null ? other.getIsIssued() == null : this.getIsIssued().equals(other.getIsIssued()))
                && (this.getEnrollNumber() == null ? other.getEnrollNumber() == null : this.getEnrollNumber().equals(other.getEnrollNumber()))
                && (this.getMaxEnrollNumber() == null ? other.getMaxEnrollNumber() == null : this.getMaxEnrollNumber().equals(other.getMaxEnrollNumber()))
                && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
                && (this.getPromulgtorId() == null ? other.getPromulgtorId() == null : this.getPromulgtorId().equals(other.getPromulgtorId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTimeStart() == null) ? 0 : getTimeStart().hashCode());
        result = prime * result + ((getTimeEnd() == null) ? 0 : getTimeEnd().hashCode());
        result = prime * result + ((getBaiduPoint() == null) ? 0 : getBaiduPoint().hashCode());
        result = prime * result + ((getPositon() == null) ? 0 : getPositon().hashCode());
        result = prime * result + ((getIsOffical() == null) ? 0 : getIsOffical().hashCode());
        result = prime * result + ((getIsCharge() == null) ? 0 : getIsCharge().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
        result = prime * result + ((getIsAvailable() == null) ? 0 : getIsAvailable().hashCode());
        result = prime * result + ((getIsIssued() == null) ? 0 : getIsIssued().hashCode());
        result = prime * result + ((getEnrollNumber() == null) ? 0 : getEnrollNumber().hashCode());
        result = prime * result + ((getMaxEnrollNumber() == null) ? 0 : getMaxEnrollNumber().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getPromulgtorId() == null) ? 0 : getPromulgtorId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", timeStart=").append(timeStart);
        sb.append(", timeEnd=").append(timeEnd);
        sb.append(", baiduPoint=").append(baiduPoint);
        sb.append(", positon=").append(positon);
        sb.append(", isOffical=").append(isOffical);
        sb.append(", isCharge=").append(isCharge);
        sb.append(", isShow=").append(isShow);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", isIssued=").append(isIssued);
        sb.append(", enrollNumber=").append(enrollNumber);
        sb.append(", maxEnrollNumber=").append(maxEnrollNumber);
        sb.append(", activityId=").append(activityId);
        sb.append(", promulgtorId=").append(promulgtorId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}