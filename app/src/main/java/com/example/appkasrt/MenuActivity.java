package com.example.appkasrt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    LinearLayout tombolSatu;
    LinearLayout tombolDua;
    LinearLayout tombolTiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activity);

        View decorView = getWindow().getDecorView();
        {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

            tombolSatu = findViewById(R.id.cdMenu1);
            tombolSatu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            tombolDua = findViewById(R.id.cdMenu2);
            tombolDua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuActivity.this, LaporanActivity.class);
                    startActivity(intent);
                }
            });
            tombolTiga = findViewById(R.id.cdMenu3);
            tombolTiga.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuActivity.this, NotificationActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}



