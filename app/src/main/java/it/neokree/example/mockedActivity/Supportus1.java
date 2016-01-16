package it.neokree.example.mockedActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.ActionBarDrawerToggle;

import it.neokree.example.MainActivity;
import it.neokree.example.R;
import it.neokree.example.light.Accounts;


public class Supportus1 extends Activity {
    private Button button,button1;
    private WebView webview;
    private TextView tamil, english;
    private ImageView imgback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supportus1);
  imgback=(ImageView)findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Intent i;
                // i = new Intent(Joinus1.this, JoinSupport.class);
                i = new Intent(Supportus1.this, Accounts.class);
                startActivity(i);
                //Toast.makeText(Joinus1.this, "shshgshgshgsghs", Toast.LENGTH_LONG).show();
            }


        });//actionBar.setIcon(R.drawable.iconhumburger);
 addListenerOnButton();

        button = (Button) findViewById(R.id.button1);
        webview = (WebView) findViewById(R.id.webView1);
        tamil = (TextView) findViewById(R.id.textTamil);
        english = (TextView) findViewById(R.id.textEnglish);


        tamil.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                //DO you work here


                tamil.setBackgroundColor(Color.RED);
                english.setBackgroundColor(Color.BLACK);


            }
        });

        english.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                //DO you work here

                tamil.setBackgroundColor(Color.BLACK);
                english.setBackgroundColor(Color.RED);
            }
        });

    }



    public void addListenerOnButton() {
        //Select a specific button to bundle it with the action you want

        button = (Button) findViewById(R.id.button_support);
       // button.setOnClickListener((View.OnClickListener) this);
        button.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent inBut = new Intent(getApplicationContext(), Supportus3.class);
                startActivity(inBut);
            }

        });
    }


    public void onBackPressed(){
        Intent intent =new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
    }




