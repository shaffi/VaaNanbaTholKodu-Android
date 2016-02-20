package it.neokree.example.mockedActivity;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import it.neokree.example.R;

public class Helpline extends Activity {
    private ImageView emergency_police,emergency_ambulance,emergency_tallkulam,emergency_anupandai;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpline);
        emergency_police=(ImageView)findViewById(R.id.image_emergencycontact);
        emergency_ambulance=(ImageView)findViewById(R.id.image_ambulance);
        emergency_tallkulam=(ImageView)findViewById(R.id.image_tallukalm);
        emergency_anupandai=(ImageView)findViewById(R.id.image_anupandi);

        call();
    }

    private void call() {
        try{
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:123456789"));
            startActivity(callIntent);
        } catch (ActivityNotFoundException ActivityException) {
           // Log.e("helloandroid dailing example", "Call Failed",e);
        }
    }
}
