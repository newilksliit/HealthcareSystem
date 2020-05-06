////////////////////////		File History			//////////////////
//------------------------------------------------------------------------
//Date		User			Description
//--------	-----------		----------------------------------------------
//05/05/20	IT16109254		Created
//////////////////////////////////////////////////////////////////////////
package com;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.Payment;

@Path("/paymentAPI")
public class PaymentAPI {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetPayments() {
		return Response.ok().entity(PaymentController.readItems()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postMessage(Payment p) {
		return PaymentController.insertItem(p);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response putMessage(Payment p) {
		return PaymentController.updateItem(p);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteMessage(Payment p) {
		return PaymentController.deleteItem(p);
	}
}