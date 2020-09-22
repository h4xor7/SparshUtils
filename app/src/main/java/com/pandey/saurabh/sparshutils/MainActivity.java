package com.pandey.saurabh.sparshutils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pandey.saurabh.sparshlibrary.ToasterMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToasterMessage.s(this,"hello");
    }
}