package com.flatstack.android.database.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.flatstack.android.database.contracts.ActivityContract.ActivityEntry;
import com.flatstack.android.models.Activity;
import com.flatstack.android.models.ActivityTemplate;

import java.util.ArrayList;
import java.util.List;

public class ActivityDbHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "Activity.db";
	private static final String[] projection = {
			ActivityEntry._ID,
			ActivityEntry.COLUMN_NAME_LOCATION,
			ActivityEntry.COLUMN_NAME_ACTIVITY_TEMPLATE_ID
	};
	private static ActivityTemplateDbHelper activityTemplateDbHelper;

	public ActivityDbHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
		activityTemplateDbHelper = new ActivityTemplateDbHelper(context);
	}

	@Override public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + ActivityEntry.TABLE_NAME + " (" +
				ActivityEntry._ID + " INTEGER PRIMARY KEY, " +
				ActivityEntry.COLUMN_NAME_ACTIVITY_TEMPLATE_ID + " INTEGER, " +
				ActivityEntry.COLUMN_NAME_LOCATION + " TEXT, " +
				ActivityEntry.COLUMN_NAME_USER_ID + " INTEGER)");
	}

	@Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + ActivityEntry.TABLE_NAME);
		onCreate(db);
	}

	public long insert(String userId, String location, ActivityTemplate activityTemplate) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(ActivityEntry.COLUMN_NAME_USER_ID, userId);
		values.put(ActivityEntry.COLUMN_NAME_LOCATION, "");
		values.put(ActivityEntry.COLUMN_NAME_ACTIVITY_TEMPLATE_ID, activityTemplate.get_id());
		long newRowId = db.insert(ActivityEntry.TABLE_NAME, null, values);
		return newRowId;
	}

	public List<Activity> getActivies(long userId) throws Exception {
		String selection = ActivityEntry.COLUMN_NAME_USER_ID + " = ?";
		String[] selectionsArgs = { Long.valueOf(userId).toString() };
		return getActivities(selection, selectionsArgs);
	}

	public Activity getActivity(long _id) throws Exception {
		String selection = ActivityEntry._ID + " = ?";
		String[] selectionsArgs = { Long.valueOf(_id).toString() };
		return getActivities(selection, selectionsArgs).get(0);
	}

	private List<Activity> getActivities(String selection, String[] selectionsArgs) throws Exception {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(
				ActivityEntry.TABLE_NAME,
				projection,
				selection,
				selectionsArgs,
				null,
				null,
				null
		);
		List<Activity> templates = new ArrayList<>();
		while (cursor.moveToNext()) {
			long _id = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityEntry._ID));
			ActivityTemplate template = activityTemplateDbHelper.getActivityTemplateByID(
					cursor.getLong(cursor.getColumnIndexOrThrow(ActivityEntry.COLUMN_NAME_ACTIVITY_TEMPLATE_ID))
			);
			String location = cursor.getString(cursor.getColumnIndexOrThrow(ActivityEntry.COLUMN_NAME_LOCATION));
			long userId = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityEntry.COLUMN_NAME_USER_ID));
			templates.add(new Activity(_id, userId, location, template));
		}
		cursor.close();
		return templates;
	}
}
