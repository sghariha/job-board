package com.shariharan.jobboard.model.resume;

import com.shariharan.jobboard.model.AppDate;

public class Education {
    private String institution;
    private String location;
    private String degreeName;
    private boolean isCurrent;
    private AppDate startDate;
    private AppDate endDate;
    private float gpa;

    public Education(String institution, String location, String degreeName, 
    boolean isCurrent, float gpa) {
        this.institution = institution;
        this.location = location;
        this.degreeName = degreeName;
        this.isCurrent = isCurrent;
        this.gpa = gpa;
    }

    public void setDate(int month, int year, boolean isStartDate) {
        AppDate userDate = new AppDate(month, year);
        if (isStartDate) this.startDate = userDate;
        else this.endDate = userDate;
    }

    public String getInstitution() {
        return this.institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDegreeName() {
        return this.degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public boolean isIsCurrent() {
        return this.isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public AppDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(AppDate startDate) {
        this.startDate = startDate;
    }

    public AppDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(AppDate endDate) {
        this.endDate = endDate;
    }

    public float getGpa() {
        return this.gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

}