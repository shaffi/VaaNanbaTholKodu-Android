package it.neokree.example.mockedActivity;

import android.app.SearchManager;
import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
//import java.security.acl.Group;
//import java.security.acl.Group;
import java.util.ArrayList;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import it.neokree.example.Memberlist;
import it.neokree.example.R;
import it.neokree.example.light.Accounts;

import static android.view.View.*;


public class MainActivity extends Activity implements  SearchView.OnQueryTextListener, SearchView.OnCloseListener,View.OnClickListener{
    Integer aaaa =0;
    Integer bbbb=8;
    ExpandListAdapter ExpAdapter;
    ExpandListAdapter ExpAdapter1;
    ExpandListAdapter ExpAdapter2;
    ArrayList<Group> ExpListItems = new ArrayList<Group>();
    ArrayList<Group> ExpListItems1 = new ArrayList<Group>();
    private ProgressBar progressBar;
    private ImageView imagmember,imagecall,imagechat,imageback;
    private ImageView callButton;
    private TextView num;
    private ExpandableListView ExpandList;
    private ExpandableListView ExpandList1;
    private ExpandableListView ExpandList2;
    EditText txt_search;
    private TextView txt_num;
    private ImageView searchicon,chat,groupchat;
    boolean isLoading=false;
    private SearchView search;
    private String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpAdapter = new ExpandListAdapter(MainActivity.this, ExpListItems);
        searchicon = (ImageView) findViewById(R.id.image_search);
        chat = (ImageView) findViewById(R.id.image_chat);
        final TextView txt_mem = (TextView) findViewById(R.id.txt_member);
        imageback = (ImageView) findViewById(R.id.img_back);
        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        groupchat = (ImageView) findViewById(R.id.image_chat);
        groupchat.setOnClickListener(this);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search = (SearchView) findViewById(R.id.search);
        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener((SearchView.OnQueryTextListener) this);
        search.setOnCloseListener((SearchView.OnCloseListener) this);
        ExpandList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int lastIndexInScreen = visibleItemCount + firstVisibleItem;

                if (lastIndexInScreen >= totalItemCount && !isLoading) {

                    isLoading = true;

                    new Memberlist1().execute();

                }
            }
        });


        searchicon.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                if (searchicon.getVisibility() == View.VISIBLE) {
                    txt_mem.setVisibility(View.GONE);
                    searchicon.setVisibility(View.GONE);
                    search.setVisibility(View.VISIBLE);


                }

            }
        });
        groupchat.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body", "default content");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);

            }

        });
        imageback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i;
                i = new Intent(MainActivity.this, Accounts.class);
                startActivity(i);

            }


        });
    }
     @Override
     public void onClick(View v) {

     }


     private class Memberlist1 extends AsyncTask<String, Void, String> {
         @Override
         protected String doInBackground(String... params) {

             Memberlist JSONOBJECT = new Memberlist();

             JSONOBJECT.setStart(aaaa);
             JSONOBJECT.setLimit(bbbb);
             aaaa = aaaa + 8;
             bbbb = bbbb + 8;
             JSONObject obj = new JSONObject();
             try {
                 obj.put("start", JSONOBJECT.getStart());
                 obj.put("limit", JSONOBJECT.getLimit());
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
                 SetStandardGroups(result);
             } catch (JSONException e) {
                 e.printStackTrace();
             }

         }

         @Override
         protected void onPreExecute() {
             progressBar.setVisibility(View.VISIBLE);
         }
     }

     private Void SetStandardGroups(String result) throws JSONException {
         JSONArray json = new JSONArray(result);
         for (int i = 1; i < json.length(); i++) {
             JSONObject obj1 = json.getJSONObject(i);
             Group parent = new Group();
             parent.setName("" + i);
             parent.setText1(obj1.getString("name"));
             parent.setImage(obj1.getString("image"));
             parent.setChildren(new ArrayList<Child>());
             Child child = new Child();
             child.setName("" + i);
             child.setId(obj1.getString("_id"));
             child.setText1(obj1.getString("name"));
             child.setText2(obj1.getString("mobile"));
             child.setImage(obj1.getString("image"));
            // child.setText3("hellooo");
             child.setText3(obj1.getString("blood"));
             //child.setText4(obj1.getString("blood"));
             child.setText4(obj1.getString("proof"));
             parent.getChildren().add(child);
             ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
             ExpListItems.add(parent);
             ExpAdapter = new ExpandListAdapter(MainActivity.this, ExpListItems);
             isLoading = false;

             ExpandList.setAdapter(ExpAdapter);


         }

         return null;
     }

     @Override
     public boolean onClose() {
         ExpAdapter.filterdata("");

         return false;
     }

     @Override
     public boolean onQueryTextSubmit(String query) {
         ExpAdapter.filterdata(query);
         //expandAll();
         return false;
     }

     @Override
     public boolean onQueryTextChange(String query) {
         ExpAdapter.filterdata(query);
         //expandAll();
         return false;
     }

     static class ViewHolderItem {
         TextView name;
         ImageView image;

     }

     static class ViewHolderChild {
         TextView name1;
         TextView name2;
         TextView name3;
         TextView name4;
         Button viewprofile;
         ImageView imagetype, imagecall, imagechat, imagearrow;

     }

     public class ExpandListAdapter extends BaseExpandableListAdapter implements View.OnClickListener {
         private Context context;
         private ArrayList<Group> groups;
         private ArrayList<Group> chList1;
         int size = 0;

         @Override
         public void onClick(View v) {

         }


         public ExpandListAdapter(Context context, ArrayList<Group> groups) {
             this.context = context;
             this.groups = groups;
             this.groups = new ArrayList<Group>();
             this.groups.addAll(groups);
             this.chList1 = new ArrayList<Group>();
             this.chList1.addAll(groups);
         }
         //private LayoutInflater inflater;

   /* public ExpandListAdapter()
    {
        // Create Layout Inflator
        inflater = LayoutInflater.from(this);
    }*/


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

                 LayoutInflater inf = (LayoutInflater) context
                         .getSystemService(context.LAYOUT_INFLATER_SERVICE);
                 convertView = inf.inflate(R.layout.grouprow, null);
                 holder.name = (TextView) convertView.findViewById(R.id.user_name);
                 holder.image = (ImageView) convertView.findViewById(R.id.imageView_round);
                 convertView.setTag(holder);
             } else {
                 holder = (ViewHolderItem) convertView.getTag();
             }
             holder.name.setText(group.getText1());
             Picasso.with(context)
                     .load(group.getImage())
                     .into(holder.image);
             //holder.personImageView.setImageBitmap(person.getImage());

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

             String user_id;
             if (convertView == null) {

                 LayoutInflater inf = (LayoutInflater) context
                         .getSystemService(context.LAYOUT_INFLATER_SERVICE);
                 convertView = inf.inflate(R.layout.childrow, null);
                 holder.name1 = (TextView) convertView.findViewById(R.id.user_name);
                 holder.imagetype = (ImageView) convertView.findViewById(R.id.image_user);
                 holder.name2 = (TextView) convertView.findViewById(R.id.user_number);
                 holder.name3 = (TextView) convertView.findViewById(R.id.user_bloodgroup);
                 holder.name4 = (TextView) convertView.findViewById(R.id.user_dl);
                 holder.viewprofile = (Button) convertView.findViewById(R.id.ViewProfile_btn);

                 holder.imagecall = (ImageView) convertView.findViewById(R.id.image_phone);
                 holder.imagechat = (ImageView) convertView.findViewById(R.id.image_chat);
                 holder.imagearrow = (ImageView) convertView.findViewById(R.id.image_uparrow);
                 holder.imagecall.setOnClickListener(this);
                 holder.imagechat.setOnClickListener(this);
                 holder.imagearrow.setOnClickListener(this);
                 final ViewHolderChild finalHolder = holder;
                 holder.imagecall.setOnClickListener(new OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         //Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_LONG).show();
                         Intent callIntent = new Intent(Intent.ACTION_CALL);
                         callIntent.setData(Uri.parse("tel:" + finalHolder.name2.getText().toString()));
                         callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                         startActivity(callIntent);
                     }
                 });
                 holder.imagechat.setOnClickListener(new OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         //Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_LONG).show();
                         Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                         sendIntent.putExtra("sms_body", "default content");
                         sendIntent.setType("vnd.android-dir/mms-sms");
                         startActivity(sendIntent);
                     }
                 });
                 convertView.setTag(holder);
             } else {
                 holder = (ViewHolderChild) convertView.getTag();
             }

             // Parent parent = parents.get(groupPosition);

             holder.name1.setText(child.getText1());
             holder.name2.setText(child.getText2());
             holder.name3.setText(child.getText3());
             holder.name4.setText(child.getText4());

             Picasso.with(context)
                     .load(child.getImage())
                     .into(holder.imagetype);

             holder.viewprofile.setOnClickListener(this);
             user_id = child.getId();
             //Toast.makeText(MainActivity.this,user_id, Toast.LENGTH_LONG).show();
             holder.viewprofile.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     //Toast.makeText(Joinus3.this,know_friend.getText().toString(),Toast.LENGTH_LONG).show();

                     Intent myIntent = new Intent(context, it.neokree.example.mockedActivity.Profile.class);
                     myIntent.putExtra("_id", child.getId());

                     startActivity(myIntent);

                 }
             });
             return convertView;
         }


         @Override
         public int getChildrenCount(int groupPosition) {

             if (groups.get(groupPosition).getChildren() != null)
                 size = groups.get(groupPosition).getChildren().size();
             return size;
       /* ArrayList<Child> chList = groups.get(groupPosition).getItems();
        return chList.size();*/
         }

         @Override
         public boolean hasStableIds() {
             return true;
         }

         @Override
         public boolean isChildSelectable(int groupPosition, int childPosition) {
             return true;
         }

         public void filterdata(String query) {
             //Toast.makeText(MainActivity.this,query, Toast.LENGTH_LONG).show();
             query = query.toLowerCase();

             //groups.clear();
             if (query.isEmpty()) {
                 Log.v("ExpandlistAdapter", "hai");
                 Log.v("ExpandlistAdapter", String.valueOf(groups.size()));
                 //groups.addAll(groups);
                 //groups.size();
                 Log.v("ExpandlistAdapter", String.valueOf(groups.size()));
                 ExpAdapter2 = new ExpandListAdapter(MainActivity.this, groups);
                 ExpandList2 = (ExpandableListView) findViewById(R.id.exp_list);
                 ExpandList2.setAdapter(ExpAdapter2);
                 ExpAdapter2.notifyDataSetChanged();
             } else {
                 ArrayList<Group> newList = new ArrayList<>();
                 for (Group group : chList1) {
                     //ArrayList<Child> chList =group.getItems();
                     String a = group.getText1();

                     if (a.toLowerCase().contains(query)) {
                         Log.v("ExpandlistAdapter", String.valueOf(group.getText1()));
                         Log.v("ExpandlistAdapter", String.valueOf(group.getImage()));
                         newList.add(group);
                     }

                 }
                 if (newList.size() > 0) {


                     ExpAdapter1 = new ExpandListAdapter(MainActivity.this, newList);
                     ExpandList1 = (ExpandableListView) findViewById(R.id.exp_list);
                     ExpandList1.setAdapter(ExpAdapter1);
                     ExpAdapter1.notifyDataSetChanged();

                 }


             }


         }

     }

 }