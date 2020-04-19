package com.shariharan.jobboard.model.resume;

import com.shariharan.jobboard.model.AppDate;

public class Experience {
    private String company;
    private String location;
    private String roleName;
    private boolean isCurrent;
    private AppDate startDate;
    private AppDate endDate;
    private String description;

    public Experience(String company, String location, String roleName, 
    boolean isCurrent, String description) {
        this.company = company;
        this.location = location;
        this.roleName = roleName;
        this.isCurrent = isCurrent;
        this.description = description;
    }

    public void setDate(int month, int year, boolean isStartDate) {
        AppDate userDate = new AppDate(month, year);
        if (isStartDate) this.startDate = userDate;
        else this.endDate = userDate;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}