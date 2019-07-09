package com.staff.staffapp.school.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCourse {
    @SerializedName("coarse_name")
    @Expose
    private String course_name;
    @SerializedName("name")
    @Expose
    private String courseTitle;
    @SerializedName("url")
    @Expose
    private String contentUrl;

    public SubCourse(String course_name, String courseTitle, String contentUrl) {
        this.course_name = course_name;
        this.courseTitle = courseTitle;
        this.contentUrl = contentUrl;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }
}
