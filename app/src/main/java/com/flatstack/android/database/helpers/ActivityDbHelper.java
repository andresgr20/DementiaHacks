package com.flatstack.android.database.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.flatstack.android.database.contracts.ActivityContract;

public class ActivityDbHelper extends SQLiteOpenHelper {
	public static final String DATABASE_NAME = "Activity.db";

	public ActivityDbHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+ ActivityContract.ActivityEntry.TABLE_NAME + " (" +
				ActivityContract.ActivityEntry._ID + " INTEGER PRIMARY KEY" +
				ActivityContract.ActivityEntry.COLUMN_NAME_ACTIVITY_TEMPLATE_ID + " INTEGER" +
				ActivityContract.ActivityEntry.COLUMN_NAME_LOCATION + " TEXT" +
				ActivityContract.ActivityEntry.COLUMN_NAME_USER_ID + " INTEGER)");
	}

	@Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+ ActivityContract.ActivityEntry.TABLE_NAME);
		onCreate(db);
	}
}
