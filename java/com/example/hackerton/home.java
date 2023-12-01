package com.example.hackerton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {
    Button btnLogin;
    Button btnSignup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        //로그인 버튼
        btnLogin = findViewById(R.id.btnLogin);

        //로그인 버튼 클릭시, 로그인 페이지로 이동
        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, home.class);
            startActivity(intent);
        });

        //회원가입 버튼
        btnSignup = findViewById(R.id.btnSignup);

        //회원가입 버튼 클릭시, 회원가입 페이지로 이동
        btnSignup.setOnClickListener(v -> {
            Intent intent = new Intent(this, signup.class);
            startActivity(intent);
        });
    }

}
