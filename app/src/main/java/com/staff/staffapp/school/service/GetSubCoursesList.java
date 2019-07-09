package com.staff.staffapp.school.service;

import com.staff.staffapp.school.model.SubCourse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSubCoursesList {
      @GET("subcoursesApi")
    Call<List<SubCourse>>getAllTitles();
}
