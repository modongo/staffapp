package com.staff.staffapp.pns.service;

import android.util.Log;

import com.staff.staffapp.Constants;
import com.staff.staffapp.pns.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProductsService {
    public static void getBusinessProducts(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BUSINESS_PRODUCTS_URL).newBuilder();

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void getPersonalProducts(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.PERSONAL_PRODUCTS_URL).newBuilder();

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Product> processResaults(Response response) {
        ArrayList<Product> products = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONArray productsArrayJSON = new JSONArray(jsonData);

            if (response.isSuccessful()) {
                for (int i = 0; i < productsArrayJSON.length(); i++) {
                    JSONObject productJSON = productsArrayJSON.getJSONObject(i);
                    int id = productJSON.getInt("id");
                    String title = productJSON.getString("name");
                    String description = productJSON.getString("information");
                    Log.d("Serv View", title);
                    Product product = new Product(id, title, description);
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return products;
    }
}
