package org.clitus.restapi.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.clitus.restapi.messenger.Service.MessageService;
import org.clitus.restapi.messenger.exception.DataNotFoundException;
import org.clitus.restapi.messenger.model.Message;
import org.clitus.restapi.messenger.resources.beans.MessageFilterBean;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public class MessageResource {
	private MessageService messageService =  new MessageService();
	
	  /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean messageFilterBean) {
		if (messageFilterBean.getYear() > 0) {
			return messageService.getAllMessageForYear(messageFilterBean.getYear());
		}
		if (messageFilterBean.getStart() >= 0 && messageFilterBean.getSize() >= 0) {
			return messageService.getAllMessagePaginated(messageFilterBean.getStart(), messageFilterBean.getSize());
		}
		return messageService.getAllMessage();
	}

    @GET
    @Path("/{messageId}")
	public 	Message getMessage(@PathParam("messageId") Long messageId) throws DataNotFoundException{
		return messageService.getMessage(messageId);
	}
    
   /* @POST
    public List<Message> addMessage(Message msg){
    	messageService.addMessage(msg);
		return messageService.getAllMessage();
    }*/
    @POST
    public Response addMessage(Message msg, @Context UriInfo uriInfo) throws URISyntaxException{
    	Message newMsg=	messageService.addMessage(msg);
    	//Response.status(Status.CREATED).entity(newMsg).build();
    	URI uri =  uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMsg.getId())).build();
		return Response.created(uri).entity(newMsg).build();
    }
    
    @PUT
    @Path("/{messageId}")
    public List<Message> putMessage(@PathParam("messageId") Long id ,Message msg){
    	msg.setId(id);
    	messageService.updateMessage(msg);
		return messageService.getAllMessage();
    }
    
    @DELETE
    @Path("/{messageId}")
    public List<Message> deleteMessage(@PathParam("messageId") Long id){
    	messageService.removeMessage(id);
		return messageService.getAllMessage();
    }

  //sub resource class mapping from parent class

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource(){
		return new CommentResource();
    	
    }
       
}
