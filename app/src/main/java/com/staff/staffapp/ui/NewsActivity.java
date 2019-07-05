package com.staff.staffapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.staff.staffapp.model.GeneralNews;
import com.staff.staffapp.service.NewsService;
import com.staff.staffapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsActivity extends AppCompatActivity implements View.OnClickListener {

    //    @BindView(R.id.newsListView) ListView mNewsList;
//    @BindView(R.id.generalNewsButton) Button mgeneralNewsButton;
    @BindView(R.id.allGeneralNews)
    TextView mAllGeneralNews;
    @BindView(R.id.departmentNewsButton)
    Button mDepartmentNewsButton;

    private TextView textViewGeneralNewsResults;

    private String[] news = new String[]{"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        mDepartmentNewsButton.setOnClickListener(this);

        textViewGeneralNewsResults = findViewById(R.id.allGeneralNews);

//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, news);
//        mNewsList.setAdapter(adapter);
//
//        mNewsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(NewsActivity.this, NewsDetailsActivity.class);
//                startActivity(intent);
//            }
//        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apisafapp.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final NewsService generalNewsService = retrofit.create(NewsService.class);

        Call<List<GeneralNews>> create_GeneralNews_Call = generalNewsService.getAllGeneralNews();

        create_GeneralNews_Call.enqueue(new Callback<List<GeneralNews>>() {
            @Override
            public void onResponse(Call<List<GeneralNews>> call, Response<List<GeneralNews>> response) {

                if (!response.isSuccessful()) {
                    textViewGeneralNewsResults.setText("Code: " + response.code());
                    return;
                }

                List<GeneralNews> generalNewsList = response.body();

                for (GeneralNews generalNews : generalNewsList) {
                    String generalNewsContent = "";
//                    generalNewsContent += "id: " + generalNews.getId() + "\n";
//                    generalNewsContent += "department_id " + generalNews.getDepartment_id() + "\n";
                    generalNewsContent += "description " + generalNews.getGeneralNews_Headlines() + "\n\n";

                    textViewGeneralNewsResults.append(generalNewsContent);
                }

            }

            @Override
            public void onFailure(Call<List<GeneralNews>> call, Throwable throwable) {
                textViewGeneralNewsResults.setText(throwable.getMessage());

            }
        });


    }

    @Override
    public void onClick(View view) {
        if (view == mDepartmentNewsButton) {
            Intent intent = new Intent(NewsActivity.this, DepartmentNewsActivity.class);
            startActivity(intent);
        }

    }

}
