package com.poc.resful.jersey;

import com.poc.resful.jersey.entities.Item;
import com.poc.resful.jersey.namebinder.IteamIdAndNameBinder;
import com.poc.resful.jersey.namebinder.IteamPriceBinder;
import com.poc.resful.jersey.namebinder.ItemDiscriptionBinder;
import com.poc.resful.jersey.namebinder.ItemIdVaidatorBinder;
import com.poc.resful.jersey.namebinder.UniqueItemId;
import com.poc.resful.jersey.services.ItemService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/item-resource")
public class ItemResource {
	
	private ItemService itemService = new ItemService();

	@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@RolesAllowed("PRODUCER")
	@ItemDiscriptionBinder
	@IteamPriceBinder
	@IteamIdAndNameBinder
	@ItemIdVaidatorBinder
	@Path("/create")
    public Response addItem(@Valid @UniqueItemId Item item) {       
		itemService.addItem(item);
        return Response.status(Status.CREATED).entity("Item Created").build();
    }
	
	@PUT
    @Path("/item/{itemId}")
	@RolesAllowed("PRODUCER")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateItem(@PathParam("itemId") long itemId, Item item) {
		 itemService.updateItem(item, itemId);
         return Response.noContent().build();
    }

    @GET
    @Path("/item/search")
    @RolesAllowed({"PRODUCER", "CONSUMER"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("itemId") String itemId,
    	            	@QueryParam("name") String name) {
        return Response.ok().entity(itemService.getItemByIdOrName(itemId , name)).build();
    }
 
    
    @DELETE
    @RolesAllowed("PRODUCER")
    @Path("/item/{itemId}")
    public Response deleteItem(@PathParam("itemId") String itemId) {
    	itemService.deleteItem(itemId);
        return Response.status(202).entity("Item deleted successfully !!").build();
    }

}
