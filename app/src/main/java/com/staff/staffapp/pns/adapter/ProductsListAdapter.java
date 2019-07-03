package com.staff.staffapp.pns.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.staff.staffapp.R;
import com.staff.staffapp.pns.model.Product;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ProductsViewHolder> {

    private List<Product> products;
    private Context mContext;

    public ProductsListAdapter(Context mContext, List<Product> products) {
        this.products = products;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_result_list_item, parent, false);
        ProductsViewHolder viewHolder=new ProductsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        holder.bindProduct(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvTitle) TextView mTvTitle;
        @BindView(R.id.tvDescription) TextView mTvDescription;
        private Context mContext;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext=itemView.getContext();
        }

        public void bindProduct(Product product){
            mTvTitle.setText(product.getTitle());
            mTvDescription.setText(product.getDescription());
        }
    }
}
