package com.example.realitymapper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    Button btnJae, btnLibrary, btnGi, btnChung, btnYoung, btnHak, btnSung, btnSin;
    /*순서대로 재림관, 학술정보관, 기념관, 중생관, 영암관, 학생회관, 성결관, 신유관*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        btnJae  = (Button) findViewById(R.id.btnJae);
        btnLibrary = (Button) findViewById(R.id.btnLibrary);
        btnGi   = (Button) findViewById(R.id.btnGi);
        btnChung = (Button) findViewById(R.id.btnChung);
        btnYoung = (Button) findViewById(R.id.btnYoung);
        btnHak  = (Button) findViewById(R.id.btnHak);
        btnSung = (Button) findViewById(R.id.btnSung);
        btnSin  = (Button) findViewById(R.id.btnSin);

        btnJae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        JaeActivity.class);
                startActivity(intent);
            }
        });
        btnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),
                        LibActivity.class);
                startActivity(intent1);
            }
        });
        btnGi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),
                        GiActivity.class);
                startActivity(intent2);
            }
        });
        btnChung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(),
                        ChungActivity.class);
                startActivity(intent3);
            }
        });
        btnYoung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(),
                        YoungActivity.class);
                startActivity(intent4);
            }
        });
        btnHak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(getApplicationContext(),
                        HakSaengActivity.class);
                startActivity(intent5);
            }
        });
        btnSung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(getApplicationContext(),
                        SungActivity.class);
                startActivity(intent6);
            }
        });
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(getApplicationContext(),
                        SinActivity.class);
                startActivity(intent7);
            }
        });
    }
}