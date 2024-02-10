package com.example.contentproviderdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.Manifest;
import androidx.core.content.ContextCompat;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnGetContactPressed(View view){

    }
    private void getPhoneContacts(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
        !=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 0);
        }
        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = contentResolver.query( uri,null,null,null);
        Log.i("CONTACT_PROVIDER_DEMO","TOTAL #  of Contacts ::: " + integer.tostring(cursor.getcount()));
        if (cursor.getCount() >0){
            while (cursor.MoveToNext()){
                String contantName = cursor.getString(coursor.getColumnIndex(contactsContract.CommonDataKinds.phone.DISPLAY_NAME));
                String contantNumber = cursor.getString(coursor.getColumnIndex(contactsContract.CommonDataKinds.phone.Number) );

                Log.i("CONTACT_PROVIDER_DEMO", "Contact Name: " + contactName + " ph # ::: " + contactNumber);

            }
        }
        }
    };
