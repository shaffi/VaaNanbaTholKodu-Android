package it.neokree.example.mockedActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import it.neokree.example.R;
import it.neokree.example.light.Accounts;


public class IamSupport extends ActionBarActivity {
    private ImageView imgback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iamsupport);
        imgback=(ImageView)findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i;
                // i = new Intent(Joinus1.this, JoinSupport.class);
                i = new Intent(IamSupport.this, Supportus3.class);
                startActivity(i);
                //Toast.makeText(Joinus1.this, "shshgshgshgsghs", Toast.LENGTH_LONG).show();
            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}