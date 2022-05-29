package com.cookandroid.forthepuppy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ChangePwd extends AppCompatActivity {
    AlertDialog.Builder builder;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);

        builder = new AlertDialog.Builder(this);

        // 비밀번호 변경 확인 버튼 클릭
        findViewById(R.id.btnOk_changePwd).setOnClickListener(new View.OnClickListener() {
            String txt_change = "비밀번호가 변경되었습니다.";
            String txt_cancel = "비밀번호 변경이 취소되었습니다.";

            @Override
            public void onClick(View v) {
                builder.setTitle("비밀번호 변경")
                        .setMessage("비밀번호를 변경하시겠습니까?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ChangePwd.this, txt_change, Toast.LENGTH_SHORT).show();
                                intent = new Intent(ChangePwd.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ChangePwd.this, txt_cancel, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        // 비밀번호 변경 취소 버튼 클릭
        findViewById(R.id.btnCancel_changePwd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ChangePwd.this, FindPwd.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
