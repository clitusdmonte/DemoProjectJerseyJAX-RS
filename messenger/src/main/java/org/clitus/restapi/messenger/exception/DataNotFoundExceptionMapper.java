package org.clitus.restapi.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.clitus.restapi.messenger.model.ErrorMessage;

//@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404, "http://www.queenkitchen.in/");
		return Response.status(Status.NOT_FOUND).entity(errorMessage)
				.build();
	}

}
