package it.neokree.example;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import it.neokree.example.light.Accounts;
import it.neokree.example.mockedActivity.Joinus1;
//import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 1000;
    public ActionBar action;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    final Intent intent;
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                    String storedUsername = pref.getString("user_name", null);
                    String mobilenum = pref.getString("mobilenumber",null);
                    if (storedUsername != null && mobilenum!=null  && !storedUsername.isEmpty()) {
                        intent = new Intent(SplashScreen.this, Accounts.class);
                        startActivity(intent);
                        finish();

                    } else {
                        intent = new Intent(SplashScreen.this, Screen2.class);
                        startActivity(intent);
                    }
                }
            }
        };
        timerThread.start();
    }
}

