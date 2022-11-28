package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    ImageView imgList, imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Anhxa();


        imgList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imglist = new Intent(Home.this,MainActivity.class);
                startActivity(imglist);
            }
        });
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imgprofile = new Intent(Home.this, Profile.class);
                startActivity(imgprofile);
            }
        });



    }
    private void Anhxa(){
        imgList = (ImageView) findViewById(R.id.imageList);
        imgProfile = (ImageView) findViewById((R.id.imageProfile));
    }

}