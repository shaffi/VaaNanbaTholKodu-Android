package it.neokree.example.mockedActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import it.neokree.example.MainActivity;
import it.neokree.example.R;
import it.neokree.example.Supportbloodjson;
import it.neokree.example.light.Accounts;

public class BloodSupport extends Activity {
    private EditText name,blood,mobile,altnum,address,address1,address2;
    private WebView webView;
    private Button submit;
    private ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bloodsupport);
        name = (EditText) findViewById(R.id.Name);
        blood = (EditText) findViewById(R.id.BloodGroup);
        mobile = (EditText) findViewById(R.id.ContactNumber);
        altnum = (EditText) findViewById(R.id.AlternateNumber);
        address = (EditText) findViewById(R.id.Address);
        address1 = (EditText) findViewById(R.id.Address1);
        address2 = (EditText) findViewById(R.id.Address2);
        webView = (WebView) findViewById(R.id.webView1);
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                name.setHint("");
            }
        });
        blood.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                blood.setHint("");
            }
        });
        mobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                mobile.setHint("");
            }
        });
        altnum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                altnum.setHint("");
            }
        });
        address.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                address.setHint("");
            }
        });
        address1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                address1.setHint("");
            }
        });
        address2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                address2.setHint("");
            }
        });

        submit=(Button)findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(BloodSupport.this,"saved", Toast.LENGTH_LONG).show();
                Log.v("EditText", name.getText().toString());
                new Supportbloodapi().execute();
            }
        });
        imgback=(ImageView)findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i;
                // i = new Intent(Joinus1.this, JoinSupport.class);
                i = new Intent(BloodSupport.this, Supportus3.class);
                startActivity(i);
                //Toast.makeText(Joinus1.this, "shshgshgshgsghs", Toast.LENGTH_LONG).show();
            }


        });

    }
    class Supportbloodapi extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            Supportbloodjson JSONOBJECT = new Supportbloodjson();
            final  EditText  name = (EditText) findViewById(R.id.Name);
            EditText blood = (EditText) findViewById(R.id.BloodGroup);
            EditText mobile = (EditText) findViewById(R.id.ContactNumber);
            EditText altnum = (EditText) findViewById(R.id.AlternateNumber);
            EditText address = (EditText) findViewById(R.id.Address);
            JSONOBJECT.setName(name.getText().toString());
            JSONOBJECT.setBlood(blood.getText().toString());
            JSONOBJECT.setMobile(mobile.getText().toString());
            JSONOBJECT.setAltnum(altnum.getText().toString());
            JSONOBJECT.setAddress(address.getText().toString());
            JSONObject obj = new JSONObject();
            try {

                obj.put("name",JSONOBJECT.getName());
                obj.put("mobile",JSONOBJECT.getMobile());
                obj.put("altnum",JSONOBJECT.getAltnum());
                obj.put("blood",JSONOBJECT.getBlood());
                obj.put("address",JSONOBJECT.getAddress());
                obj.put("type",JSONOBJECT.getType());

            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Toast.makeText(this, obj.toString(), Toast.LENGTH_LONG).show();
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httput = new HttpPost("https://vaananba.herokuapp.com/api/supportblood");
            StringEntity se = null;
            try {
                se = new StringEntity(obj.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            httput.setEntity(se);
            httput.setHeader("content-type", "application/json");
            int a = 0;
            try {
                HttpResponse resp = httpclient.execute(httput);
                String responseBody = EntityUtils.toString(resp.getEntity());
                //a = resp.getStatusLine().getStatusCode();
                return responseBody.toString();
                /*a = resp.getStatusLine().getStatusCode();
                return a;
*/
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            submit=(Button)findViewById(R.id.buttonSubmit);
            submit.setText(result);
            //Toast.makeText(MainActivity1.this, Integer.toString(result), Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPreExecute() {}
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
