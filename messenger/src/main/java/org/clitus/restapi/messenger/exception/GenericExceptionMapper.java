package org.clitus.restapi.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.clitus.restapi.messenger.model.ErrorMessage;
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{
	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "http://www.queenkitchen.in/");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage)
				.build();
	}

}
