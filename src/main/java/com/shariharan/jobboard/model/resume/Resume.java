package com.shariharan.jobboard.model.resume;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shariharan.jobboard.model.AppDate;

import java.util.ArrayList;

@Document(collection = "Resumes")
public class Resume {
    @Id
    private String id;
    private String userId;
    private AppDate createdDate;
    private ArrayList<Education> education;
    private ArrayList<Experience> experiences;

    public Resume(String userId, AppDate createdDate, 
    ArrayList<Education> education, ArrayList<Experience> experiences) {
        this.userId = userId;
        this.createdDate = createdDate;
        this.education = education;
        this.experiences = experiences;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AppDate getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(AppDate createdDate) {
        this.createdDate = createdDate;
    }

    public ArrayList<Education> getEducation() {
        return this.education;
    }

    public void setEducation(ArrayList<Education> education) {
        this.education = education;
    }

    public ArrayList<Experience> getExperiences() {
        return this.experiences;
    }

    public void setExperiences(ArrayList<Experience> experiences) {
        this.experiences = experiences;
    }
}