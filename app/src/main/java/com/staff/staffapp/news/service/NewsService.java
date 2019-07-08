package com.staff.staffapp.news.service;

import com.staff.staffapp.news.model.GeneralNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {

    @GET("api/news")
    Call<List<GeneralNews>> getAllGeneralNews();
}