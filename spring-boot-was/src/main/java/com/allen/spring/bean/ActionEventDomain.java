/**
 * 
 */
package com.allen.spring.bean;

/**
 * @author first
 *
 */
public class ActionEventDomain {

    private Long id;

    // Mvtm:branchId; Agent: staffId
    private String ownerId;

    // Mvtm:branchName; Agent:staffName
    private String ownerName;

    // Mvtm Action or agent aciton
    private String action;

//    // 当前交易的transactionId
//    private String transactionId;

    // 拨打次数
    private int callTimes;

    // Agent no online ,retryTime =0
    private int retryTimes;

    public int getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

//    public String getTransactionId() {
//        return transactionId;
//    }
//
//    public void setTransactionId(String transactionId) {
//        this.transactionId = transactionId;
//    }

    // public Date getStartTime() {
    // return startTime;
    // }
    //
    // public void setStartTime(Date startTime) {
    // this.startTime = startTime;
    // }
    //
    // public Date getEndTime() {
    // return endTime;
    // }
    //
    // public void setEndTime(Date endTime) {
    // this.endTime = endTime;
    // }

    public int getCallTimes() {
        return callTimes;
    }

    public void setCallTimes(int callTimes) {
        this.callTimes = callTimes;
    }

    // public String getStatus() {
    // return status;
    // }
    //
    // public void setStatus(String status) {
    // this.status = status;
    // }

    // public String getSignStatus() {
    // return signStatus;
    // }
    //
    // public void setSignStatus(String signStatus) {
    // this.signStatus = signStatus;
    // }

    // public Date getSignOnTime() {
    // return signOnTime;
    // }
    //
    // public void setSignOnTime(Date signOnTime) {
    // this.signOnTime = signOnTime;
    // }

    // public Date getSignOffTime() {
    // return signOffTime;
    // }
    //
    // public void setSignOffTime(Date signOffTime) {
    // this.signOffTime = signOffTime;
    // }

    // public Long getSignDuration() {
    // return signDuration;
    // }
    //
    // public void setSignDuration(Long signDuration) {
    // this.signDuration = signDuration;
    // }

    // public String getWorkingStatus() {
    // return workingStatus;
    // }
    //
    // public void setWorkingStatus(String workingStatus) {
    // this.workingStatus = workingStatus;
    // }

    // public Date getLastUpdateTime() {
    // return lastUpdateTime;
    // }
    //
    // public void setLastUpdateTime(Date lastUpdateTime) {
    // this.lastUpdateTime = lastUpdateTime;
    // }

    // public Long getWorkingDuration() {
    // return workingDuration;
    // }
    //
    // public void setWorkingDuration(Long workingDuration) {
    // this.workingDuration = workingDuration;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
