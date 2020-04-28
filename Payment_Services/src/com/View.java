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

@Path("/payments")
public class View {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetPayment() {
		return Response.ok().entity(PaymentController.readItems()).build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	public Response postMessage(List<Payment> list) {
		return Response.ok().entity(PaymentController.insertItem(list.get(0))).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateItem(List<Payment> list) {
		return Response.ok().entity(PaymentController.updateItem(list.get(0))).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteItem(List<Payment> list) {
		return Response.ok().entity(PaymentController.deleteItem(list.get(0))).build();
	}
}