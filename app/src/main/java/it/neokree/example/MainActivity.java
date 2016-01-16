package it.neokree.example;
import android.annotation.TargetApi;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import it.neokree.example.light.Accounts;
/*import it.neokree.example.backpattern.BackAnywhere;
import it.neokree.example.backpattern.BackToFirst;
import it.neokree.example.functionalities.ActionBarShadow;
import it.neokree.example.functionalities.CustomAccountSection;
import it.neokree.example.functionalities.DefaultSectionLoaded;
import it.neokree.example.functionalities.KitkatStatusBar;
import it.neokree.example.functionalities.LearningPatternDisabled;
import it.neokree.example.functionalities.MultiPane;
import it.neokree.example.functionalities.RealColorSections;
import it.neokree.example.functionalities.RippleBackport;
import it.neokree.example.functionalities.UniqueToolbarColor;
import it.neokree.example.functionalities.master_child.MasterChildActivity;*/
/*
import it.neokree.example.light.CustomDrawerHeader;
import it.neokree.example.light.ImageDrawerHeader;
import it.neokree.example.light.MockedAccount;
import it.neokree.example.light.NoDrawerHeader;
import it.neokree.example.test.Test;
*/
/**
 * Created by neokree on 30/12/14.
 */
public class MainActivity extends ListActivity  {
    //@TargetApi(Build.VERSION_CODES.HONEYCOMB)

    private ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // intent = new Intent(this,MockedAccount.class);
        Intent intent;
        //intent = new Intent(this, it.neokree.example.dark.Accounts.class);
        intent = new Intent(this, Accounts.class);
        startActivity(intent);

        imgback=(ImageView)findViewById(R.id.img_back);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


      /*  @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    NavUtils.navigateUpFromSameTask(this);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }
*/


        /*ArrayList<String> list = new ArrayList<String>();
        list.add("Light - Mocked Account");
        list.add("Dark  - Mocked Account");
        list.add("Light - Accounts");
        list.add("Dark  - Accounts");
        list.add("Light - Drawer Header Image");
        list.add("Dark  - Drawer Header Image");
        list.add("Light - No Drawer Header");
        list.add("Dark  - No Drawer Header");
        list.add("Light - Custom Drawer Header");
        list.add("Dark  - Custom Drawer Header");
        list.add("Functionality: unique Toolbar Color");
        list.add("Functionality: ripple backport support");
        list.add("Functionality: multi pane support for tablet");
        list.add("Functionality: custom section under account list");
        list.add("Functionality: Kitkat trasluncent status bar");
        list.add("Functionality: Master/Child example");
        list.add("Functionality: section not pre-rendered");
        list.add("Functionality: default section loaded");
        list.add("Functionality: action bar shadow enabled (toolbar elevation)");
        list.add("Functionality: learning pattern disabled");
        list.add("Back Pattern: Back To first");
        list.add("Back Pattern: Back Anywhere");
        list.add("Back Pattern: Custom");
//        list.add("Test");
        this.setListAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list));
        this.getListView().setOnItemClickListener(this);*/
    }
    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        *//*switch(position) {
            case 0:
                intent = new Intent(this,MockedAccount.class);
                break;
            case 1:
                intent = new Intent(this, it.neokree.example.dark.MockedAccount.class);
                break;
            case 2:
                intent = new Intent(this,Accounts.class);
                break;
            case 3:
                intent = new Intent(this, it.neokree.example.dark.Accounts.class);
                break;
            case 4:
                intent = new Intent(this,ImageDrawerHeader.class);
                break;
            case 5:
                intent = new Intent(this, it.neokree.example.dark.ImageDrawerHeader.class);
                break;
            case 6:
                intent = new Intent(this,NoDrawerHeader.class);
                break;
            case 7:
                intent = new Intent(this, it.neokree.example.dark.NoDrawerHeader.class);
                break;
            case 8:
                intent = new Intent(this, CustomDrawerHeader.class);
                break;
            case 9:
                intent = new Intent(this, it.neokree.example.dark.CustomDrawerHeader.class);
                break;
            case 10:
                intent = new Intent(this, UniqueToolbarColor.class);
                break;
            case 11:
                intent = new Intent(this, RippleBackport.class);
                break;
            case 12:
                intent = new Intent(this, MultiPane.class);
                break;
            case 13:
                intent = new Intent(this, CustomAccountSection.class);
                break;
            case 14:
                intent = new Intent(this, KitkatStatusBar.class);
                break;
            case 15:
                intent = new Intent(this, MasterChildActivity.class);
                break;
            case 16:
                intent = new Intent(this, RealColorSections.class);
                break;
            case 17:
                intent = new Intent(this, DefaultSectionLoaded.class);
                break;
            case 18:
                intent = new Intent(this, ActionBarShadow.class);
                break;
            case 19:
                intent = new Intent(this, LearningPatternDisabled.class);
                break;
            case 20:
                intent = new Intent(this, BackToFirst.class);
                break;
            case 21:
                intent = new Intent(this, BackAnywhere.class);
                break;
            *//**//*case 22:
                intent = new Intent(this, BackPatternCustom.class);
                break;*//**//*
            case 23:
                intent = new Intent(this, Test.class);
                break;
            default:
                intent = null;
        }*//*
        //startActivity(intent);
    }*/
