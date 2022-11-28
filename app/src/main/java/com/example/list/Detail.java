package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Detail extends AppCompatActivity {

    TextView txtDetail,txtmoTa;
    ImageView imgHinh,imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Anhxa();

        Intent intent = getIntent();
        String ten = intent.getStringExtra("ten");
        txtDetail.setText(ten);
        String mota = intent.getStringExtra("moTa");
        txtmoTa.setText(mota);
        int hinh = intent.getIntExtra("hinh",1);
        imgHinh.setImageResource(hinh);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Detail.this, MainActivity.class);
                startActivity(back);
            }
        });


    }
    private void Anhxa() {
        txtDetail = (TextView) findViewById(R.id.textViewThucAn);
        txtmoTa = (TextView) findViewById(R.id.textviewMoTa);
        imgHinh= (ImageView) findViewById(R.id.imageviewHinh);
        imgBack = (ImageView) findViewById(R.id.imageviewBack_SU);
    }
}