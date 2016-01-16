package it.neokree.example.mockedFragments;

//import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.Toast;

import it.neokree.example.R;
import it.neokree.example.mockedActivity.Joinus1;
import it.neokree.example.mockedActivity.Supportus1;

/**
 * Created by siva on 5/1/16.
 */
public class FragmentContact extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
       // return inflater.inflate(R.layout.contactus,container,false);
        View v = inflater.inflate(R.layout.contactus, container, false);

        Button submitB = (Button) v.findViewById(R.id.button1);
        Button call2 = (Button) v.findViewById(R.id.button2);
        submitB.setOnClickListener(this);
        call2.setOnClickListener(this);
        return v;
    }

  /*  @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
    }*/
  @Override
  public void onClick(View v) {
      switch (v.getId()) {
          case R.id.button1:
              Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
              break;
          case R.id.button2:
             // String phno="9894824829";

             // Intent callIntent=new Intent(Intent.ACTION_DIAL,Uri.parse(phno));
             // startActivity(callIntent);
              //Toast.makeText(getActivity(),"shshgshgshgsghs",Toast.LENGTH_LONG).show();
              try {
              Intent intent = new Intent(Intent.ACTION_CALL);
              intent.setData(Uri.parse("tel:+7305718127"));
              startActivity(intent);
          } catch (Exception e) {
              Log.e("Demo application", "Failed to invoke call", e);
          }
              break;

      }
  }
}