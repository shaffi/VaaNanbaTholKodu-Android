package it.neokree.example.mockedActivity;

/**
 * Created by siva on 6/1/16.
 */
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import it.neokree.example.R;

public class Aboutus extends Activity {
    private TextView tamil,english;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        TextView vieww = (TextView)findViewById(R.id.textView);
        ImageView vi = (ImageView)findViewById(R.id.imageView2);
        tamil = (TextView) findViewById(R.id.textTamil);
        english = (TextView) findViewById(R.id.textEnglish);

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

                english.setBackgroundColor(Color.RED);
                tamil.setBackgroundColor(Color.BLACK);
            }
        });
        //li.setOnClickListener();
        WebView browser = (WebView) findViewById(R.id.webView);
        //browser.loadUrl("http://www.google.com");

        //setContentView(webview);
        //webview.loadUrl("https://www.facebook.com");
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }


}
