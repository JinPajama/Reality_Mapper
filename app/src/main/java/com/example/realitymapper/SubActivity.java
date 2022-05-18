package com.example.realitymapper;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {

    Button btnJae, btnLibrary, btnGi, btnChung, btnYoung, btnHak, btnSung, btnSin;
    /*순서대로 재림관, 학술정보관, 기념관, 중생관, 영암관, 학생회관, 성결관, 신유관*/
    private List<String> list;
    private ListView listView;
    private EditText editSearch;
    private SearchAdapter adapter;
    private ArrayList<String> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);

        list = new ArrayList<String>();

        settingList();

        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        adapter = new SearchAdapter(list, this);

        listView.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String text = editSearch.getText().toString();
                search(text);
            }
        });


    }

    public void search(String charText) {

        list.clear();

        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        else
        {
            for(int i = 0;i < arraylist.size(); i++)
            {
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    list.add(arraylist.get(i));
                }
            }
        }

        adapter.notifyDataSetChanged();
    }

    private void settingList(){
        list.add("01079143404 강승규");
        list.add("재림과 3층 학생 0315984189");
        list.add("학사관리 031 재림과  2층");
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