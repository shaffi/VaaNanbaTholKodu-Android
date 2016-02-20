package it.neokree.example.mockedFragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import it.neokree.example.R;

/**
 * Created by siva on 6/1/16.
 */
public class FragmentHelpline  extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.helpline,container,false);
        View v = inflater.inflate(R.layout.helpline, container, false);

        ImageView emergency_police = (ImageView) v.findViewById(R.id.image_emergencycontact);
        ImageView emergency_ambulance = (ImageView) v.findViewById(R.id.image_ambulance);
        ImageView emergency_tallkulam = (ImageView) v.findViewById(R.id.image_tallukalm);
        ImageView emergency_anupandai = (ImageView) v.findViewById(R.id.image_anupandi);
        emergency_police.setOnClickListener(this);
        emergency_ambulance.setOnClickListener(this);
        emergency_tallkulam.setOnClickListener(this);
        emergency_anupandai.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_emergencycontact:
                //Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();

            try {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:+100"));
                startActivity(intent);
            } catch (Exception e) {
                Log.e("Demo application", "Failed to invoke call", e);
            }
            break;
            case R.id.image_ambulance:

                try {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:+101"));
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e("Demo application", "Failed to invoke call", e);
                }
                break;
            case R.id.image_tallukalm:

                try {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:+0452-2531620"));
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e("Demo application", "Failed to invoke call", e);
                }
                break;
            case R.id.image_anupandi:

                try {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:+0452-2670999"));
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e("Demo application", "Failed to invoke call", e);
                }
                break;

        }
    }
}