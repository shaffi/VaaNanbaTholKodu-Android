package it.neokree.example.mockedFragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import it.neokree.example.Memberlist;
import it.neokree.example.R;
import it.neokree.example.mockedActivity.Child;
import it.neokree.example.mockedActivity.Group;
import it.neokree.example.mockedActivity.Profile;

/**
 * Created by siva on 6/1/16.
 */
public class FragmentMembers extends Fragment  implements View.OnClickListener{
    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;
    private  ImageView imagmember,search;
    private ProgressBar progressBar;
    private TextView txt_mem;
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_main2, container, false);

        search = (ImageView) v.findViewById(R.id.image_search);
       txt_mem = (TextView) v.findViewById(R.id.txt_member);
        ExpandList = (ExpandableListView) v.findViewById(R.id.exp_list);
       progressBar = (ProgressBar)v.findViewById(R.id.progressBar_member);

        new Memberlist1().execute();


        return v;

    }





    @Override
    public void onClick(View v) {


    }


    private class Memberlist1 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            Memberlist JSONOBJECT = new Memberlist();
            JSONOBJECT.setStart(0);
            JSONOBJECT.setLimit(25);
            JSONObject obj = new JSONObject();
            try {
                obj.put("start",JSONOBJECT.getStart());
                obj.put("limit",JSONOBJECT.getLimit());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httput = new HttpPost("https://vaananba.herokuapp.com/api/memberlist");
            StringEntity se = null;
            try {
                se = new StringEntity(obj.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            httput.setEntity(se);
            httput.setHeader("content-type", "application/json");
            int a = 0;
            try {
                HttpResponse resp = httpclient.execute(httput);
                String responseBody = EntityUtils.toString(resp.getEntity());
                return responseBody.toString();


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.GONE);


            try {
                ExpListItems = SetStandardGroups(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ExpAdapter = new ExpandListAdapter(FragmentMembers.this, ExpListItems);
            ExpandList.setAdapter(ExpAdapter);

        }
        @Override
        protected void onPreExecute() {

            progressBar.setVisibility(View.VISIBLE);
        }
    }

    private ArrayList<Group> SetStandardGroups(String result) throws JSONException {
        JSONArray json = new JSONArray(result);
        ArrayList<Group> list = new ArrayList<>();
        for (int i = 1; i < json.length(); i++) {
            JSONObject obj1 = json.getJSONObject(i);
            it.neokree.example.mockedActivity.Group group = new it.neokree.example.mockedActivity.Group();

            group.setName("" + i);
            group.setText1(obj1.getString("name"));
            group.setImage(obj1.getString("image"));
            group.setChildren(new ArrayList<Child>());
            Child child = new Child();
            child.setName("" + i);
            child.setId(obj1.getString("_id"));
            child.setText1(obj1.getString("name"));
            child.setText2(obj1.getString("mobile"));
            child.setImage(obj1.getString("image"));
            child.setText3("hellooo");
            child.setText4(obj1.getString("blood"));
                        group.getChildren().add(child);
            list.add(group);
        }
        return list;
    }
    static class ViewHolderItem {
        TextView name;
        ImageView imageViewRound;
        RelativeLayout relativeScreen;
        ImageView uparrow;

    }
    static class ViewHolderChild {
        TextView name1;
        TextView name2;
        TextView name3;
        TextView name4;
        ImageView imagetype,imagecall,imagechat,imagearrow;
        Button viewprofile;

    }
    public class ExpandListAdapter extends BaseExpandableListAdapter implements View.OnClickListener {
      private FragmentMembers context;
        private ArrayList<Group> groups;

        @Override
        public void onClick(View v) {

        }


        public ExpandListAdapter(FragmentMembers context, ArrayList<Group> groups) {
            this.context = context;
            this.groups = groups;
        }



        @Override
        public Object getGroup(int groupPosition) {
            return groups.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return groups.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            ViewHolderItem holder;
            holder = new ViewHolderItem();
            Group group = (Group) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater inf = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
                convertView = inf.inflate(R.layout.grouprow, null);
                holder.name= (TextView) convertView.findViewById(R.id.user_name);
                holder.imageViewRound=(ImageView)convertView.findViewById(R.id.imageView_round);
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.google);
                holder.imageViewRound.setImageBitmap(icon);
                holder.uparrow = (ImageView) convertView.findViewById(R.id.image_uparrow);
                holder.relativeScreen= (RelativeLayout) convertView.findViewById(R.id.relative_group);

                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolderItem) convertView.getTag();
            }
            holder.name.setText(group.getText1());
            Picasso.with(getActivity())
                    .load(group.getImage())
                    .into(holder.imageViewRound);

            return convertView;


        }
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            ArrayList<Child> chList = groups.get(groupPosition).getItems();
            return chList.get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            final Group group = groups.get(groupPosition);
            final Child child = group.getChildren().get(childPosition);
            ViewHolderChild holder;
            holder = new ViewHolderChild();
            if (convertView == null) {
                String user_id;
                LayoutInflater inf = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
                convertView = inf.inflate(R.layout.childrow, null);
                holder.name1 = (TextView) convertView.findViewById(R.id.user_name);
                holder.imagetype = (ImageView) convertView.findViewById(R.id.image_user);
                holder.name2 = (TextView) convertView.findViewById(R.id.user_number);
                holder.name3 = (TextView) convertView.findViewById(R.id.user_bloodgroup);
                holder.name4 = (TextView) convertView.findViewById(R.id.user_dl);
                holder.viewprofile =(Button) convertView.findViewById(R.id.ViewProfile_btn);
                holder.imagecall.setOnClickListener(this);
                holder.imagechat.setOnClickListener(this);
                holder.imagearrow.setOnClickListener(this);
                final ViewHolderChild finalHolder = holder;
                holder.imagecall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_LONG).show();
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + finalHolder.name2.getText().toString()));
                        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(callIntent);
                    }
                });
                holder.viewprofile.setOnClickListener(this);
                user_id=child.getId();

                holder.viewprofile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                       Intent myIntent = new Intent(getActivity(),Profile.class);
                        myIntent.putExtra("_id",child.getId());

                       startActivity(myIntent);

                    }
                });

                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolderChild) convertView.getTag();
            }



            holder.name1.setText(child.getText1());
            holder.name2.setText(child.getText2());
            holder.name3.setText(child.getText3());
            holder.name4.setText(child.getText4());

            Picasso.with(getActivity())
                    .load(child.getImage())
                    .into(holder.imagetype);


            return convertView;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            int size=0;
            if(groups.get(groupPosition).getChildren()!=null)
                size = groups.get(groupPosition).getChildren().size();
            return size;
            }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

}
