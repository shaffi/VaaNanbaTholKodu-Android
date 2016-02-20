package it.neokree.example.mockedActivity;



import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import it.neokree.example.R;

public class Contactus extends Activity {
    public Button submitB,call2;
    private WebView webview;
    //private ActionBar action;
    private EditText name,mobile,email,comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);
        name=(EditText)findViewById(R.id.editName);
        mobile=(EditText)findViewById(R.id.editContactNumber);
        email=(EditText)findViewById(R.id.editEmailAddress);
        comments=(EditText)findViewById(R.id.editComment_Feedback);
        submitB=(Button)findViewById(R.id.button1);
       call2=(Button)findViewById(R.id.button2);
        webview=(WebView)findViewById(R.id.webView1);

  }


}