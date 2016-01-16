package it.neokree.example.mockedFragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import it.neokree.example.R;
import it.neokree.example.mockedActivity.Joinus1;
import it.neokree.example.mockedActivity.Supportus1;

/**
 * Created by siva on 6/1/16.
 */
public class FragmentAboutus  extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.aboutus,container,false);
        View v = inflater.inflate(R.layout.aboutus, container, false);
        TextView tamil = (TextView) v.findViewById(R.id.textTamil);
        tamil.setOnClickListener(this);
        TextView english = (TextView) v.findViewById(R.id.textEnglish);
        english.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textTamil:
                //Toast.makeText(getActivity(),"shshgshgshgsghs", Toast.LENGTH_LONG).show();
                v.setBackgroundColor(Color.RED);
              // v.setBackgroundColor(Color.BLACK);

                break;
            case R.id.textEnglish:

                //Toast.makeText(getActivity(),"shshgshgshgsghs",Toast.LENGTH_LONG).show();
                v.setBackgroundColor(Color.BLACK);
               // v.setBackgroundColor(Color.RED);
                break;

        }

    }
}