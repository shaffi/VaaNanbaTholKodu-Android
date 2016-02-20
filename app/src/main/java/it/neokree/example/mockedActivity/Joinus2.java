package it.neokree.example.mockedActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import it.neokree.example.R;

public class Joinus2 extends Activity implements View.OnClickListener {

    private ImageView imgback;
    private Context context;
    private EditText proof, blood,social_fb,social_google,social_twitter;
    private Button btn_nxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinus2);
        context = this.getApplicationContext();
        final EditText about=(EditText) findViewById(R.id.edxt_work);
        final EditText email=(EditText) findViewById(R.id.edxt_enteremailid);
        email.addTextChangedListener(new TextWatcher() {
            // after every change has been made to this editText, we would like to check validity
            public void afterTextChanged(Editable s) {
                Validation.isEmailAddress(email, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });
        proof =(EditText) findViewById(R.id.edxt_enteridproof);
        blood=(EditText) findViewById(R.id.edxt_enterbloodgroup);
        social_fb =(EditText) findViewById(R.id.edxt_FacebookLogin);
        social_google=(EditText) findViewById(R.id.edxt_google);
        social_twitter =(EditText) findViewById(R.id.edxt_twitterLogin);
        btn_nxt = (Button) findViewById(R.id.step_b_button_next);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        pref.getString("key_name1",null);
        final String encoded = pref.getString("key_name1",null);
        String username = getIntent().getStringExtra("name");
        String mobile = getIntent().getStringExtra("mobile");
        String image = getIntent().getStringExtra("encoded");
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("user_name",username);
        editor.putString("mobilenumber",mobile);
        editor.putString("encoded",image);
        editor.commit();
        btn_nxt.setOnClickListener(this);
        btn_nxt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Joinus2.this, mobile, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, Joinus3.class);
                intent.putExtra("name", getIntent().getStringExtra("name"));
                intent.putExtra("mobile",getIntent().getStringExtra("mobile") );
                intent.putExtra("emergency",getIntent().getStringExtra("emergency"));
                intent.putExtra("day", getIntent().getStringExtra("day"));
                intent.putExtra("month", getIntent().getStringExtra("month"));
                intent.putExtra("year", getIntent().getStringExtra("year"));
                intent.putExtra("encoded",encoded.toString());
                intent.putExtra("about", about.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("proof",proof.getText().toString());
                intent.putExtra("blood",blood.getText().toString());
                intent.putExtra("social_fb", social_fb.getText().toString());
                intent.putExtra("social_google", social_google.getText().toString());
                intent.putExtra("social_twitter",social_twitter.getText().toString());

                startActivity(intent);
            }
        });


        imgback=(ImageView)findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Intent i;
                i = new Intent(Joinus2.this, Joinus1.class);
                startActivity(i);

            }


        });
    }

    public void onClick(View v) {

    }

}