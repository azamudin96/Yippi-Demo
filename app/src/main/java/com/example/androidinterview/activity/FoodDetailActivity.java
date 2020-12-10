package com.example.androidinterview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androidinterview.R;

public class FoodDetailActivity extends AppCompatActivity {

    private ImageView toolbar_image , backButton;
    private TextView productName,productDesc,txt_rate,txt_distance,txt_promo,txt_around,txt_outletDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        toolbar_image = findViewById(R.id.toolbar_image);
        productName = findViewById(R.id.productName);
        productDesc = findViewById(R.id.productDesc);
        txt_rate = findViewById(R.id.txt_rate);
        txt_distance = findViewById(R.id.txt_distance);
        txt_promo = findViewById(R.id.txt_promo);
        txt_around = findViewById(R.id.txt_around);
        txt_outletDesc = findViewById(R.id.txt_outletDesc);
        backButton = findViewById(R.id.backButton);

        txt_around.setVisibility(View.GONE);
        txt_outletDesc.setVisibility(View.GONE);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getIntentValue();
    }

    private void getIntentValue(){
        String img = getIntent().getStringExtra("img");
        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("desc");
        String star = getIntent().getStringExtra("star");
        String dist = getIntent().getStringExtra("dist");
        String promo = getIntent().getStringExtra("promo");
        int around = getIntent().getIntExtra("around", 0);
        int outDesc = getIntent().getIntExtra("outDesc" , 0);

        Log.e("TAG" , "tssss" + around);
        Log.e("TAG" , "tssss1" + outDesc);

        Glide.with(this).load(img).into(toolbar_image);
        productName.setText(name);
        productDesc.setText(desc);
        txt_rate.setText(star);
        txt_distance.setText(dist);
        txt_promo.setText(promo);

        if (around != 0){
            txt_around.setText("" + around + " 家商家在您附近");
            txt_around.setVisibility(View.VISIBLE);
        }

        if (outDesc != 0){
            txt_outletDesc.setVisibility(View.VISIBLE);
            txt_outletDesc.setText("" + outDesc + " 家商家在您附近");
        }
    }
}