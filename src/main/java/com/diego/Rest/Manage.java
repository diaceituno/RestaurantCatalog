package com.diego.Rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.diego.Core.DBController;
import com.diego.Entities.City;
import com.diego.Entities.Country;
import com.diego.Entities.Menu;
import com.diego.Entities.MenuItem;
import com.diego.Entities.Restaurant;

@Path("/manage")
public class Manage {
	
	/*POST*/
	@Path("/countries")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveCountry(Country country) {
		if(DBController.getInstance().saveCountry(country)) {
			return Response.ok(country).build();
		}
		return Response.serverError().build();
	}
	
	@Path("/cities")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveCity(City city) {
		if(DBController.getInstance().saveCity(city)) {
			return Response.ok(city).build();
		}
		return Response.serverError().build();
	}
	
	@Path("/restaurants")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveRestaurant(Restaurant restaurant) {
		if(DBController.getInstance().saveRestaurant(restaurant)) {
			return Response.ok(restaurant).build();
		}
		return Response.serverError().build();
	}

	@Path("/menus")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMenu(Menu menu) {
		if(DBController.getInstance().saveMenu(menu)) {
			return Response.ok(menu).build();
		}
		return Response.serverError().build();
	}
	
	@Path("/menuitems")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMenuItem(MenuItem menuItem) {
		if(DBController.getInstance().saveMenuItem(menuItem)) {
			return Response.ok(menuItem).build();
		}
		return Response.serverError().build();
	}
	
	/*DELETE*/
	@Path("/countries")
	@DELETE
	public Response deleteCountry(@DefaultValue("0") @QueryParam("id") int countryID) {
		if(DBController.getInstance().deleteCountry(countryID)) {
			return Response.ok().build();
		}
		return Response.serverError().build();
	}
	
	@Path("/cities")
	@DELETE
	public Response deleteCity(@DefaultValue("0") @QueryParam("id") int cityID) {
		if(DBController.getInstance().deleteCity(cityID)) {
			return Response.ok().build();
		}
		return Response.serverError().build();
	}

	@Path("/restaurants")
	@DELETE
	public Response deleteRestaurant(@DefaultValue("0") @QueryParam("id") int restaurantID) {
		if(DBController.getInstance().deleteRestaurant(restaurantID)) {
			return Response.ok().build();
		}
		return Response.serverError().build();
	}

	@Path("/menus")
	@DELETE
	public Response deleteMenu(@DefaultValue("0") @QueryParam("id") int menuID) {
		if(DBController.getInstance().deleteMenu(menuID)) {
			return Response.ok().build();
		}
		return Response.serverError().build();
	}

	@Path("/menuitems")
	@DELETE
	public Response deleteMenuItem(@DefaultValue("0") @QueryParam("id") int menuItemID) {
		if(DBController.getInstance().deleteMenuItem(menuItemID)) {
			return Response.ok().build();
		}
		return Response.serverError().build();
	}

	/*UPDATE*/
	@Path("/countries")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCountry(Country country) {
		if(DBController.getInstance().updateCountry(country)) {
			return Response.ok(country).build();
		}
		return Response.serverError().build();
	}

	@Path("cities")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCity(City city) {
		if(DBController.getInstance().updateCity(city)) {
			return Response.ok(city).build();
		}
		return Response.serverError().build();
	}

	@Path("/restaurants")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRestaurant(Restaurant restaurant) {
		if(DBController.getInstance().updateRestaurant(restaurant)) {
			return Response.ok(restaurant).build();
		}
		return Response.serverError().build();
	}
	
	@Path("/menus")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMenu(Menu menu) {
		if(DBController.getInstance().updateMenu(menu)) {
			return Response.ok(menu).build();
		}
		return Response.serverError().build();
	}

	@Path("/menuitems")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMenuItem(MenuItem menuItem) {
		if(DBController.getInstance().updateMenuItem(menuItem)) {
			return Response.ok(menuItem).build();
		}
		return Response.serverError().build();
	}
}
