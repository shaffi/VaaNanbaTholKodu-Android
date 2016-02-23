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

public class Supportus3 extends Activity {
    private Button button;
    private WebView webview;
    private ImageView imgback;
    private TextView tamil, english;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supportus3);
        addListenerOnButton();
        button = (Button) findViewById(R.id.button1);
        webview = (WebView) findViewById(R.id.webView1);
        tamil = (TextView) findViewById(R.id.textTamil);
        english = (TextView) findViewById(R.id.textEnglish);
        final ImageView imagebook = (ImageView) findViewById(R.id.imageView2);
        ImageView imagefund = (ImageView) findViewById(R.id.imageView1);
        ImageView imagecloth = (ImageView) findViewById(R.id.imageView3);
        ImageView imageanyquery = (ImageView) findViewById(R.id.imageView4);
        final ImageView imageblood = (ImageView) findViewById(R.id.imageView5);
        ImageView imagematerial = (ImageView) findViewById(R.id.imageView6);


        imgback=(ImageView)findViewById(R.id.img_iconhumburger);
        imgback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Intent i;
                // i = new Intent(Joinus1.this, JoinSupport.class);
                i = new Intent(Supportus3.this, Accounts.class);
                startActivity(i);
                //Toast.makeText(Joinus1.this, "shshgshgshgsghs", Toast.LENGTH_LONG).show();
            }


        });

        imagefund.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), FundSupport.class);
                startActivity(i);
            }
        });
        imageblood.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // imageblood.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
                Intent i = new Intent(getApplicationContext(), BloodSupport.class);
                startActivity(i);
            }
        });
        imagebook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(Supportus3.this, "If You Want Give Book Click Iam Support", Toast.LENGTH_LONG).show();
            }
        });
        imagematerial.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(Supportus3.this, "If You Want Give Any Material Click Iam Support", Toast.LENGTH_LONG).show();
            }
        });
        imagecloth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(Supportus3.this, "If You Want Donate Cloths Click Iam Support", Toast.LENGTH_LONG).show();
            }
        });
        imageanyquery.setOnClickListener(new View.OnClickListener() {

                                             @Override
                                             public void onClick (View arg0){
                                                 Toast.makeText(Supportus3.this, "If You Have Any Query Click Iam Support", Toast.LENGTH_LONG).show();
                                             }
                                         }

        );
        tamil.setOnClickListener(new View.OnClickListener()

                                 {

                                     @Override
                                     public void onClick (View v){

                                         // TODO Auto-generated method stub
                                         //DO you work here


                                         tamil.setBackgroundColor(Color.RED);
                                         english.setBackgroundColor(Color.BLACK);


                                     }
                                 }

        );

        english.setOnClickListener(new View.OnClickListener()

                                   {

                                       @Override
                                       public void onClick (View v){

                                           // TODO Auto-generated method stub
                                           //DO you work here


                                           tamil.setBackgroundColor(Color.BLACK);
                                           english.setBackgroundColor(Color.RED);
                                       }
                                   }

        );

    }

    public void addListenerOnButton() {


        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent inBut = new Intent(getApplicationContext(), IamSupport.class);
                startActivity(inBut);
            }

        });
    }

}

