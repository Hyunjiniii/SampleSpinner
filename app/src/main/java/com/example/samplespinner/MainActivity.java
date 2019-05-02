package com.example.samplespinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Spinner spinner;
    private String[] items = {"mike", "angel", "crow", "john", "ginnie", "sally", "cohen", "rice"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);

        // 문자열로만 구성된 아이템을 스피너로 보여줄 때 사용되는 코드
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items );  // 문자열을 아이템으로 보여주는 레이아웃 사용
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  // 스피너의 아이템들을 보여줄 뷰에 사용되는 레이아웃지정

        spinner.setAdapter(adapter);

        // 아이템 선택 이벤트
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // 아이템이 선택되었을 때 호출
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                textView.setText(items[position]);
            }

            // 아무것도 선택되지 않았을 때 호출
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textView.setText("");
            }
        });
    }
}
