package it.neokree.example.mockedActivity;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import it.neokree.example.R;

public class Helpline extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpline);
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
