package org.clitus.restapi.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.clitus.restapi.messenger.model.Message;
import org.clitus.restapi.messenger.model.Profile;

public class DatabaseClass {
	private static Map<Long,Message> message= new HashMap<>(); 
	private static Map<String,Profile> profiles= new HashMap<>();
	
	public static Map<Long, Message> getMessage() {
		return message;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	} 
	
	

}
