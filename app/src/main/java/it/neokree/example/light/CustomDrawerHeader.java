package it.neokree.example.light;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import it.neokree.example.R;
//import it.neokree.example.mockedFragments.FragmentButton;
import it.neokree.example.mockedFragments.FragmentIndex;
//import it.neokree.example.mockedFragments.FragmentJoinus1;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;


public class CustomDrawerHeader extends MaterialNavigationDrawer {
    @Override
    public void init(Bundle savedInstanceState) {


        View view = LayoutInflater.from(this).inflate(R.layout.custom_drawer,null);
        setDrawerHeaderCustom(view);


        this.addSection(newSection("Section 1", new FragmentIndex()));
        this.addSection(newSection("Section 2",new FragmentIndex()));
        this.addSection(newSection("Section 4",new FragmentIndex()));
       // this.addSection(newSection("Section 3", R.drawable.ic_mic_white_24dp,new FragmentButton()).setSectionColor(Color.parseColor("#9c27b0")));
        //this.addSection(newSection("Section",R.drawable.ic_hotel_grey600_24dp,new FragmentButton()).setSectionColor(Color.parseColor("#03a9f4")));
  }
}
