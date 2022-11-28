package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText edtuser,edtpassword,edtUserSU, edtPassSU;
    Button btndangnhap, btndangky;
    String ten,mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Anhxa();


        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtuser.getText().length() != 0 && edtpassword.getText().length() !=0){
                    if (edtuser.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)){
                        Toast.makeText(Login.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this,MainActivity.class);
                        startActivity(intent);
                    }else if (edtuser.getText().toString().equals("khanhle") && edtpassword.getText().toString().equals("12345")){
                        Toast.makeText(Login.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this,MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Login.this,"Sai mật khẩu",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Login.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(Login.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_sign_up);

                Window window = dialog.getWindow();
                if (window == null) {
                    return;
                }

                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));

                btndangky = (Button) dialog.findViewById(R.id.buttonSignup);
                edtUserSU = (EditText) dialog.findViewById(R.id.edittextUser);
                edtPassSU = (EditText) dialog.findViewById(R.id.edittextPassword);
                btndangky.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edtUserSU.getText().toString().trim();
                        mk  = edtPassSU.getText().toString().trim();
                        Toast.makeText(Login.this, "", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });


    }
    private void Anhxa(){
        edtuser = (EditText) findViewById(R.id.edittextUser);
        edtpassword = (EditText) findViewById(R.id.edittextPassword);
        btndangnhap = (Button) findViewById(R.id.buttonSignin);
        btndangky = (Button) findViewById((R.id.buttonSignup));
    }
}










