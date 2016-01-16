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



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import it.neokree.example.R;

public class Joinus2 extends Activity implements View.OnClickListener {
    //private ActionBar action;
//private RadioButton rb_fmmysocial;
//private RadioButton rb_other;

    //private CompoundButton rb_fmmysocial;
//private CompoundButton rb_other;
    //String str;
    private ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinus2);
        //getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
       // getSupportActionBar().setTitle("   Joinus");
       // getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        //getSupportActionBar().setIcon(R.drawable.rightarrow);
        //action = getActionBar();
        EditText edxt_wrk=(EditText) findViewById(R.id.edxt_work);
        EditText edxt_eid=(EditText) findViewById(R.id.edxt_enteremailid);
        EditText edxt_idproof =(EditText) findViewById(R.id.edxt_enteridproof);
        EditText edxt_bldgp=(EditText) findViewById(R.id.edxt_enterbloodgroup);
        EditText edxt_fb =(EditText) findViewById(R.id.edxt_FacebookLogin);
        EditText edxt_google=(EditText) findViewById(R.id.edxt_google);
        EditText edxt_twitter =(EditText) findViewById(R.id.edxt_twitterLogin);
        Button btn_nxt = (Button) findViewById(R.id.step_b_button_next);
        //action.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
        btn_nxt.setOnClickListener(this);

        imgback=(ImageView)findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
                Intent i;
                i = new Intent(Joinus2.this, Joinus1.class);
                startActivity(i);
                //Toast.makeText(Joinus4.this, "shshgshgshgsghs", Toast.LENGTH_LONG).show();
            }


        });
    }

    public void onClick(View v) {
        //Log.i("clicks", "You Clicked B1");
        Intent i=new Intent(Joinus2.this, Joinus3.class);
       startActivity(i);
    }

}