package com.staff.staffapp.news.model;

import com.google.gson.annotations.SerializedName;

public class GeneralNews {

    private int id;
    private int department_id;

    @SerializedName("description")
    private String generalNews_deadlines;

    public int getId() {
        return id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public String getGeneralNews_Headlines() {
        return generalNews_deadlines;
    }
}
