package it.neokree.example.mockedActivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.RadioButton;

import it.neokree.example.R;


public class Joinus5 extends ActionBarActivity {
    //private ActionBar action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinus5);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("   Joinus");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setIcon(R.drawable.rightarrow);
        // action = getActionBar();
        RadioButton rb_fmmfrend =(RadioButton) findViewById(R.id.step_c_b_FromMyfriend);
        RadioButton rb_fmmysocial = (RadioButton) findViewById(R.id.step_c_b_FromSocialNetwork);
        RadioButton rb_other = (RadioButton) findViewById(R.id.step_c_b_Others);
        RadioButton rb_frmnp =(RadioButton) findViewById(R.id.step_c_b_FromNewsPaper);
        RadioButton rb_frmadv=(RadioButton) findViewById(R.id.step_c_b_FromAdvertistment);
        RadioButton rb_frmev =(RadioButton) findViewById(R.id.step_c_b_FromAdvertistment);
        RadioButton rb_frmevent =(RadioButton) findViewById(R.id.step_c_b_FromEvents);
        Button bn_up =(Button) findViewById(R.id.step_c_b_button_Nextpage);
        // action.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));

        //RadioButton rb_fmsn = (RadioButton) findViewById(R.id.s)
    }


}