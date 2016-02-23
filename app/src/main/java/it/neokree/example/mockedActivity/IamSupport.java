package it.neokree.example.mockedActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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

import it.neokree.example.Communitysupport;
import it.neokree.example.R;
import it.neokree.example.light.Accounts;

/**
 * Created by dowhistle on 16/2/16.
 */
public class IamSupport extends Activity {
    private ImageView imgback;
    private Button btn_support;
    private WebView imageforwebview;
    private EditText name,mobile,address;
    private Spinner time_from,time_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iamsupport);
        addListenerOnButton();
        name = (EditText) findViewById(R.id.editText1);
        mobile = (EditText) findViewById(R.id.editText2);
        time_from = (Spinner) findViewById(R.id.spinner1);
        time_to = (Spinner) findViewById(R.id.spinner3);
         address = (EditText) findViewById(R.id.editText3);
       // WebView imageforwebview=(WebView)findViewById(R.id.webView1);
//        imageforwebview.loadDataWithBaseURL("file:///android_asset/", "<img src='bannernew.jpg' />", "text/html", "utf-8", null);
        //Button btn_support = (Button) findViewById(R.id.btn_iamsupport);
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                name.setHint("");
            }
        });
        mobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                mobile.setHint("");
            }
        });
        address.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                address.setHint("");
            }
        });

        imgback = (ImageView) findViewById(R.id.img_iconhumburger);
        imgback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i;
                // i = new Intent(Joinus1.this, JoinSupport.class);
                i = new Intent(IamSupport.this, Accounts.class);
                startActivity(i);
                //Toast.makeText(Joinus1.this, "shshgshgshgsghs", Toast.LENGTH_LONG).show();
            }


        });

    }
    private class Supportapi extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            Communitysupport JSONOBJECT = new Communitysupport();
            EditText name = (EditText) findViewById(R.id.editText1);
            EditText mobile = (EditText)findViewById(R.id.editText2);
            Spinner time_from = (Spinner)findViewById(R.id.spinner1);
            Spinner time_to = (Spinner) findViewById(R.id.spinner3);
            EditText address = (EditText)findViewById(R.id.editText3);
            JSONOBJECT.setName(name.getText().toString());
            JSONOBJECT.setMobile(mobile.getText().toString());
            //JSONOBJECT.setTimeFrom(time_from.getTime().toString());
            //JSONOBJECT.setTimeTo(time_to.getText().toString());
            JSONOBJECT.setTimeFrom("6AM");
            JSONOBJECT.setTimeTo("12PM");
            JSONOBJECT.setAddress(address.getText().toString());
            JSONOBJECT.setType(name.getText().toString());

            JSONObject obj = new JSONObject();
            try {
                obj.put("name",JSONOBJECT.getName());
                obj.put("mobile",JSONOBJECT.getMobile());
                obj.put("time_from",JSONOBJECT.getTimeFrom());
                obj.put("time_to",JSONOBJECT.getTimeTo());
                obj.put("address",JSONOBJECT.getAddress());
                // obj.put("type",JSONOBJECT.getType());

            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Toast.makeText(this, obj.toString(), Toast.LENGTH_LONG).show();
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httput = new HttpPost("https://vaananba.herokuapp.com/api/supportus");
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
                /*a = resp.getStatusLine().getStatusCode();
                return a;*/
                String responseBody = EntityUtils.toString(resp.getEntity());
                //a = resp.getStatusLine().getStatusCode();
                return responseBody.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            //TextView aa= (TextView)findViewById(R.id.textView7);
            //aa.setText(result);
           // Button submit = (Button) findViewById(R.id.btn_iamsupport);
            //submit.setText(result);
            //Toast.makeText(MainActivity1.this, Integer.toString(result), Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPreExecute() {}
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

    public void addListenerOnButton() {


        btn_support = (Button) findViewById(R.id.btn_iamsupport);
        btn_support.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
               // Intent inBut = new Intent(getApplicationContext(),Accounts.class);
               // startActivity(inBut);
                Toast.makeText(IamSupport.this, "Thanks for your Support", Toast.LENGTH_LONG).show();
                new Supportapi().execute();
            }

        });
    }
}
