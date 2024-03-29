package com.test.cpdemo.data.provider;

import com.test.cpdemo.data.provider.util.ColumnMetadata;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * This class was generated by the ContentProviderCodeGenerator project made by Foxykeep
 * <p>
 * (More information available https://github.com/foxykeep/ContentProviderCodeGenerator)
 */
public abstract class CalContent {

    public static final Uri CONTENT_URI = Uri.parse("content://" + CalProvider.AUTHORITY);

    private CalContent() {
    }

    /**
     * Created in version 1
     */
    public static final class history extends CalContent {

        private static final String LOG_TAG = history.class.getSimpleName();

        public static final String TABLE_NAME = "history";
        public static final String TYPE_ELEM_TYPE = "vnd.android.cursor.item/cal-history";
        public static final String TYPE_DIR_TYPE = "vnd.android.cursor.dir/cal-history";

        public static final Uri CONTENT_URI = Uri.parse(CalContent.CONTENT_URI + "/" + TABLE_NAME);

        public static enum Columns implements ColumnMetadata {
            ID(BaseColumns._ID, "integer"),
            PARAM1("param1", "integer"),
            PARAM2("param2", "integer"),
            RESULT("result", "integer");

            private final String mName;
            private final String mType;

            private Columns(String name, String type) {
                mName = name;
                mType = type;
            }

            @Override
            public int getIndex() {
                return ordinal();
            }

            @Override
            public String getName() {
                return mName;
            }

            @Override
            public String getType() {
                return mType;
            }
        }

        public static final String[] PROJECTION = new String[] {
                Columns.ID.getName(),
                Columns.PARAM1.getName(),
                Columns.PARAM2.getName(),
                Columns.RESULT.getName()
        };

        private history() {
            // No private constructor
        }

        public static void createTable(SQLiteDatabase db) {
            if (CalProvider.ACTIVATE_ALL_LOGS) {
                Log.d(LOG_TAG, "history | createTable start");
            }
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + Columns.ID.getName() + " " + Columns.ID.getType() + ", " + Columns.PARAM1.getName() + " " + Columns.PARAM1.getType() + ", " + Columns.PARAM2.getName() + " " + Columns.PARAM2.getType() + ", " + Columns.RESULT.getName() + " " + Columns.RESULT.getType() + ", PRIMARY KEY (" + Columns.ID.getName() + ")" + ");");

            if (CalProvider.ACTIVATE_ALL_LOGS) {
                Log.d(LOG_TAG, "history | createTable end");
            }
        }

        // Version 1 : Creation of the table
        public static void upgradeTable(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (CalProvider.ACTIVATE_ALL_LOGS) {
                Log.d(LOG_TAG, "history | upgradeTable start");
            }

            if (oldVersion < 1) {
                Log.i(LOG_TAG, "Upgrading from version " + oldVersion + " to " + newVersion
                        + ", data will be lost!");

                db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
                createTable(db);
                return;
            }


            if (oldVersion != newVersion) {
                throw new IllegalStateException("Error upgrading the database to version "
                        + newVersion);
            }

            if (CalProvider.ACTIVATE_ALL_LOGS) {
                Log.d(LOG_TAG, "history | upgradeTable end");
            }
        }

        static String getBulkInsertString() {
            return new StringBuilder("INSERT INTO ").append(TABLE_NAME).append(" ( ").append(Columns.ID.getName()).append(", ").append(Columns.PARAM1.getName()).append(", ").append(Columns.PARAM2.getName()).append(", ").append(Columns.RESULT.getName()).append(" ) VALUES (?, ?, ?, ?)").toString();
        }

        static void bindValuesInBulkInsert(SQLiteStatement stmt, ContentValues values) {
            int i = 1;
            stmt.bindLong(i++, values.getAsLong(Columns.ID.getName()));
            stmt.bindLong(i++, values.getAsLong(Columns.PARAM1.getName()));
            stmt.bindLong(i++, values.getAsLong(Columns.PARAM2.getName()));
            stmt.bindLong(i++, values.getAsLong(Columns.RESULT.getName()));
        }
    }
}

