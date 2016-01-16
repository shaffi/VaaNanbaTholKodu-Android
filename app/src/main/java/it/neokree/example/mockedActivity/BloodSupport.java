package it.neokree.example.mockedActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import it.neokree.example.MainActivity;
import it.neokree.example.R;
import it.neokree.example.light.Accounts;

public class BloodSupport extends Activity {
    private EditText name,bloodgroup,contactnum,alternatenum,address,address1,address2;
    private WebView webView;
    private Button submit;
    private ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bloodsupport);
        name = (EditText) findViewById(R.id.Name);
        bloodgroup = (EditText) findViewById(R.id.BloodGroup);
        contactnum = (EditText) findViewById(R.id.ContactNumber);
        alternatenum = (EditText) findViewById(R.id.AlternateNumber);
        address = (EditText) findViewById(R.id.Address);
        address1 = (EditText) findViewById(R.id.Address1);
        address2 = (EditText) findViewById(R.id.Address2);
        webView = (WebView) findViewById(R.id.webView1);
        submit=(Button)findViewById(R.id.buttonSubmit);
                submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BloodSupport.this,"saved", Toast.LENGTH_LONG).show();
            }
        });
        imgback=(ImageView)findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Intent i;
                // i = new Intent(Joinus1.this, JoinSupport.class);
                i = new Intent(BloodSupport.this, Supportus3.class);
                startActivity(i);
                //Toast.makeText(Joinus1.this, "shshgshgshgsghs", Toast.LENGTH_LONG).show();
            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
