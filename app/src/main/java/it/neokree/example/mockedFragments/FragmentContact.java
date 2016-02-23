package it.neokree.example.mockedFragments;

//import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
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

import it.neokree.example.Contact;
import it.neokree.example.R;
import it.neokree.example.light.Accounts;
import it.neokree.example.mockedActivity.Joinus1;
import it.neokree.example.mockedActivity.Joinus2;
import it.neokree.example.mockedActivity.Supportus1;
import it.neokree.example.mockedActivity.Supportus3;
import it.neokree.materialnavigationdrawer.elements.Element;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by siva on 5/1/16.
 */
public class FragmentContact extends Fragment implements View.OnClickListener {
    private Context context;
    public EditText name, mobile, email;
    private Button submitB, call2;
    String storedUserid;
    EditText comments;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.contactus,container,false);
        View v = inflater.inflate(R.layout.contactus, container, false);
        context = this.getActivity();

        SharedPreferences pref = this.getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        storedUserid = pref.getString("user_id", null);
        //Toast.makeText(getActivity(), storedUserid, LENGTH_LONG).show();
        comments = (EditText) v.findViewById(R.id.editComment_Feedback);
        name = (EditText) v.findViewById(R.id.editName);
        mobile = (EditText) v.findViewById(R.id.editContactNumber);
        email = (EditText) v.findViewById(R.id.editEmailAddress);
        Button submitB = (Button) v.findViewById(R.id.button1);
        Button call2 = (Button) v.findViewById(R.id.button2);
        submitB.setOnClickListener(this);
        call2.setOnClickListener(this);
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
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                email.setHint("");
            }
        });
        comments.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                comments.setHint("");
            }
        });

        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:

               // Toast.makeText(getActivity(), storedUserid, Toast.LENGTH_SHORT).show();
                Intent intent1=new  Intent(getActivity(), Accounts.class);
                startActivity(intent1);
                new Contactapi().execute();
                break;

            case R.id.button2:

                try {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:+91 9600499994"));
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e("Demo application", "Failed to invoke call", e);
                }
                break;

        }
    }

    class Contactapi extends AsyncTask<String, Void, String> {
        // Toast.makeText(getActivity(), "Entered details are saved", Toast.LENGTH_SHORT).show();

        @Override
        protected String doInBackground(String... params) {

            Contact JSONOBJECT = new Contact();


            JSONOBJECT.setComments(comments.getText().toString());
            JSONOBJECT.setId(storedUserid);
            JSONObject obj = new JSONObject();
            try {
                obj.put("_id", JSONOBJECT.getId());
                obj.put("comments", JSONOBJECT.getComments());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Toast.makeText(this, obj.toString(), Toast.LENGTH_LONG).show();
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httput = new HttpPost("https://vaananba.herokuapp.com/api/contactus");
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

           // Toast.makeText(getActivity(),result,LENGTH_LONG).show();
        }

        @Override
        protected void onPreExecute() {
        }
    }

}