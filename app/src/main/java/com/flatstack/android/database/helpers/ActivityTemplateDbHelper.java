package com.flatstack.android.database.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.flatstack.android.database.contracts.ActivityTemplateContract.ActivityTemplateEntry;


public class ActivityTemplateDbHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "ActivityTemplate.db";
	public ActivityTemplateDbHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+ ActivityTemplateEntry.TABLE_NAME + " (" +
				ActivityTemplateEntry._ID + " INTEGER PRIMARY KEY" +
				ActivityTemplateEntry.COLUMN_NAME_NAME + " TEXT" +
				ActivityTemplateEntry.COLUMN_NAME_DESCRIPTION + " TEXT" +
				ActivityTemplateEntry.COLUMN_NAME_IDEAL_LOCATION + " TEXT" +
				ActivityTemplateEntry.COLUMN_NAME_PATIENT_ID + " INTEGER" +
				ActivityTemplateEntry.COLUMN_NAME_TIME_STARTED + " DATETIME" +
				ActivityTemplateEntry.COLUMN_NAME_CREATOR_ID + " INTEGER)");
	}

	@Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+ ActivityTemplateEntry.TABLE_NAME);
		onCreate(db);
	}

	public long insert(String name, String description, String patientId, String creatorId) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(ActivityTemplateEntry.COLUMN_NAME_CREATOR_ID, creatorId);
		values.put(ActivityTemplateEntry.COLUMN_NAME_DESCRIPTION, description);
		values.put(ActivityTemplateEntry.COLUMN_NAME_PATIENT_ID, patientId);
		values.put(ActivityTemplateEntry.COLUMN_NAME_NAME, name);
		long newRowId = db.insert(ActivityTemplateEntry.TABLE_NAME, null, values);
		return newRowId;
	}
}
