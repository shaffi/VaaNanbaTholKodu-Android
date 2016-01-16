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
        ImageView imagebook = (ImageView) findViewById(R.id.imageView2);
        ImageView imagefund = (ImageView) findViewById(R.id.imageView1);
        ImageView imagecloth = (ImageView) findViewById(R.id.imageView3);
        ImageView imageanyquery = (ImageView) findViewById(R.id.imageView4);
        final ImageView imageblood = (ImageView) findViewById(R.id.imageView5);
        ImageView imagematerial = (ImageView) findViewById(R.id.imageView6);

        /*GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter1(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // Send intent to SingleViewActivity
                Intent i = new Intent(getApplicationContext(), BloodSupport.class);

                // Pass image index
                i.putExtra("id", position);
                startActivity(i);
            }
        });*/

        /*gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // Send intent to SingleViewActivity
                Intent i1 = new Intent(getApplicationContext(), FundSupport.class);

                // Pass image index
                i1.putExtra("id1", position);
                startActivity(i1);
            }
        });*/
        imgback=(ImageView)findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Intent i;
                // i = new Intent(Joinus1.this, JoinSupport.class);
                i = new Intent(Supportus3.this, Supportus1.class);
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

