package model;

import model.status.GateStatus;

public class Gate extends BaseModel{
    private int gateNumber;
    private String operator;
    private GateType gateType;
    private GateStatus gateStatus;

    public Gate() {
    }

    public Gate(int gateNumber, String operator, GateType gateType, GateStatus gateStatus) {
        this.gateNumber = gateNumber;
        this.operator = operator;
        this.gateType = gateType;
        this.gateStatus = gateStatus;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


    public GateType getGateType() {
        return gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
