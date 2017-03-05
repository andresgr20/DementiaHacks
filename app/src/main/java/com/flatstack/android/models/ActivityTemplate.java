package com.flatstack.android.models;

import java.util.Date;

/**
 * Created by Aaron on 2017-03-04.
 */

public class ActivityTemplate {
	private long _id;
	private String name;
	private String description;
	private long creatorId;
	private long patientId;
	private String idealLocation;
	private Date timeStarted;

	public ActivityTemplate(long _id, String name, String description, long patientId, long creatorId, String idealLocation, Date timeStarted) {
		this.set_id(_id);
		this.name = name;
		this.description = description;
		this.setPatientId(patientId);
		this.setCreatorId(creatorId);
		this.idealLocation = idealLocation;
		this.timeStarted = timeStarted;
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

	public void set_id(long _id) {
		this._id = _id;
	}

	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public long get_id() {
		return _id;
	}

	public long getCreatorId() {
		return creatorId;
	}
}
