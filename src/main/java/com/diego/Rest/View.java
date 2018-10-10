package com.diego.Rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.diego.Core.DBController;
import com.diego.Entities.City;
import com.diego.Entities.Country;
import com.diego.Entities.Menu;
import com.diego.Entities.MenuItem;
import com.diego.Entities.Restaurant;

@Path("/view")
public class View {

	//GET ALL METHODS
	
	@Path("/countries")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCountries(){
		ArrayList<Country> countries = DBController.getInstance().getAllCountries();
		if(countries != null) {
			return Response.ok(countries).build();
		}
		return Response.serverError().build();
	}
	
	@Path("/cities")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCities() {
		ArrayList<City> cities = DBController.getInstance().getAllCities();
		if(cities != null) {
			return Response.ok(cities).build();
		}
		return Response.serverError().build();
	}
	
	@Path("/restaurants")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRestaurants() {
		ArrayList<Restaurant> restaurants = DBController.getInstance().getAllRestaurants();
		if(restaurants != null) {
			return Response.ok(restaurants).build();
		}
		return Response.serverError().build();
	}
	
	@Path("/menus")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMenus() {
		ArrayList<Menu> menus = DBController.getInstance().getAllMenus();
		if(menus != null) {
			return Response.ok(menus).build();
		}
		return Response.serverError().build();
	}

	@Path("/menuitems")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMenuItems() {
		ArrayList<MenuItem> menuItems = DBController.getInstance().getAllMenuItems();
		if(menuItems != null) {
			return Response.ok(menuItems).build();
		}
		return Response.serverError().build();
	}

	//GET ALL FROM PARENT

	@Path("/cities/{countryID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCitiesInCountry(@PathParam("countryID") int countryID) {
		ArrayList<City> cities = DBController.getInstance().getCitiesIn(countryID);
		if(cities != null) {
			return Response.ok(cities).build();
		}
		return Response.serverError().build();
	}

	@Path("/restaurants/{cityID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRestaurantsInCty(@PathParam("cityID") int cityID) {
		ArrayList<Restaurant> restaurants = DBController.getInstance().getRestaurantsIn(cityID);
		if(restaurants != null) {
			return Response.ok(restaurants).build();
		}
		return Response.serverError().build();
	}

	@Path("/menus/{restaurantID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuInRestaurant(@PathParam("restaurantID") int restaurantID) {
		ArrayList<Menu> menus = DBController.getInstance().getMenusIn(restaurantID);
		if(menus != null) {
			return Response.ok(menus).build();
		}
		return Response.serverError().build();
	}

	@Path("menuitems/{menuID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItemsInMenu(@PathParam("menuID") int menuID) {
		ArrayList<MenuItem> menuItems = DBController.getInstance().getItemsIn(menuID);
		if(menuItems != null) {
			return Response.ok(menuItems).build();
		}
		return Response.serverError().build();
	}

	//Get Specific
	@Path("/country/{countryID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCountry(@PathParam("countryID") int countryID) {
		Country country = DBController.getInstance().getCountry(countryID);
		if(country != null) {
			return Response.ok(country).build();
		}
		return Response.serverError().build();
	}

	@Path("/city/{cityID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCity(@PathParam("cityID") int cityID) {
		City city = DBController.getInstance().getCity(cityID);
		if(city != null) {
			return Response.ok(city).build();
		}
		return Response.serverError().build();
	}
	
	@Path("/restaurant/{restaurantID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRestaurant(@PathParam("restaurantID") int restaurantID) {
		Restaurant restaurant = DBController.getInstance().getRestaurant(restaurantID);
		if(restaurant != null) {
			return Response.ok(restaurant).build();
		}
		return Response.serverError().build();
	}

	@Path("/menu/{menuID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenu(@PathParam("menuID") int menuID) {
		Menu menu = DBController.getInstance().getMenu(menuID);
		if(menu != null) {
			return Response.ok(menu).build();
		}
		return Response.serverError().build();
		
	}
	
	@Path("/menuitem/{itemID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuItem(@PathParam("itemID") int itemID) {
		MenuItem menuItem = DBController.getInstance().getMenuItem(itemID);
		if(menuItem != null) {
			return Response.ok(menuItem).build();
		}
		return Response.serverError().build();
	}

}
