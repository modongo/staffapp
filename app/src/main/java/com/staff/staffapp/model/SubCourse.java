package com.staff.staffapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCourse {
    @SerializedName("coarseid")
    @Expose
    private int courseId;
    @SerializedName("name")
    @Expose
    private String courseTitle;
    @SerializedName("url")
    @Expose
    private String contentUrl;

    public SubCourse(int courseId, String courseTitle, String contentUrl) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.contentUrl = contentUrl;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }
}
