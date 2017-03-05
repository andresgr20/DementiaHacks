package com.flatstack.android.models;

import java.util.Date;

/**
 * Created by Aaron on 2017-03-04.
 */

public class ActivityTemplate {
	private int _id;
	private String name;
	private String description;
	private int creatorId;
	private String idealLocation;
	private Date timeStarted;

	public ActivityTemplate(int _id, String name, String description, int creatorId, String idealLocation, Date timeStarted) {
		this._id = _id;
		this.name = name;
		this.description = description;
		this.creatorId = creatorId;
		this.idealLocation = idealLocation;
		this.timeStarted = timeStarted;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public String getIdealLocation() {
		return idealLocation;
	}

	public void setIdealLocation(String idealLocation) {
		this.idealLocation = idealLocation;
	}

	public Date getTimeStarted() {
		return timeStarted;
	}

	public void setTimeStarted(Date timeStarted) {
		this.timeStarted = timeStarted;
	}
}
