package it.neokree.example.mockedActivity;

/**
 * Created by siva on 11/1/16.
 */

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;

import it.neokree.example.R;


public class TabBarExample extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);

        /* TabHost will have Tabs */
        final TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(String tabId) {
                // TODO Auto-generated method stub
                for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
                {
                    tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#FFFFFF")); //unselected
                }
                tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#ea5324")); // selected
            }
        });

        /* TabSpec used to create a new tab.
         * By using TabSpec only we can able to setContent to the tab.
         * By using TabSpec setIndicator() we can set name to tab. */

        /* tid1 is firstTabSpec Id. Its used to access outside. */
        TabHost.TabSpec firstTabSpec = tabHost.newTabSpec("tid1");
        TabHost.TabSpec secondTabSpec = tabHost.newTabSpec("tid1");

        /* TabSpec setIndicator() is used to set name for the tab. */
        /* TabSpec setContent() is used to set content for a particular tab. */
        firstTabSpec.setIndicator("Photos").setContent(new Intent(this,FirstTab.class));
        secondTabSpec.setIndicator("Videos").setContent(new Intent(this,SecondTab.class));

        /* Add tabSpec to the TabHost to display. */
        tabHost.addTab(firstTabSpec);
        tabHost.addTab(secondTabSpec);

    }
}
