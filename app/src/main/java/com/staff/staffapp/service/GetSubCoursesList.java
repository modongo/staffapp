package com.staff.staffapp.service;

import com.staff.staffapp.model.SubCourse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSubCoursesList {

      @GET("subcoursesApi")
    Call<List<SubCourse>>getAllTitles();
}
