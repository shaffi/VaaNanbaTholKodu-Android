package it.neokree.example.mockedActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;


import java.io.IOException;
import java.io.InputStream;

import it.neokree.example.R;

public class JoinSupport extends Activity implements View.OnClickListener{
    public Button joinus, supportus;
    private ActionBar action;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.second);

       // getSupportActionBar().setDisplayShowHomeEnabled(true);

       // getSupportActionBar().setIcon(R.drawable.logo);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
       // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
        joinus = (Button) findViewById(R.id.button1);
        supportus = (Button) findViewById(R.id.button2);
       // joinus.setOnClickListener((View.OnClickListener) this);
       // supportus.setOnClickListener((View.OnClickListener) this);
       // btn_nxt.setOnClickListener((View.OnClickListener)this);



    }

    @Override
    public void onClick(View view) {

    }
}