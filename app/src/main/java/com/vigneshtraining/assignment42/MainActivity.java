package com.vigneshtraining.assignment42;

import android.Manifest;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.vigneshtraining.assignment42.adapter.SelectUserAdapter;
import com.vigneshtraining.assignment42.model.SelectUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public  static final int RequestPermissionCode  = 1 ;
    private ListView listView;
    private Button loadBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadBtn = (Button) findViewById(R.id.loadBtn);
        loadBtn.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.contacts_list);

        EnableRuntimePermission();




    }

    @Override
    public void onClick(View v) {

        loadBtn.setVisibility(View.GONE);

        LoadContact loadContact = new LoadContact();
        loadContact.setPhones(getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null));
        loadContact.setResolver(this.getContentResolver());
       
        loadContact.setSelectUsers(new ArrayList<SelectUser>());
        loadContact.setListView(listView);
        loadContact.setAdapter(new SelectUserAdapter(loadContact.getSelectUsers(),this));
        loadContact.execute();
    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_CONTACTS))
        {

            Toast.makeText(MainActivity.this,"CONTACTS permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                    Manifest.permission.READ_CONTACTS}, RequestPermissionCode);

        }
    }
}
