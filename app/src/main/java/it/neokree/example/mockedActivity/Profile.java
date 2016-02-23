package it.neokree.example.mockedActivity;




        import android.app.Activity;
        import android.content.ActivityNotFoundException;
        import android.content.Context;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.squareup.picasso.Picasso;

        import org.apache.http.HttpEntity;
        import org.apache.http.HttpResponse;
        import org.apache.http.client.methods.HttpGet;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.util.EntityUtils;
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.IOException;

        import it.neokree.example.R;
        import it.neokree.example.light.Accounts;

public class Profile extends Activity implements View.OnClickListener {
    private ImageView editicon,previousicon;
    private ImageView imagecall, imagechat,imageuser,imageback;
    private Context context;
    public String string;
    public String number;
    private ProgressBar progressBar;
    private TextView txt_name,txt_number,txt_altnumber,txt_bg,txt_dl,txt_aboutme,txt_email,txt_fb,txt_twitter,txt_google,txt_knwname,txt_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        txt_name = (TextView) findViewById(R.id.id_name);
        txt_number = (TextView) findViewById(R.id.id_number);
        txt_altnumber = (TextView) findViewById(R.id.id_altnumber);
        txt_bg = (TextView) findViewById(R.id.id_bloodgroup);
        txt_dl = (TextView) findViewById(R.id.id_position);
        txt_aboutme = (TextView) findViewById(R.id.txt_about);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_fb = (TextView) findViewById(R.id.txt_facebook);
        txt_twitter = (TextView) findViewById(R.id.txt_twitter);
        txt_google = (TextView) findViewById(R.id.txt_google);
        txt_knwname = (TextView) findViewById(R.id.txt_iknwfrd);
        txt_address = (TextView) findViewById(R.id.txt_address);
        imagecall = (ImageView) findViewById(R.id.imageViewCall);
        imagechat = (ImageView) findViewById(R.id.imageViewChat);
        imageuser = (ImageView) findViewById(R.id.image_user);
        //editicon = (ImageView) findViewById(R.id.img_edit);
        progressBar = (ProgressBar)findViewById(R.id.progressBar_profile);
        previousicon = (ImageView) findViewById(R.id.img_iconhumburger);

        new Profileapi().execute();

        imagecall.setOnClickListener(this);
        imagechat.setOnClickListener(this);

       ImageView imgback=(ImageView)findViewById(R.id.img_iconhumburger);
        imgback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Intent i;
                i = new Intent(Profile.this,Accounts.class);
                startActivity(i);

            }


        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageViewCall:
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + txt_number.getText().toString()));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);


                break;

            case R.id.imageViewChat:
                //Toast.makeText(Profile.this, "Button Clicked", Toast.LENGTH_SHORT).show();
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body", "default content");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);
                break;

        }
    }
    class Profileapi extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            final String user_id = getIntent().getStringExtra("_id");
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httGet = new HttpGet("https://vaananba.herokuapp.com/api/viewprofile/"+user_id);
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
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.GONE);


             txt_name = (TextView) findViewById(R.id.id_name);
             txt_number = (TextView) findViewById(R.id.id_number);
           txt_altnumber = (TextView) findViewById(R.id.id_altnumber);
             txt_bg = (TextView) findViewById(R.id.id_bloodgroup);
            txt_dl = (TextView) findViewById(R.id.id_position);
             txt_aboutme = (TextView) findViewById(R.id.txt_about);
            txt_email = (TextView) findViewById(R.id.txt_email);
             txt_fb = (TextView) findViewById(R.id.txt_facebook);
            txt_twitter = (TextView) findViewById(R.id.txt_twitter);
             txt_google = (TextView) findViewById(R.id.txt_google);
           txt_knwname = (TextView) findViewById(R.id.txt_iknwfrd);
            //TextView txt_knwnumber = (TextView) findViewById(R.id.id_fromnumber);
           txt_address = (TextView) findViewById(R.id.txt_address);
            imageuser = (ImageView) findViewById(R.id.image_user);
            imagecall = (ImageView) findViewById(R.id.imageViewCall);
            imagechat = (ImageView) findViewById(R.id.imageViewChat);
            //editicon = (ImageView) findViewById(R.id.img_edit);
            previousicon = (ImageView) findViewById(R.id.img_iconhumburger);

            try {
                JSONObject jsonobject = new JSONObject(result);
                JSONObject object = jsonobject.getJSONObject("data");

                String name = object.getString("name");
                String number = object.getString("mobile");
                String emergency = object.getString("emergency");
                String blood = object.getString("blood");
                String dl = object.getString("proof");
                String about = object.getString("about");
                String email = object.getString("email");
                String social_fb = object.getString("social_fb");
                String social_twitter = object.getString("social_twitter");
                String social_google = object.getString("social_google");
                String know_frnd = object.getString("know_friend");
                String know_frndno = object.getString("know_friendno");
                String address = object.getString("address");
                String image = object.getString("image");


                txt_name.setText(name);
                txt_number.setText(number);
                txt_altnumber.setText("Alt:"+emergency);
                txt_bg.setText(blood);
                txt_dl.setText("DL:"+dl);
                txt_aboutme.setText("About Me : "+about);
                txt_email.setText("Email:"+email);
                txt_fb.setText("Facebook:"+social_fb);
                txt_twitter.setText("Twitter:"+social_twitter);
                txt_google.setText("Google Plus:"+social_google);
                txt_knwname.setText("I Know VNKT From:"+know_frnd);
                //txt_knwnumber.setText(know_frndno);
                txt_address.setText("Address:"+address);

                Picasso.with(context)
                        .load(image)
                        .into(imageuser);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPreExecute() {

            progressBar.setVisibility(View.VISIBLE);

        }
    }
}
