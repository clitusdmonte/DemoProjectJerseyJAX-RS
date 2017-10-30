package org.clitus.restapi.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	private long id;
	private String profileName;
	private String firstName;
	private String plastName;
	private Date created;
	
	public Profile() {
	}
	
	public Profile(long id, String profileName, String firstName, String plastName, Date created) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.plastName = plastName;
		this.created = created;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPlastName() {
		return plastName;
	}
	public void setPlastName(String plastName) {
		this.plastName = plastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
