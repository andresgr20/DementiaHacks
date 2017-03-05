package com.flatstack.android.models;

/**
 * Created by Aaron on 2017-03-04.
 */

public class Activity {
	private int _id;
	private String location;
	private int activityTemplateId;

	public Activity(int _id, String location, int activityTemplateId) {
		this.set_id(_id);
		this.setLocation(location);
		this.setActivityTemplateId(activityTemplateId);
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getActivityTemplateId() {
		return activityTemplateId;
	}

	public void setActivityTemplateId(int activityTemplateId) {
		this.activityTemplateId = activityTemplateId;
	}
}
