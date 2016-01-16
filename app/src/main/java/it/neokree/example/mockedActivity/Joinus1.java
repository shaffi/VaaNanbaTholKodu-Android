package it.neokree.example.mockedActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;



import it.neokree.example.R;
import it.neokree.example.light.Accounts;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialAccountListener;

import static android.view.View.*;


public class Joinus1 extends Activity implements OnClickListener {
    private ImageView imgback;

    Uri selectedImageUri;
    String  selectedPath;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinus1);

        //getSupportActionBar().setIcon(R.drawable.logo);
       // getSupportActionBar().setDisplayShowTitleEnabled(true);
       // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b7e6")));
       // getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setTitle("   Joinus");
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        //getSupportActionBar().setIcon(R.drawable.rightarrow);


        // FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Button btn_nxt = null;
        ImageView b = (ImageView) findViewById(R.id.imageView_frommobile);
        ImageView bCam = (ImageView) findViewById(R.id.imageView_takephoto);
        EditText edxt_name = (EditText) findViewById(R.id.step_a_name);
        EditText edxt_number = (EditText) findViewById(R.id.step_a_mobileNumber);
        EditText edxt_emgycall = (EditText) findViewById(R.id.step_a_mergencyContact);
        btn_nxt = (Button) findViewById(R.id.step_a_next);
        btn_nxt.setOnClickListener(this);

        imgback=(ImageView)findViewById(R.id.img_back);
        imgback.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Intent i;
               // i = new Intent(Joinus1.this, JoinSupport.class);
                i = new Intent(Joinus1.this, Accounts.class);
                startActivity(i);
                //Toast.makeText(Joinus1.this, "shshgshgshgsghs", Toast.LENGTH_LONG).show();
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
                openGallery(10);
            }
        });
    }


    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(getApplicationContext(), "Clicked on ActionBar", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void openGallery(int req_code){

        Intent intent = new Intent();

        intent.setType("image/*");

        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(intent,"Select file to upload "), req_code);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {



        if (resultCode == RESULT_OK) {
            if(data.getData() != null){
                selectedImageUri = data.getData();
            }else{
                Log.d("selectedPath1 : ", "Came here its null !");
                //Toast.makeText(getApplicationContext(), "failed to get Image!",500).show();
            }

            if (requestCode == 100 && resultCode == RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                selectedPath = getPath(selectedImageUri);
                //preview.setImageURI(selectedImageUri);
                Log.d("selectedPath1 : " ,selectedPath);

            }

            if (requestCode == 10)

            {

                selectedPath = getPath(selectedImageUri);
                // preview.setImageURI(selectedImageUri);
                Log.d("selectedPath1 : " ,selectedPath);

            }

        }

    }


    public String getPath(Uri uri) {

        String[] projection = { MediaStore.Images.Media.DATA };

        Cursor cursor = managedQuery(uri, projection, null, null, null);

        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        return cursor.getString(column_index);

    }
 /*@Override
	public void onBackPressed() {
		super.onBackPressed();
		MainActivty.this.finish();
	}*/

    public void onClick(View v) {
        //Log.i("clicks","You Clicked B1");
        Intent i=new Intent(Joinus1.this, Joinus2.class);
        startActivity(i);
    }


}