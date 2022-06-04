package com.example.realitymapper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class inprot extends AppCompatActivity implements View.OnClickListener {

    // 디자인 변수 선언
    Button btnSave;
    Button btnSelect;

    EditText edtName;
    EditText edtAge;
    EditText edtAddr;
    TextView viewResult;

    // DBHelper
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 디자인 매핑
        setContentView(R.layout.activity_main);

        // Control 매핑
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        edtName = (EditText) findViewById(R.id.edtName);
        viewResult = (TextView) findViewById(R.id.txtResult);

        // 버튼 클릭 이벤트 정의
        btnSave.setOnClickListener(this);
        btnSelect.setOnClickListener(this);

        dbHelper = new DBHelper(inprot.this, 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                dbHelper.insert(edtName.getText().toString(), Integer.parseInt(edtAge.getText().toString()), edtAddr.getText().toString());
                break;
            case R.id.btnSelect:
                viewResult.setText(dbHelper.getResult());
                break;
        }
    }
}