package org.clitus.restapi.messenger.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	//http://localhost:8080/messenger/webapi/injectdemo/annotations;param=value
	
	@GET
	@Path("/annotations")
	public String getParamsUsingAnotations(@MatrixParam("param") String matrixParam, @HeaderParam("hparam") String hparam, @CookieParam("JSESSIONID") String cparam){
		
		return "matrix Param= "+matrixParam +"  header Param= "+hparam +"  cookie param = "+cparam;

	
		
	}
	@GET
	@Path("/context")
	public String getParamsUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders httpHeaders){
		String path = uriInfo.getPathParameters().toString(); 
		
		return path +httpHeaders.getCookies().toString();
		
	}
	
	//@FormParam - when you what to access form submissions

}
