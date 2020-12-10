package com.example.androidinterview.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.androidinterview.R;
import com.example.androidinterview.activity.FoodDetailActivity;
import com.example.androidinterview.data.DataModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.BitmapTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactHolder> {

    private static final String TAG = "NotesRecyclerAdapter";

    // List to store all the contact details
    private ArrayList<DataModel> dataModels;
    private Context mContext;

    // Counstructor for the Class
    public MyAdapter(ArrayList<DataModel> dataModels, Context context) {
        this.dataModels = dataModels;
        this.mContext = context;
    }

    // This method creates views for the RecyclerView by inflating the layout
    // Into the viewHolders which helps to display the items in the RecyclerView
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.custom_list, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public int getItemCount() {
        return dataModels == null? 0: dataModels.size();
    }

    // This method is called when binding the data to the views being created in RecyclerView
    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, final int position) {
        final DataModel dataModel = dataModels.get(position);

        // Set the data to the views here
        holder.setImageView(dataModel.getImageUrl());
        holder.setCloseLabel(dataModel.getCloseLabel());
        holder.setProductName(dataModel.getProductName());
        holder.setProductDesc(dataModel.getProductDesc());
        holder.setStar(dataModel.getStar());
        holder.setDistance(dataModel.getDistance());
        holder.setPromoDesc(dataModel.getPromoDesc());
        holder.setOutletAround(dataModel.getOutletAround());
        holder.setOutletDesc(dataModel.getOutletDesc());
        holder.setIsClose(dataModel.getIsClose());

        holder.showClose();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, FoodDetailActivity.class);
                intent.putExtra("img", dataModel.getImageUrl());
                intent.putExtra("name", dataModel.getProductName());
                intent.putExtra("desc", dataModel.getProductDesc());
                intent.putExtra("star", dataModel.getStar().toString());
                intent.putExtra("dist", dataModel.getDistance());
                intent.putExtra("promo", dataModel.getPromoDesc());
                intent.putExtra("around", dataModel.getOutletAround());
                intent.putExtra("outDesc", dataModel.getOutletDesc());
                mContext.startActivity(intent);
            }
        });

        // You can set click listners to indvidual items in the viewholder here
        // make sure you pass down the listner or make the Data members of the viewHolder public

    }

    // This is your ViewHolder class that helps to populate data to the view
    public class ContactHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView txt_close;
        private TextView txt_name;
        private TextView txt_desc;
        private TextView txt_rate;
        private TextView txt_distance;
        private TextView txt_promo;
        private TextView txt_around;
        private TextView txt_outletDesc;
        private RelativeLayout ll_label_close;
        public boolean close;

        public ContactHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            txt_close = itemView.findViewById(R.id.txt_close);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_desc = itemView.findViewById(R.id.txt_desc);
            txt_rate = itemView.findViewById(R.id.txt_rate);
            txt_distance = itemView.findViewById(R.id.txt_distance);
            txt_promo = itemView.findViewById(R.id.txt_promo);
            txt_around = itemView.findViewById(R.id.txt_around);
            txt_outletDesc = itemView.findViewById(R.id.txt_outletDesc);
            ll_label_close = itemView.findViewById(R.id.ll_label_close);
        }

        public void setCloseLabel(String label) {
            txt_close.setText(label);
        }

        public void setProductName(String productName) {
            txt_name.setText(productName);
        }

        public void setProductDesc(String desc) {
            txt_desc.setText(desc);
        }

        public void setStar(Double rate) {
            txt_rate.setText(Double.toString(rate));
        }
        public void setDistance(String distance) {
            txt_distance.setText(distance);
        }

        public void setPromoDesc(String promo) {
            txt_promo.setText(promo);
        }

        public void setOutletAround(Integer around) {
            if (around != null){
                txt_around.setText(around.toString() + " " + "家商家在您附近");
            } else {
                txt_around.setVisibility(View.GONE);
            }
        }

        public void setOutletDesc(Integer desc) {
            if (desc != null && desc != 0){
                txt_outletDesc.setText(desc.toString() + " " + "家商家在您附近");
            } else {
                txt_outletDesc.setVisibility(View.GONE);
            }
        }

        public void setIsClose(boolean isClose){
            close = isClose;
        }

        public void showClose(){
            if (close == false){
                ll_label_close.setVisibility(View.GONE);
            } else {
                ll_label_close.setVisibility(View.VISIBLE);
            }
        }

        private void setImageView(String url){
            Glide.with(mContext).load(url)
                    .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(120, 0,RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_LEFT)))
                    .into(imageView);
        }
    }
}
