package com.example.contentprovider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.provider.ContactsContract.CommonDataKinds.Phone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(Contacts.CONTENT_URI, new String[]{Contacts._ID,
                Contacts.DISPLAY_NAME}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id;
                id = cursor.getInt(cursor.getColumnIndex("_id"));
                Log.d("TAG", cursor.getString(cursor.getColumnIndex("display_name")));
                Cursor query = contentResolver.query(Phone.CONTENT_URI, new String[]{Phone
                        .NUMBER}, Phone.CONTACT_ID + "=" + id, null, null);
                if (query != null) {

                    while (query.moveToNext()) {
                        Log.d("TAG", query.getString(query.getColumnIndex(Phone.NUMBER)));
                    }
                }
                query.close();
            }
        }
        cursor.close();

        ContentValues values = new ContentValues();

        Uri uri = contentResolver.insert(RawContacts.CONTENT_URI, values);
        Long contact_id = ContentUris.parseId(uri);
        values.clear();
        values.put(StructuredName.RAW_CONTACT_ID, contact_id);
        values.put(StructuredName.DISPLAY_NAME, "Admin");
        values.put(StructuredName.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
        uri = contentResolver.insert(ContactsContract.Data.CONTENT_URI, values);
        values.clear();
        values.put(Phone.RAW_CONTACT_ID, contact_id);
        values.put(Phone.NUMBER, "18888888888");
        values.put(Phone.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
        uri = contentResolver.insert(ContactsContract.Data.CONTENT_URI, values);
    }
}
