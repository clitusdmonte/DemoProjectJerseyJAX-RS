package org.clitus.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.clitus.restapi.messenger.Service.ProfileService;
import org.clitus.restapi.messenger.model.Profile;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	private ProfileService profileService =  new ProfileService();
	
	
	
	@GET
	public 	List<Profile> getAllProfiles(){
		return profileService.getAllProfiles();
	}
	
	@GET
    @Path("/{profileName}")
	public 	Profile getMessage(@PathParam("profileName") String name){
		return profileService.getProfile(name);
	}
	
	@POST
    public List<Profile> addProfile(Profile profile){
		profileService.addProfile(profile);
		return profileService.getAllProfiles();
    }
    
    @PUT
    @Path("/{profileName}")
    public List<Profile> putProfile(@PathParam("profileName") String name ,Profile profile){
    	profile.setProfileName(name);
    	profileService.updateProfile(profile);
		return profileService.getAllProfiles();
    }
    
    @DELETE
    @Path("/{profileName}")
    public List<Profile> deleteProfile(@PathParam("profileName") String name){
    	profileService.removeProfile(name);
		return profileService.getAllProfiles();
    }

}
