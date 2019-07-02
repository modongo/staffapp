package com.staff.staffapp.model;

import java.util.ArrayList;

public class SubCourseResponse {
    public ArrayList<SubCourse> subcourselist;

    public ArrayList<SubCourse> getSubcourselist() {
        return subcourselist;
    }

    public SubCourseResponse(ArrayList<SubCourse> subcourselist) {
        this.subcourselist = subcourselist;
    }
}
