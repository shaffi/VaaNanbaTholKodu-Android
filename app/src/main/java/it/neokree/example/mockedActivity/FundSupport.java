package it.neokree.example.mockedActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import it.neokree.example.R;
import it.neokree.example.light.Accounts;

public class FundSupport extends Activity {
    private Button button;
    private WebView webview;
    private ImageView imgback;
    private TextView tamil,english,card,netbanking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fundsupport);
        button  = (Button) findViewById(R.id.button1);
        webview = (WebView) findViewById(R.id.webView1);
        tamil = (TextView) findViewById(R.id.textTamil);
        english = (TextView) findViewById(R.id.textEnglish);
        card = (TextView) findViewById(R.id.textDebitCard);
        netbanking = (TextView) findViewById(R.id.textNetBanking);
        imgback=(ImageView)findViewById(R.id.img_iconhumburger);
        imgback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Intent i;
                // i = new Intent(Joinus1.this, JoinSupport.class);
                i = new Intent(FundSupport.this, Accounts.class);
                startActivity(i);
                //Toast.makeText(Joinus1.this, "shshgshgshgsghs", Toast.LENGTH_LONG).show();
            }


        });
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                Toast.makeText(FundSupport.this, "Please Contact The Above Number", Toast.LENGTH_LONG).show();
            }


        });

        tamil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                //DO you work here


                tamil.setBackgroundColor(Color.RED);
                english.setBackgroundColor(Color.BLACK);


            }
        });

        english.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                //DO you work here

                tamil.setBackgroundColor(Color.BLACK);
                english.setBackgroundColor(Color.RED);
            }
        });
        card.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                //DO you work here


                card.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
                netbanking.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efefef")));


            }
        });

        netbanking.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                //DO you work here

                card.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#efefef")));
                netbanking.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
            }
        });
    }

}
