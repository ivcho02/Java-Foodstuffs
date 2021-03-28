package webServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

import foodstuff.FoodStuff;

import javax.ws.rs.Path;

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
		FoodStuffs.add(newFoodStuff);
		
		HttpSession session = request.getSession();
		
		session.setMaxInactiveInterval(2000000);
		session.setAttribute("foodstuffs", FoodStuffs);
		
    	return FoodStuffs;
	}
}
