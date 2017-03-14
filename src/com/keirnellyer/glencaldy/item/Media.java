package com.keirnellyer.glencaldy.item;

import java.util.Objects;

public abstract class Media extends Item {
    private int runningTime;
    private String caseType;

    public Media(int id, String title, String publisher, float cost, int runningTime, String caseType) {
        super(id, title, publisher, cost);
        this.runningTime = runningTime;
        this.caseType = caseType;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    @Override
    public String getStockType() {
        return "Media";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        if (!super.equals(o)) return false;
        Media media = (Media) o;
        return runningTime == media.runningTime &&
                Objects.equals(caseType, media.caseType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), runningTime, caseType);
    }

    @Override
    public String toString() {
        return "Media{" +
                "runningTime=" + runningTime +
                ", caseType='" + caseType + '\'' +
                "} " + super.toString();
    }
}
