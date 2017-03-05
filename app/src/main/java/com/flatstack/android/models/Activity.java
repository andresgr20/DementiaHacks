package com.flatstack.android.models;

/**
 * Created by Aaron on 2017-03-04.
 */

public class Activity {
	private long _id;
	private long userId;
	private String location;
	private ActivityTemplate activityTemplate;

	public Activity(long _id, long userId, String location, ActivityTemplate activityTemplate) {
		this.set_id(_id);
		this.setUserId(userId);
		this.setLocation(location);
		this.setActivityTemplate(activityTemplate);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public ActivityTemplate getActivityTemplate() {
		return activityTemplate;
	}

	public void setActivityTemplate(ActivityTemplate activityTemplate) {
		this.activityTemplate = activityTemplate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
