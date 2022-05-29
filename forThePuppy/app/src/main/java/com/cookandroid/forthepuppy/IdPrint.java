package com.cookandroid.forthepuppy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class IdPrint extends AppCompatActivity {
    Intent intent;
    private TextView etName_idPrintPage, etId_idPrintPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_print);


        // 이름 출력
        etName_idPrintPage = findViewById(R.id.etName_idPrintPage);

        // 아이디 출력
        etId_idPrintPage = findViewById(R.id.etId_idPrintPage);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userName = intent.getStringExtra("userName");

        // home 버튼 클릭 시 메인 화면으로 이동
        findViewById(R.id.btnHome_idPrintPage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdPrint.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}