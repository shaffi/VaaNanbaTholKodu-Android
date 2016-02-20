package it.neokree.example.light;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import it.neokree.example.R;
import it.neokree.example.mockedFragments.FragmentAboutus;
import it.neokree.example.mockedFragments.FragmentContact;
import it.neokree.example.mockedFragments.FragmentGallery;
import it.neokree.example.mockedFragments.FragmentHelpline;
import it.neokree.example.mockedFragments.FragmentJoinSupport;
//import it.neokree.example.mockedFragments.FragmentJoinus1;
import it.neokree.example.mockedFragments.FragmentMembers;
import it.neokree.example.mockedFragments.FragmentProfile;
import it.neokree.example.mockedFragments.FragmentSettings;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialAccountListener;


public class Accounts extends MaterialNavigationDrawer implements MaterialAccountListener {

    @Override
    public void init(Bundle savedInstanceState) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String storedUsername= pref.getString("user_name", null);
        String storedUserphone = pref.getString("mobilenumber",null);
        String storedUserimage = pref.getString("userimage",null);
       // Toast.makeText(Accounts.this,storedUsername,Toast.LENGTH_LONG).show();
        //Toast.makeText(Accounts.this,storedUserphone,Toast.LENGTH_LONG).show();
// add accounts
        MaterialAccount account = new MaterialAccount(this.getResources(),storedUsername,storedUserphone,R.drawable.photo, R.drawable.bamboo);        // add accounts

        this.addAccount(account);


        this.addSection(newSection("Profile", R.drawable.ic_mic_white_24dp, new FragmentProfile()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("About Us",R.drawable.iconaboutus,new FragmentAboutus()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("Members",R.drawable.ic_mic_white_24dp,new FragmentMembers()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("Join Us/Support Us",R.drawable.ic_hotel_grey600_24dp,new FragmentJoinSupport()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("Gallery",R.drawable.icongallery,new FragmentGallery()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("Helpline",R.drawable.ic_hotel_grey600_24dp,new FragmentHelpline()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("Settings",R.drawable.ic_hotel_grey600_24dp,new FragmentSettings()).setSectionColor(Color.parseColor("#03a9f4")));
        this.addSection(newSection("Contact Us", R.drawable.mailicon, new FragmentContact()).setSectionColor(Color.parseColor("#03a9f4")));
       // this.addSection(newSection("Exit", R.drawable.mailicon, new FragmentExit()).setSectionColor(Color.parseColor("#03a9f4")));

       // this.addAccount(joinus);




    }




    @Override
    public void onAccountOpening(MaterialAccount account) {

    }

    @Override
    public void onChangeAccount(MaterialAccount newAccount) {

    }
}
