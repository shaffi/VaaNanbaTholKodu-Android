package it.neokree.example.mockedActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import it.neokree.example.R;
import it.neokree.example.Screen2;
import it.neokree.example.light.Accounts;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialAccountListener;

import static android.view.View.*;


public class Joinus1 extends Activity implements OnClickListener {
    private ImageView imgback,b,bCam;
    private String name,mobile,emergency,dob;
    private Context context;
     Uri selectedImageUri;
    String  selectedPath;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinus1);
        context = this.getApplicationContext();
        Button btn_nxt = null;
        final ImageView b = (ImageView) findViewById(R.id.imageView_frommobile);
        final ImageView bCam = (ImageView) findViewById(R.id.imageView_takephoto);
        final EditText name = (EditText) findViewById(R.id.step_a_name);

        final EditText mobile = (EditText) findViewById(R.id.step_a_mobileNumber);
        final EditText emergency = (EditText) findViewById(R.id.step_a_mergencyContact);
        final DatePicker dob = (DatePicker) findViewById(R.id.datePicker1);
        final int day = dob.getDayOfMonth();
        final int month = dob.getMonth()+1;
        final int year = dob.getYear();
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                name.setHint("");
            }
        });
        mobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                mobile.setHint("");
            }
        });
        emergency.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                emergency.setHint("");
            }
        });


        imgback=(ImageView)findViewById(R.id.img_back);
        imgback.setOnClickListener(

                new View.OnClickListener(){

            public void onClick(View v){

                Intent i;
                i = new Intent(Joinus1.this, Screen2.class);
                startActivity(i);

            }


        });
        bCam.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 100);

            }
        });


        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //openGallery(10);
                int req_code = 10;
                Intent intent = new Intent();

                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "Select file to upload "), req_code);
            }


        });
        btn_nxt = (Button) findViewById(R.id.step_a_next);
        btn_nxt.setOnClickListener(this);
        btn_nxt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context, Joinus2.class);

                myIntent.putExtra("name", name.getText().toString());
                myIntent.putExtra("mobile", mobile.getText().toString());
                myIntent.putExtra("emergency", emergency.getText().toString());
                myIntent.putExtra("day", String.valueOf(day));
                myIntent.putExtra("month", String.valueOf(month));
                myIntent.putExtra("year", String.valueOf(year));
                startActivity(myIntent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 100) {

                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                // Bitmap bitmapOrg = BitmapFactory.decodeResource(getResources(),R.drawable.image);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
                byte[] byteArray = bytes.toByteArray();
                //byte[] data = bytes.toByteArray("UTF-8");
                File destination = new File(Environment.getExternalStorageDirectory(),
                        System.currentTimeMillis() + ".jpg");
                FileOutputStream fo;
                try {

                    destination.createNewFile();
                    fo = new FileOutputStream(destination);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("key_name1", encoded);
                editor.commit();

            } else if (requestCode == 10) {
                //Uri selectedImageUri = data.getData();
                try {
                    if (data == null)
                        return;
                    Uri uri = data.getData();
                    String[] filePathColumn = { MediaStore.Images.Media.DATA };
                    Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();

                    final BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    Bitmap sourceBitmap = BitmapFactory.decodeFile(filePath, options);
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    sourceBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
                    byte[] byteArray = bytes.toByteArray();
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
                    editor.putString("key_name1", encoded);
                    editor.commit();

                    sourceBitmap = null;

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
    }




  public void onClick(View v) {

    }


}
