
package com.innovadeltech.account.rest;

import java.util.List;
import java.util.NoSuchElementException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.innovadeltech.account.model.AccountHolder;
import com.innovadeltech.account.service.AccountHolderService;
import com.innovadeltech.account.service.AccountHolderServiceImpl;

@Path("/account/json")
public class AccountHolderRestService {
	private AccountHolderService accountHolderService;
    
	public AccountHolderRestService() {
		accountHolderService = new AccountHolderServiceImpl();
	}
    
	@GET
	@Path("/{accountHolderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountHolderById(@PathParam("accountHolderId") Integer accountHolderId) {
		String message = null;
		Status status;
		try {
			AccountHolder accountHolder = accountHolderService.getAccountHolder(accountHolderId);
			
			GenericEntity<AccountHolder> genericEntity = new GenericEntity<AccountHolder>(accountHolder) {
	        };
			
			return Response.ok(genericEntity)
	            .build();
		} catch (IllegalArgumentException ex){
			message = "Account Holder could not be found due to missing parameters";
			status = Response.Status.BAD_REQUEST;
			
    	} catch (NoSuchElementException ex) {
    		message = "Account Holder could not be found with provided ID";
			status = Response.Status.NOT_FOUND;
    	}
		
		return Response.status(status)
                .entity(message)
                .build();
    }
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountHolder> getAllAccountHolders() {
        return accountHolderService.getAccountHolders();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/html")
    public String addAccountHolder(AccountHolder accountHolder) {
    	try {
    		accountHolderService.add(accountHolder);
    	} catch(IllegalArgumentException ex){
    		return "Account could not be created due to missing parameters";
    	}
    	
		return "Account has been successfully added";
    }
    
    @DELETE
    @Path("/{accountHolderId}")
    @Produces("text/html")
    public String deleteAccountholder(@PathParam("accountHolderId") Integer accountHolderId) {
    	String message = "Account has been deleted successfully";
    	
    	try {
    		boolean result = accountHolderService.delete(accountHolderId);
    		if (!result) {
    			message = "Account could not found to be deleted";
    		}
    	} catch(IllegalArgumentException ex){
    		message = "Account could not be deleted due to missing parameters";
    	}
    	
    	return message;
    }
}
