package it.neokree.example.mockedActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import it.neokree.example.R;


public class Joinus3 extends Activity implements View.OnClickListener {
    // private ActionBar action;
    //String str;
    private ImageView imgback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinus3);
       // getSupportActionBar().setDisplayShowTitleEnabled(true);
       // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
       // getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setTitle("   Joinus");
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        //getSupportActionBar().setIcon(R.drawable.rightarrow);
        //action = getActionBar();
        EditText edxt_fdname=(EditText) findViewById(R.id.step_c_entername);
        EditText edxt_fdnumber=(EditText) findViewById(R.id.step_c_frientnumber);
        RadioButton rb_fmmfrend =(RadioButton) findViewById(R.id.radio_FromMyfriend);
        RadioButton rb_fmmysocial = (RadioButton) findViewById(R.id.radio_FromSocialNetwork);
        RadioButton rb_other = (RadioButton) findViewById(R.id.radio_Others);
        rb_fmmfrend.setOnClickListener(this);
        rb_fmmysocial.setOnClickListener(this);
        rb_other.setOnClickListener(this);
        Button btn_nxt = (Button) findViewById(R.id.stepc_updateprofile);
        //action.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
        btn_nxt.setOnClickListener(this);

        imgback=(ImageView)findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
                Intent i;
                i = new Intent(Joinus3.this, Joinus1.class);
                startActivity(i);
                //Toast.makeText(Joinus4.this, "shshgshgshgsghs", Toast.LENGTH_LONG).show();
            }


        });
    }

    @SuppressWarnings("unused")
    public void onClick1(View v) {

        switch(v.getId()){

//	    case R.id.radio_FromMyfriend;
            //    this.startActivity
            //  break;

            case R.id.radio_FromSocialNetwork: /** Start a new Activity MyCards.java */
                Intent intent = new Intent(this, Joinus4.class);
                this.startActivity(intent);
                break;

            case R.id.radio_Others: /** AlerDialog when click on Exit */
                Intent intet=new Intent(this,Joinus5.class);
                break;
        }
    }






    public void onClick(View v) {
        Log.i("clicks", "You Clicked B1");
        Intent i=new Intent(Joinus3.this, Joinus4.class);
        startActivity(i);
    }
}

