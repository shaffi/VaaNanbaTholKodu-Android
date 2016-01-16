package it.neokree.example.mockedFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import it.neokree.example.R;
import it.neokree.example.mockedActivity.Joinus1;
import it.neokree.example.mockedActivity.Joinus2;

/**
 * Created by siva on 6/1/16.
 */
public class FragmentJoinus1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.second,container,false);
        View v = inflater.inflate(R.layout.joinus1, container, false);

        //return inflater.inflate(R.layout.joinus1,container,false);
        Button btn_nxt = (Button) v.findViewById(R.id.step_a_next);
        btn_nxt.setOnClickListener((View.OnClickListener) this);
        return v;
    }
    public void onClick(View v) {
        //Log.i("clicks","You Clicked B1");
        Intent i=new Intent(getActivity(), Joinus2.class);
        startActivity(i);
    }


    }


