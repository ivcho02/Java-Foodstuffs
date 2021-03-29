package webServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

import foodstuff.FoodStuff;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("foodstuffs")
public class FoodstuffServices {
	static ArrayList<FoodStuff> FoodStuffs = new ArrayList();
	
	public ArrayList<FoodStuff> getFoodstuffs() {
		return FoodStuffs;	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<FoodStuff> getAllFoodstuffs() {
		return FoodStuffs;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<FoodStuff> addUser(@Context HttpServletRequest request, FoodStuff newFoodStuff) {
		// int lastUserIndex = ;    	
    	int nextAvailableID = FoodStuffs.size() + 1;
    	
    	newFoodStuff.setId(nextAvailableID); 
    	
		FoodStuffs.add(newFoodStuff);
		
		HttpSession session = request.getSession();
		
		session.setMaxInactiveInterval(24124241);
		session.setAttribute("foodstuffs", FoodStuffs);
		
    	return FoodStuffs;
	}
	
	@DELETE
	@Path("/{name}")
	public void deleteFoodstuff(@Context HttpServletRequest request, @PathParam("name") int id) {
		HttpSession session = request.getSession();
		
		for (FoodStuff foodstuff : FoodStuffs) {
			if (foodstuff.getId() == id) {
				FoodStuffs.remove(foodstuff);
					break;
			}
		}
		
		session.setAttribute("foodstuffs", FoodStuffs);
	}

}
