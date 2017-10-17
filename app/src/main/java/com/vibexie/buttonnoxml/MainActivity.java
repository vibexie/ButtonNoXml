package com.vibexie.buttonnoxml;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.vibexie.buttonnoxml.library.ButtonNoXml;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        Drawable drawable1 = new ButtonNoXml.Builder(this)
                .unpressedColor("#445da4")
                .pressedColor("#888888")
                .build();

        button1.setBackgroundDrawable(drawable1);

        Button button2 = (Button) findViewById(R.id.button2);
        Drawable drawable2 = new ButtonNoXml.Builder(this)
                .unpressedColor("#445da4")
                .pressedColor("#888888")
                .radius(10)
                .build();

        button2.setBackgroundDrawable(drawable2);

        Button button3 = (Button) findViewById(R.id.button3);
        Drawable drawable3 = new ButtonNoXml.Builder(this)
                .unpressedColor("#445da4")
                .pressedColor("#888888")
                .semicircle(true)
                .build();

        button3.setBackgroundDrawable(drawable3);

        Button button4 = (Button) findViewById(R.id.button4);
        Drawable drawable4 = new ButtonNoXml.Builder(this)
                .unpressedColor("#ffffff")
                .pressedColor("#888888")
                .semicircle(true)
                .strokeWidth(2)
                .strokeColor("#ff0000")
                .build();

        button4.setBackgroundDrawable(drawable4);
    }
}