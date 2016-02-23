package it.neokree.example.mockedActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
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
import it.neokree.example.Communityjson;
import it.neokree.example.MainActivity;
import it.neokree.example.R;
import it.neokree.example.light.Accounts;
//import it.neokree.example.mockedFragments.FragmentButton;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;
public class Joinus3 extends Activity implements View.OnClickListener {
    private ImageView imgback;
    private Context context;
    private LinearLayout  linear,linearsocial,linearother;
    private  EditText edt_frdname,edt_frdnumber,edt_address,edt_address2,edt_address3,edt_address4;
    private RadioButton rb_fb,rb_twitter,rb_gogle,rb_event,rb_newspaper, rb_adver,rb_fmmfrend, rb_fmmysocial,rb_other ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinus3);
        context = this.getApplicationContext();
        //EditText know_friend= (EditText) findViewById(R.id.step_c_entername);
        rb_fmmfrend = (RadioButton) findViewById(R.id.radio_FromMyfriend);
        rb_fmmysocial = (RadioButton) findViewById(R.id.radio_FromSocialNetwork);
        rb_other = (RadioButton) findViewById(R.id.radio_Others);
        edt_frdname = (EditText) findViewById(R.id.edt_friendname);
        edt_address = (EditText) findViewById(R.id.step_c_etxt_address1);
        edt_address2 = (EditText) findViewById(R.id.step_c_etxt_address2);
        edt_address3 = (EditText) findViewById(R.id.step_c_etxt_address3);
        edt_address4 = (EditText) findViewById(R.id.step_c_etxt_address4);
        edt_frdnumber = (EditText) findViewById(R.id.edt_frientnumber);
        rb_fb = (RadioButton) findViewById(R.id.rb_fromFacebook);
        rb_twitter = (RadioButton) findViewById(R.id.rb_fromTwitter);
        rb_gogle = (RadioButton) findViewById(R.id.rb_fromGoogleplus);
        rb_event = (RadioButton) findViewById(R.id.rb_fromEvents);
        rb_newspaper = (RadioButton) findViewById(R.id.rb_fromNewsPaper);
        rb_adver = (RadioButton) findViewById(R.id.rb_fromAdvertistment);
        linear =(LinearLayout)findViewById(R.id.layout_fromfrd);
        linearsocial = (LinearLayout)findViewById(R.id.layout_fromsocialnetwork);
        linearother = (LinearLayout)findViewById(R.id.layout_fromother);
        //final RelativeLayout relative_fromsocial = (RelativeLayout) findViewById(R.id.relative_radiobutton);
        edt_frdname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                edt_frdname.setHint("");
            }
        });
        edt_frdnumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                edt_frdnumber.setHint("");
            }
        });
        edt_address.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                edt_address.setHint("");
            }
        });
        edt_address2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                edt_address2.setHint("");
            }
        });
        edt_address3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                edt_address3.setHint("");
            }
        });
        edt_address4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                edt_address4.setHint("");
            }
        });
        rb_fmmfrend.setOnClickListener(this);
        rb_fmmysocial.setOnClickListener(this);
        rb_other.setOnClickListener(this);
        Button btn_nxt = (Button) findViewById(R.id.stepc_updateprofile);
        btn_nxt.setOnClickListener(this);
        btn_nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Joinus3.this,know_friend.getText().toString(),Toast.LENGTH_LONG).show();
                new Userapi().execute();
                Intent myIntent = new Intent(context, it.neokree.example.mockedActivity.MainActivity.class);
                startActivity(myIntent);
            }
        });
        rb_fmmfrend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //search.setVisibility();
                if (rb_fmmfrend.getVisibility() == VISIBLE) {
                    linear.setVisibility(VISIBLE);
                    linearsocial.setVisibility(GONE);
                    linearother.setVisibility(GONE);
                }
            }
        });
        rb_fmmysocial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //search.setVisibility();
                if ( rb_fmmysocial.getVisibility() == VISIBLE) {
                    //txt_mem.setVisibility(GONE);
                    //search.setVisibility(GONE);
                    linear.setVisibility(GONE);
                    linearsocial.setVisibility(VISIBLE);
                    linearother.setVisibility(GONE);
                }
            }
        });
        rb_other.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //search.setVisibility();
                if ( rb_other.getVisibility() == VISIBLE) {
                    //txt_mem.setVisibility(GONE);
                    //search.setVisibility(GONE);
                    linear.setVisibility(GONE);
                    linearsocial.setVisibility(GONE);
                    linearother.setVisibility(VISIBLE);
                }
            }
        });
        imgback = (ImageView) findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i;
                i = new Intent(Joinus3.this, Joinus2.class);
                startActivity(i);
            }
        });
    }
    class Userapi extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... params) {
            Communityjson JSONOBJECT = new Communityjson();
            // Joinus3 a = new Joinus3();
            // String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
            /*Bitmap bm = BitmapFactory.decodeFile("/path/to/image.jpg");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
            byte[] b = baos.toByteArray();
*/
            JSONOBJECT.setName(getIntent().getStringExtra("name"));
            JSONOBJECT.setMobile(getIntent().getStringExtra("mobile"));
            JSONOBJECT.setEmergency(getIntent().getStringExtra("emergency"));
            JSONOBJECT.setDob(getIntent().getStringExtra("day") + "/" + getIntent().getStringExtra("month") + "/" + getIntent().getStringExtra("year"));
            JSONOBJECT.setEmail(getIntent().getStringExtra("email"));
            JSONOBJECT.setAbout(getIntent().getStringExtra("about"));
            JSONOBJECT.setProof(getIntent().getStringExtra("proof"));
            JSONOBJECT.setBlood(getIntent().getStringExtra("blood"));
            JSONOBJECT.setImage(getIntent().getStringExtra("encoded"));
            JSONOBJECT.setImagetype("image/jpg");
            EditText know_friend= (EditText) findViewById(R.id.edt_friendname);
            final EditText know_friend_no = (EditText) findViewById(R.id.edt_frientnumber);
            final EditText address = (EditText) findViewById(R.id.step_c_etxt_address1);
            JSONOBJECT.setKnowFriend(know_friend.getText().toString());
            JSONOBJECT.setKnowFriendno(know_friend_no.getText().toString());
            JSONOBJECT.setKnowSocial("no");
            JSONOBJECT.setKnowOthers("no");
            JSONOBJECT.setAddress(address.getText().toString());
            JSONOBJECT.setSocialFb(getIntent().getStringExtra("social_fb"));
            JSONOBJECT.setSocialTwitter(getIntent().getStringExtra("social_twitter"));
            JSONOBJECT.setSocialGoogle(getIntent().getStringExtra("social_google"));
            JSONOBJECT.setComments("testing");
            JSONObject obj = new JSONObject();
            try {
                obj.put("name", JSONOBJECT.getName());
                obj.put("mobile", JSONOBJECT.getMobile());
                obj.put("emergency", JSONOBJECT.getEmergency());
                obj.put("dob", JSONOBJECT.getDob());
                obj.put("email", JSONOBJECT.getEmail());
                obj.put("about", JSONOBJECT.getAbout());
                obj.put("proof", JSONOBJECT.getProof());
                obj.put("blood", JSONOBJECT.getBlood());
                obj.put("image", JSONOBJECT.getImage());
                obj.put("imagetype", JSONOBJECT.getImagetype());
                obj.put("know_friend", JSONOBJECT.getKnowFriend());
                obj.put("know_friendno", JSONOBJECT.getKnowFriendno());
                obj.put("know_social", JSONOBJECT.getKnowSocial());
                obj.put("know_others", JSONOBJECT.getKnowOthers());
                obj.put("address", JSONOBJECT.getAddress());
                obj.put("social_fb", JSONOBJECT.getSocialFb());
                obj.put("social_twitter", JSONOBJECT.getSocialTwitter());
                obj.put("social_google", JSONOBJECT.getSocialGoogle());
                obj.put("comments", JSONOBJECT.getComments());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Toast.makeText(this, obj.toString(), Toast.LENGTH_LONG).show();
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httput = new HttpPost("https://vaananba.herokuapp.com/api/user");
            StringEntity se = null;
            try {
                se = new StringEntity(obj.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            httput.setEntity(se);
            httput.setHeader("content-type", "application/json");
            int a ;
            int responseCode=0;
            try {
                HttpResponse resp = httpclient.execute(httput);
                //responseCode = resp.getStatusLine().getStatusCode();
                String responseBody = EntityUtils.toString(resp.getEntity());
                return responseBody.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
            //return responseCode;
        }
        @Override
        protected void onPostExecute(String result) {
            JSONObject jsonobject = null;
            //TextView aa = (TextView) findViewById(R.id.textView6);
            try {
                jsonobject = new JSONObject(result);
                JSONObject object = jsonobject.getJSONObject("data");
                String name = object.getString("name");
                String id = object.getString("_id");
                //aa.setText(id);
                //Toast.makeText(Joinus3.this,id,Toast.LENGTH_LONG).show();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putString("user_id",id);
                //editor.putString("user_image",userImage);
                editor.commit();
            } catch (JSONException e) {
                e.printStackTrace();
            }
             //Toast.makeText(Joinus3.this,result.toString(),Toast.LENGTH_LONG).show();
        }
        @Override
        protected void onPreExecute() {
        }
    }
    //}
    public void onClick(View v) {
    }
}
