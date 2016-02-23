package it.neokree.example.mockedFragments;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import it.neokree.example.R;
import it.neokree.example.mockedActivity.Profile;
import static android.widget.Toast.LENGTH_LONG;
/**
 * Created by siva on 6/1/16.
 */
public class FragmentProfile extends Fragment implements View.OnClickListener {
    private TextView txt_name;
    private  TextView txt_number;
    private TextView txt_altnumber;
    private TextView txt_bg;
    private TextView txt_dl;
    private TextView txt_aboutme;
    private TextView txt_email;
    private TextView txt_fb;
    private TextView txt_twitter;
    private TextView txt_google;
    private TextView txt_knwname;
    private TextView txt_knwnumber;
    private TextView txt_address;
    private ImageView imagecall;
    private ImageView imagechat,imageUser;
    //private TextView txtcallnumber;
    private TextView num;
    public String string;
    public String number;
    String storedUserid;
    //private FragmentProfile context;
    ImageView editicon;
    ImageView previousicon;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.profile,container,false);
        View v = inflater.inflate(R.layout.profile1, container, false);
        //context=this;
        txt_name = (TextView) v.findViewById(R.id.id_name);
        imagecall = (ImageView) v.findViewById(R.id.imageViewCall);
        num=(TextView) v.findViewById(R.id.id_number);
        imagecall.setOnClickListener(this);
        //ImageView imagechat = (ImageView) v.findViewById(R.id.imageViewchat);
        imageUser = (ImageView) v.findViewById(R.id.image_user);
        txt_number = (TextView) v.findViewById(R.id.id_number);
        txt_altnumber = (TextView) v.findViewById(R.id.id_altnumber);
        txt_bg = (TextView) v.findViewById(R.id.id_bloodgroup);
        txt_dl = (TextView) v.findViewById(R.id.id_position);
        txt_aboutme = (TextView) v.findViewById(R.id.txt_about);
        txt_email = (TextView) v.findViewById(R.id.txt_email);
        txt_fb = (TextView) v.findViewById(R.id.txt_facebook);
        txt_twitter = (TextView)v. findViewById(R.id.txt_twitter);
        txt_google = (TextView) v.findViewById(R.id.txt_google);
        txt_knwname = (TextView) v.findViewById(R.id.txt_iknwfrd);
        // txt_knwnumber = (TextView) v.findViewById(R.id.id_fromnumber);
        txt_address = (TextView) v.findViewById(R.id.txt_address);
        //imagecall = (ImageView) v.findViewById(R.id.imageViewCall);
        imagechat = (ImageView)v.findViewById(R.id.imageViewChat);
        imagechat.setOnClickListener(this);
        //editicon = (ImageView) v.findViewById(R.id.img_edit);
        previousicon = (ImageView) v.findViewById(R.id.img_iconhumburger);
        //Toast.makeText(getActivity(),"hai", LENGTH_LONG).show();
        SharedPreferences pref = this.getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        //SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        storedUserid=pref.getString("user_id", null);
        //Toast.makeText(getActivity(),storedUserid, LENGTH_LONG).show();
        new Profileapi().execute();
        return v;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageViewCall:
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num.getText().toString()));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
                break;
            case R.id.imageViewChat:
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body", "default content");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);
                //Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public class Profileapi extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httGet = new HttpGet("https://vaananba.herokuapp.com/api/viewprofile/"+storedUserid);
            HttpResponse resp = null;
            try {
                resp = httpclient.execute(httGet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpEntity entityResponse = resp.getEntity();
            String value = null;
            try {
                value = EntityUtils.toString(entityResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return value;
        }
        @Override
        public void onPostExecute(String result) {

            try {
                JSONObject jsonobject = new JSONObject(result);
                JSONObject object = jsonobject.getJSONObject("data");
                String storedUsername = object.getString("name");
                String storedPhoneNumber = object.getString("mobile");
                String emergency = object.getString("emergency");
                String blood = object.getString("blood");
                String dl = object.getString("proof");
                String about = object.getString("about");
                String email = object.getString("email");
                String social_fb = object.getString("social_fb");
                String social_twitter = object.getString("social_twitter");
                String social_google = object.getString("social_google");
                String know_frnd = object.getString("know_friend");
                // String know_frndno = object.getString("know_friendno");
                String address = object.getString("address");
                String image = object.getString("image");
                //Toast.makeText(getActivity(),storedUsername, LENGTH_LONG).show();
                txt_name.setText(storedUsername);
                txt_number.setText(storedPhoneNumber);
                txt_altnumber.setText("Alt:+91"+emergency);
                txt_bg.setText(blood);
                txt_dl.setText("DL:"+dl);
                txt_aboutme.setText("About Me:"+about);
                txt_email.setText("Email : "+email);
                txt_fb.setText("Facebook : "+social_fb);
                txt_twitter.setText("Twitter : "+social_twitter);
                txt_google.setText("Google Plus : "+social_google);
                txt_knwname.setText("I Know VNTK From : "+know_frnd);
                //txt_knwnumber.setText(know_frndno);
                txt_address.setText("Address : "+address);

                Picasso.with(getActivity()).load(image).into(imageUser);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        @Override
        protected void onPreExecute() {
        }
    }
}
