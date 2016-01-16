package it.neokree.example.mockedFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import it.neokree.example.R;
import it.neokree.example.mockedActivity.JoinSupport;
import it.neokree.example.mockedActivity.Joinus1;
import it.neokree.example.mockedActivity.Joinus2;
import it.neokree.example.mockedActivity.Supportus1;

/**
 * Created by siva on 6/1/16.
 */
public class FragmentJoinSupport extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second, container, false);

       /* v.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(getActivity(), Joinus1.class);
                startActivity(i);
                // Toast.makeText(getActivity(),"shshgshgshgsghs",Toast.LENGTH_LONG).show();
            }
        });
        return v;*/
        Button joinus = (Button) v.findViewById(R.id.button1);
        Button supportus = (Button) v.findViewById(R.id.button2);
        supportus.setOnClickListener(this);
        joinus.setOnClickListener(this);
        return v;
    }
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    Intent i;
                    i = new Intent(getActivity(), Joinus1.class);
                    startActivity(i);
                    break;
                case R.id.button2:
                    Intent i1;
                    i1 = new Intent(getActivity(), Supportus1.class);
                    startActivity(i1);
                    //Toast.makeText(getActivity(),"shshgshgshgsghs",Toast.LENGTH_LONG).show();
                    break;

            }
        }
    }







