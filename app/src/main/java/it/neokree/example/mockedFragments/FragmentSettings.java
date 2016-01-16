package it.neokree.example.mockedFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import it.neokree.example.R;

/**
 * Created by siva on 6/1/16.
 */
public class FragmentSettings extends Fragment {
   /* @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.contactus,container,false);
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Button button = new Button(this.getActivity());
        button.setText("Click Me");
        button.setGravity(Gravity.CENTER);
        return button;

    }

}
