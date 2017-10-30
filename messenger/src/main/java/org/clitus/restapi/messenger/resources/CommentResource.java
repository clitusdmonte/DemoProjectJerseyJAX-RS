package org.clitus.restapi.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

//sub resource class

@Path("/")
public class CommentResource {
	@GET
	public String test(){
		return "test";
		
	}
	
	@GET
	@Path("/{commentId}")
	public String getComments(@PathParam("messageId") String messageId , @PathParam("commentId") String commentId){
		return commentId+" message id"+messageId;
		
	}

}
