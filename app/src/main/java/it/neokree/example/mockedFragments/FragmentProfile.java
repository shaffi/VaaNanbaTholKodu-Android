package it.neokree.example.mockedFragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import it.neokree.example.R;
import it.neokree.example.mockedActivity.Joinus1;

/**
 * Created by siva on 6/1/16.
 */
public class FragmentProfile extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.profile,container,false);
        View v = inflater.inflate(R.layout.profile, container, false);
        ImageView imagecall = (ImageView) v.findViewById(R.id.imageViewCall);
        imagecall.setOnClickListener(this);
        ImageView imagechat = (ImageView) v.findViewById(R.id.imageViewChat);
        imagechat.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageViewCall:

                // Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
                try {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:+7305718127"));
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e("Demo application", "Failed to invoke call", e);
                }

                break;
            case R.id.imageViewChat:
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body", "default content");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);
                //Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
