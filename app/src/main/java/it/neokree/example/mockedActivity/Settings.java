package it.neokree.example.mockedActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import it.neokree.example.R;

/**
 * Created by neokree on 24/11/14.
 */
public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
       // getResources().getColor(#ffff0000);
        //serandroid:background="@color/red";
        //ViewCompat.setBackgroundTintList(View.inflate(this));

    }
}
