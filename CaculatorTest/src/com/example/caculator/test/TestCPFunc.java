
package com.example.caculator.test;

import android.content.ContentValues;
import android.database.Cursor;
import android.test.ProviderTestCase2;

import com.example.caculator.Caculator;
import com.test.cpdemo.data.provider.CalContent.history;
import com.test.cpdemo.data.provider.CalProvider;

public class TestCPFunc extends ProviderTestCase2<CalProvider> {

    public TestCPFunc() {
        super(CalProvider.class, "com.test.cpdemo.provider.CalProvider");
    }

    public void testCP() {
        // delete all
        getProvider().delete(history.CONTENT_URI, null, null);

        // insert one
        ContentValues values = new ContentValues();
        values.put(history.Columns.PARAM1.getName(), 1);
        values.put(history.Columns.PARAM2.getName(), 2);
        values.put(history.Columns.RESULT.getName(), Caculator.plus(1, 2));
        getProvider().insert(history.CONTENT_URI, values);

        // check result
        Cursor cursor = getProvider().query(history.CONTENT_URI, history.PROJECTION, null, null,
                null);
        if (cursor.moveToFirst()) {
            int param1 = cursor.getInt(history.Columns.PARAM1.getIndex());
            int param2 = cursor.getInt(history.Columns.PARAM2.getIndex());
            int result = cursor.getInt(history.Columns.RESULT.getIndex());
            assertEquals(1, param1);
            assertEquals(2, param2);
            assertEquals(3, result);
        } else {
            assertTrue("cursor.moveToFirst() fail", false);
        }
    }
}
