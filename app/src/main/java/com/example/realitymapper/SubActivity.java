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
        list.add("사회과학대학: 중생관 031-467-8098");
        list.add("국제개발협력학과: 중생관 527호 031-467-8049");
        list.add("사회복지학과: 중생관 508호 031-467-8037");
        list.add("행정학과: 중생관 526호 031-467-8098");
        list.add("글로벌경영기술교육연구센터: 중생관 031-467-8136");
        list.add("동아시아물류학부: 중생관 530호 031-467-8121");
        list.add("관광개발학과: 중생관 505호 031-467-8152");
        list.add("경영학과: 중생관 508호 031-467-8056");
        list.add("글로벌물류학부: 중생관 508호 031-467-8121");
        list.add("파이데이아학부: 중생관 410호 031-467-8120, 8029, 8025");
        list.add("다문화평화연구소: 중생관 517호 031-467-8954,8132");
        list.add("기관실: 중생관  031-467-8135");
        list.add("신학대학: 기념관 231호 031-467-8051");
        list.add("신학부: 기념관 231호 031-467-8051");
        list.add("신학과: 기념관 231호 031-467-8051");
        list.add("문화선교학과: 기념관 231호 031-467-8051");
        list.add("예술대학: 기념관 237호 031-467-8015");
        list.add("음악학부: 기념관 235호 031-467-8283");
        list.add("연극영화학부: 기념관 304호 031-467-8912");
        list.add("뷰티디자인학과: 기념관 403호 031-467-8908");
        list.add("공연음악예술학부: 기념관 236호 031-467-8375");
        list.add("기독교교육상담학과: 기념관 231호 031-467-8051");
        list.add("문화선교학과: 기념관 231호 031-467-8051");
        list.add("언어교육원: 기념관 3층 031-467-8242");
        list.add("교수학습지원센터: 기념관 408,9호 031-467-8179");
        list.add("교목실: 기념관 5층 031-467-8202");
        list.add("학생지원과: 학생회관 1층 031-467-8209,8254");
        list.add("학생지원처: 학생회관 1층 031-467-8014");
        list.add("사회봉사센터: 학생회관 1층 031-467-8438");
        list.add("보건진료소: 학생회관 2층 031-467-8386");
        list.add("체육교육과: 학생회관 401,2호 031-467-8290");
        list.add("장애학생지원센터:학생회관 1층 031-467-8377");
        list.add("학생상담센터: 학생회관 2층 031-467-8935");
        list.add("기관실:학생회관 031-467-8135");
        list.add("입학교류처: 재림관 1,8층 031-467-8156");
        list.add("입학과: 재림관 1층 031-467-8288");
        list.add("학사관리과: 재림관 1층  031-467-8380");
        list.add("소비자생활협동조합: 재림관104호 031-467-8465");
        list.add("시설관재과: 재림관 2층 031-467-8119");
        list.add("정보기획과: 재림관 2층 031-467-8225,8294");
        list.add("해외취업지원센터: 재림관 2층 031-467-8418");
        list.add("총무과: 재림관 3층 031-467-8219");
        list.add("사무처: 재림관 3층 031-467-8100");
        list.add("재무회계과: 재림관 3층 031-467-8223");
        list.add("교육혁신센터: 재림관 308호 031-467-8453");
        list.add("기획예산과: 재림관 3층 031-467-8231");
        list.add("국제교류과: 재림관 304호 031-467-8044");
        list.add("평가지원과: 재림관 310호 031-467-8178");
        list.add("평생교육원:  재림관 4층 031-467-8074,8075");
        list.add("대학원교학과: 재림관 505호 031-467-8080~3");
        list.add("창업교육센터: 재림관 6층 031-467-8452");
        list.add("Bi 센터: 재림관 6층 031-467-8293");
        list.add("창업교육센터: 재림관 6층 031-467-8452");
        list.add("융합학부: 재림관 611호  031-467-8096");
        list.add("대학일자리개발처: 재림관 6층 031-467-8190");
        list.add("법인사무국: 재림관 8층 031-467-8003");
        list.add("산업협력단: 재림관 8층 031-467-8289");
        list.add("교무과: 재림관 8층 031-467-8248");
        list.add("미래발전연구원: 재림관 909호 031-467-8350");
        list.add("홍보미디어센터: 재림관 9층 031-467-8998");
        list.add("예비군대대: 재림관 1004호 031-467-8308");
        list.add("총장실: 재림관 8층 031-467-8001");
        list.add("부총장실: 재림관 8층 031-467-8013");
        list.add("기획처: 재림관 8층 031-467-8156");
        list.add("XR센터: 학술정보관 1층 031-467-8298");
        list.add("학술정보관: 학술정보관 6층 031-467-8089");
        list.add("성결대학교회: 신유관 B014호 031-467-8330");
        list.add("기관실: 신유관 031-467-8133");
        list.add("산업경영공학과: 성결관 1층 031-467-8059");
        list.add("정보통신공학과: 성결관 2층 031-467-8073");
        list.add("미디어소프트웨어학과: 성결관 3층 031-467-8348");
        list.add("컴퓨터공학과: 성경관 5층 031-467-8341, 8053");
        list.add("공학교육혁신센터: 성경관 102호 031-467-8243");
        list.add("글로벌경영기술대학: 성경관 106호 031-467-8059");
        list.add("기관실: 성결관 031-476-8135");
        list.add("인문대학: 영암관 104호 031-467-8338");
        list.add("국어국문학과: 영암관 104호 031-467-8946");
        list.add("영어영문학과: 영암관 104호 031-467-8341");
        list.add("중어중문학과: 영암관 104호 031-467-8944");
        list.add("동아시아물류학부: 영암관 104호 031-467-8121");
        list.add("사범대학: 영암관 406호 031-467-8911");
        list.add("유아교육과: 영암관 409호 031-467-8038");
        list.add("다문화평화연구소: 영암관 508호 031-467-8954,8132");
        list.add("기관실: 염암관 031-467-8135");

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