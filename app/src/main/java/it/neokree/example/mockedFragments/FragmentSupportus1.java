package it.neokree.example.mockedFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.neokree.example.R;

public class FragmentSupportus1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
        //return inflater.inflate(R.layout.second,container,false);
        return inflater.inflate(R.layout.supportus1,container,false);



    }

}
