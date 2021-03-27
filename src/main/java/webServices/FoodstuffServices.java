package webServices;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

import foodstuff.FoodStuff;

import javax.ws.rs.Path;

@Path("foodstuffs")
public class FoodstuffServices {
	static ArrayList<FoodStuff> FoodStuffs = null;
	
	public ArrayList<FoodStuff> getFoodstuffs() {
		return FoodStuffs;	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<FoodStuff> getAllFoodstuffs() {
		return FoodStuffs;
	}
}
