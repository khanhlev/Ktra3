package com.example.list;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvThucAn;
    ArrayList<ThucAn> arrayThucAn;
    ThucAnAdapter adapter;
    ImageView imgList, imgProfile, imgHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imgprofile = new Intent(MainActivity.this, Profile.class);
                startActivity(imgprofile);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imghome = new Intent(MainActivity.this, Home.class);
                startActivity(imghome);
            }
        });


        adapter = new ThucAnAdapter(this, R.layout.dong_thuc_an, arrayThucAn);
        lvThucAn.setAdapter(adapter);

        lvThucAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Detail.class);
                ThucAn thucAn = arrayThucAn.get(i);
                intent.putExtra("ten",thucAn.getTen());
                intent.putExtra("moTa",thucAn.getMoTa());
                intent.putExtra("hinh",thucAn.getHinh());
                startActivity(intent);
            }
        });

        lvThucAn.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("B???n c?? mu???n x??a kh??ng");
                builder.setMessage("H??y l???a ch???n b??n d?????i ????? x??c nh???n");
                int vitri = i;
                builder.setPositiveButton("C??", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrayThucAn.remove(vitri);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("kh??ng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                return false;
            }
        });


    }

    private void Anhxa() {
        lvThucAn = (ListView) findViewById(R.id.listviewThucAn);
        arrayThucAn = new ArrayList<>();

        arrayThucAn.add(new ThucAn("Ph??p c???ng", "C???ng 2 s???", R.drawable.add));
        arrayThucAn.add(new ThucAn("Ph??p tr???","Tr??? 2 s???", R.drawable.tru));
        arrayThucAn.add(new ThucAn("Ph??p nh??n","Nh??n 2 s???", R.drawable.nhan));
        arrayThucAn.add(new ThucAn("Ph??p chia", "Chia 2 s???", R.drawable.chia));
        arrayThucAn.add(new ThucAn("Logarit","Logarit", R.drawable.loga));
        arrayThucAn.add(new ThucAn("Ph??p chia l???y nguy??n","Chia l???y nguy??n c???a 2 s???", R.drawable.chiang));
        arrayThucAn.add(new ThucAn("Ph??p chia l???y d??","Chia l???y d?? c???a 2 s???", R.drawable.chiadu));

        imgProfile = (ImageView) findViewById((R.id.imageProfile));
        imgHome = (ImageView) findViewById(R.id.imageHome);
    }
}