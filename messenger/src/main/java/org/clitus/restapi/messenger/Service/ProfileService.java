package org.clitus.restapi.messenger.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.clitus.restapi.messenger.database.DatabaseClass;
import org.clitus.restapi.messenger.model.Profile;

public class ProfileService {

	private static Map<String, Profile> profiles = DatabaseClass.getProfiles();
	

	public ProfileService() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		profiles.put("clitus", new Profile(1L, "clitus", "clitus", "dmonte", date));
		profiles.put("archi", new Profile(2L, "archi", "archi", "dsouza", date));

	}

	public List<Profile> getAllProfiles() {

		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);

	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;

	}

	public Profile updateProfile(Profile profile) {
		if (profile.getId() <= 0) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;

	}

	public Profile removeProfile(String profileName) {

		return profiles.remove(profileName);

	}

}
