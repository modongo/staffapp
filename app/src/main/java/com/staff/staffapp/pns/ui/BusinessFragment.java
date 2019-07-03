package com.staff.staffapp.pns.ui;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;

import com.staff.staffapp.R;
import com.staff.staffapp.pns.adapter.ExpandableListAdapterProducts;
import com.staff.staffapp.pns.model.Product;
import com.staff.staffapp.pns.service.ProductsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class BusinessFragment extends Fragment {

    View view;
    private ExpandableListAdapterProducts listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;
    private List<Product> products;
    private List<String> listDescription;
    private ExpandableListView listView;
    private FragmentActivity listener;
    private ProgressBar progressBar;

    public BusinessFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.listener = (FragmentActivity) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_business, container, false);
        progressBar=view.findViewById(R.id.pBar);
        listView=view.findViewById(R.id.lvExpandableBusiness);
        getProducts();
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    private void getProducts(){
    final ProductsService productsService=new ProductsService();
    productsService.getBusinessProducts(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            progressBar.setVisibility(view.VISIBLE);
            products=new ArrayList<>();
            products = productsService.processResaults(response);
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    listDataHeader=new ArrayList<>();
                    listHash=new HashMap<>();
                    listDescription=new ArrayList<>();

                    for(Product product: products){
                        listDataHeader.add(product.getTitle());
                        listDescription.add(product.getDescription());
                        listHash.put(product.getTitle(),listDescription);
                        listDescription=new ArrayList<>();
                    }
                    listAdapter=new ExpandableListAdapterProducts(getContext(),listDataHeader,listHash);
                    listView.setAdapter(listAdapter);
                    progressBar.setVisibility(view.GONE);
                }
            });

        }
        });
    }
}
