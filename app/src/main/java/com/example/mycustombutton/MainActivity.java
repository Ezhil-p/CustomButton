package com.example.mycustombutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Circle circle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circle=(Circle)findViewById(R.id.c1);

    }

    public void changeCircleSettings(View view) {
        circle.changeCircleSettings();
    }
}
