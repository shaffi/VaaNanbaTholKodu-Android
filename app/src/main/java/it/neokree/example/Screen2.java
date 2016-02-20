package it.neokree.example;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;

import android.graphics.Color;

import android.graphics.drawable.ColorDrawable;

import android.os.Bundle;

import android.support.v4.internal.view.SupportMenu;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;
import android.support.v7.app.ActionBar;

import android.widget.EditText;

import it.neokree.example.mockedActivity.Joinus1;
import it.neokree.example.mockedActivity.Supportus1;

public class Screen2 extends  ActionBarActivity implements OnClickListener {
    public Button joinus, supportus;
    private ActionBar action;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.screen2);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setIcon(R.drawable.logo);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
        joinus = (Button) findViewById(R.id.button1);
        supportus = (Button) findViewById(R.id.button2);
        joinus.setOnClickListener(this);
        supportus.setOnClickListener(this);
    }
    public void onClick(View v){
        switch(v.getId()){
            case  R.id.button1:
                Intent intent = new Intent(Screen2.this, Joinus1.class);
                startActivity(intent);
                break;
            case  R.id.button2:
                Intent intent1 = new Intent(Screen2.this, Supportus1.class);
                startActivity(intent1);
                break;

        }

    }

}
