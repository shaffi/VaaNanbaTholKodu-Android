package it.neokree.example.mockedActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import it.neokree.example.R;



public class FirstTab extends Activity {
    /** Called when the activity is first created. */

    ImageView image1,image2;
    TextView text1,text2,text3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photos);

		/* First Tab Content */
		/*TextView textView = new TextView(this);
		textView.setText("First Tab");
		setContentView(textView);*/
        image1 = (ImageView) findViewById(R.id.imageView1);
        image2 = (ImageView) findViewById(R.id.imageView2);
        text1 = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView1);
        text3=(TextView)findViewById(R.id.textView2);

    }
   /* public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.photos, container, false);

        return v;
    }*/
}

