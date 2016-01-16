package it.neokree.example.mockedActivity;




        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

        import it.neokree.example.R;

public class Profile extends Activity {
    private ImageView imagecall,imagechat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        TextView txt_name=(TextView)findViewById(R.id.id_name);
        TextView txt_number=(TextView) findViewById(R.id.id_number);
        TextView txt_altnumber = (TextView) findViewById(R.id.id_altnumber);
        TextView txt_bg = (TextView) findViewById(R.id.id_bloodgroup);
        TextView txt_dl = (TextView) findViewById(R.id.id_position);
        TextView txt_aboutme = (TextView) findViewById(R.id.id_abut);
        TextView txt_email =(TextView) findViewById(R.id.id_email);
        TextView txt_fb =(TextView) findViewById(R.id.id_fb);
        TextView txt_twitter = (TextView) findViewById(R.id.id_twitter);
        TextView txt_google = (TextView) findViewById(R.id.id_google);
        TextView txt_knwname = (TextView) findViewById(R.id.id_from);
        TextView txt_knwnumber = (TextView) findViewById(R.id.id_fromnumber);
        TextView txt_address = (TextView) findViewById(R.id.id_address);
         ImageView imagecall = (ImageView) findViewById(R.id.imageViewCall);
        ImageView imagechat = (ImageView) findViewById(R.id.imageViewChat);

    }
}