package it.neokree.example.mockedActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import it.neokree.example.R;


public class Joinus4 extends Activity implements View.OnClickListener {
    // private ActionBar action;
    private ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinus4);
       // getSupportActionBar().setDisplayShowTitleEnabled(true);
       // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
       // getSupportActionBar().setDisplayShowHomeEnabled(true);
       // getSupportActionBar().setTitle("   Joinus");
       // getSupportActionBar().setDisplayUseLogoEnabled(true);
       // getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_HOME | android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);
       // getSupportActionBar().setIcon(R.drawable.rightarrow);
        //action = getActionBar();
        RadioButton rb_frmfrd = (RadioButton) findViewById(R.id.stepc_a_radio_FromMyfriend);
        RadioButton rb_frmsn =(RadioButton) findViewById(R.id.stepc_a_radio_FromSocialNetwork);
        RadioButton rb_frmfb = (RadioButton) findViewById(R.id.stepc_a_radio_fromFacebook);
        RadioButton rb_frmtw = (RadioButton) findViewById(R.id.stepc_a_radio_fromtwitter);
        RadioButton rb_frmgp =(RadioButton) findViewById(R.id.stepc_a_radio_fromgoogleplus);
        EditText edxt_address1=(EditText) findViewById(R.id.step_c_etxt_address1);
        EditText edxt_address2=(EditText) findViewById(R.id.step_c_etxt_address2);
        EditText edxt_address3=(EditText) findViewById(R.id.step_c_etxt_address3);
        EditText edxt_address4=(EditText) findViewById(R.id.step_c_etxt_address4);
        Button bn_updateprofile =(Button) findViewById(R.id.stepc_a_button_Nextpage);
        //action.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
        bn_updateprofile.setOnClickListener(this);

        imgback=(ImageView)findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
                Intent i;
                i = new Intent(Joinus4.this, Joinus1.class);
                startActivity(i);
                //Toast.makeText(Joinus4.this, "shshgshgshgsghs", Toast.LENGTH_LONG).show();
            }


        });
    }


    public void onClick(View v) {
        Log.i("clicks", "You Clicked B1");
        Intent i=new Intent(Joinus4.this, Joinus5.class);
        startActivity(i);
    }
}