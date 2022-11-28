package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    ImageView imgBack;
    Button btnSignup;
    EditText edtUserSU, edtPassSU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        AnhXa();

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(SignUp.this, Login.class);
                startActivity(back);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUp.this, "Đăng kí tài khoản thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
    }
    private void AnhXa(){

        imgBack = (ImageView) findViewById(R.id.imageviewBack_SU);
        btnSignup = (Button) findViewById(R.id.buttonSignup);
        edtUserSU = (EditText) findViewById(R.id.edittextTaiKhoan);
        edtPassSU = (EditText) findViewById(R.id.edittextMatKhau);
    }
}









