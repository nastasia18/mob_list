package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btn, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_book);
        btn.setOnClickListener(this);

        btn2 = findViewById(R.id.btn_serial);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.btn_film);
        btn3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_book:
                Intent intent = new Intent(MainActivity.this, BookActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_serial:
                Intent intent2 = new Intent(MainActivity.this, SerialActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_film:
                Intent intent3 = new Intent(MainActivity.this, FilmActivity.class);
                startActivity(intent3);
                break;
        }
    }
}