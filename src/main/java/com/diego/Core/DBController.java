package com.diego.Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.diego.Entities.City;
import com.diego.Entities.Country;
import com.diego.Entities.Menu;
import com.diego.Entities.MenuItem;
import com.diego.Entities.Restaurant;

public class DBController {

	//MySQL Credentials
	static final String CRED = "restaurants";
	static final String DBURL = "jdbc:mysql://localhost/restaurants";
	
	//MySQL Connection
	static Connection connection;
	
	//Singleton Pattern----------------------------
	private static DBController dbController;
	
	private DBController(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DBController getInstance() {
		
		if(dbController == null) {
			dbController = new DBController();
		}
		return dbController;
	}
	/*--------------------------------------------*/

	//Connection Methods 
	private void connect() {
		try {
			connection = DriverManager.getConnection(DBURL,CRED,CRED);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*--------------------------------------------*/
	
	//Saving Methods
	
	public boolean saveCountry(Country country) {
		
		String query = "insert into countries values(null,'" + country.getCountryName() + "')";
		connect();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query,Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();
				rs.next();
				country.setCountryID(rs.getInt(1));
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		disconnect();
		return true;
	}

	public boolean saveCity(City city) {
		
		String query = "insert into cities values(null,'" + city.getCityName() + "'," + city.getCountryID() + ")";
		connect();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query,Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();
				rs.next();
				city.setCityID(rs.getInt(1));
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		disconnect();
		
		return true;
	}

	public boolean saveRestaurant(Restaurant restaurant) {
		
		String query = "insert into restaurants values(null,'" + restaurant.getRestaurantName() + "'," 
						+ restaurant.getCityID() + ",'" + restaurant.getAddress() + "','" + restaurant.getTelephone() 
						+ "','" + restaurant.getWebsite() + "','" + restaurant.getEmail() + "')";
		connect();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query,Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();
				rs.next();
				restaurant.setRestaurantID(rs.getInt(1));
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		disconnect();
		
		return true;
	}

	public boolean saveMenu(Menu menu) {
		
		String query = "insert into menus values(null,'" + menu.getMenuName() + "'," + menu.getRestaurantID() + ")";
		connect();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query,Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();
				rs.next();
				menu.setMenuID(rs.getInt(1));
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		disconnect();
		return true;
	}

	public boolean saveMenuItem(MenuItem menuItem) {
		
		String query = "insert into menuitems values(null,'" + menuItem.getItemName() + "','" + menuItem.getItemDesc() + "',"
						+ menuItem.getPrice() + "," + menuItem.getMenuID() + ")";
		connect();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query,Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();
				rs.next();
				menuItem.setItemID(rs.getInt(1));
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		disconnect();
		return true;
	}

	//Deleting Methods
	public boolean deleteCountry(int countryID) {
		
		String query = "delete from countries where ID=" + countryID;
		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		disconnect();
		return true;
	}

	public boolean deleteCity(int cityID) {
		String query = "delete from cities where ID=" + cityID;
		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		disconnect();
		return true;
	}

	public boolean deleteRestaurant(int restaurantID) {
		
		String query = "delete from restaurants where ID=" + restaurantID;
		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		disconnect();
		return true;
	}
	
	public boolean deleteMenu(int menuID) {
		
		String query = "delete from menus where ID=" + menuID;
		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		disconnect();
		return true;
	}

	public boolean deleteMenuItem(int menuItemID) {
		
		String query = "delete from menuitems where ID=" + menuItemID;
		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		disconnect();
		return true;	
	}

	//Updating Methods
	public boolean updateCountry(Country country) {
		if(getCountry(country.getCountryID()) == null) {
			return false;
		}
		String query = "update countries set Name='" + country.getCountryName() + "' where ID=" + country.getCountryID() ;
		connect();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		disconnect();
		return true;
	}

	public boolean updateCity(City city) {
		if(getCity(city.getCityID()) == null) {
			return false;
		}
		String query = "update cities set Name='" + city.getCityName() + "',countryID=" + city.getCountryID();
		connect();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		disconnect();
		return true;
	}

	public boolean updateRestaurant(Restaurant restaurant) {
		if(getRestaurant(restaurant.getRestaurantID()) == null) {
			return false;
		}
		String query = "update restaurants set Name='" + restaurant.getRestaurantName() + "',cityID=" + restaurant.getCityID()
						+ ",Address='" + restaurant.getAddress() + "',Telephone='" + restaurant.getTelephone() 
						+ "',Website='" + restaurant.getWebsite() + "',Email='" + restaurant.getEmail() + "'"
						+ " where ID=" + restaurant.getRestaurantID();
		
		connect();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		disconnect();
		return true;
	}

	public boolean updateMenu(Menu menu) {
		if(getMenu(menu.getMenuID()) == null) {
			return false;
		}
		String query = "update menus set Name='" + menu.getMenuName() + "', restaurantID=" + menu.getRestaurantID()
						+ " where ID=" + menu.getMenuID();
		connect();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		disconnect();
		return true;
	}

	public boolean updateMenuItem(MenuItem menuItem) {
		if(getMenuItem(menuItem.getItemID()) == null) {
			return false;
		}
		String query = "update menuitems set Name='" + menuItem.getItemName() + "', Description='" 
						+ menuItem.getItemDesc() + "', price=" + menuItem.getPrice() + ", menuID=" + menuItem.getMenuID()
						+ " where ID=" + menuItem.getItemID();
		connect();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if(statement != null) {
			try {
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		disconnect();
		return true;
	}

	//Query All
	public ArrayList<Country> getAllCountries(){
		
		String query = "select * from countries";
		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(statement != null) {
			ResultSet rs = null;
			try {
				rs = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(rs != null) {
				ArrayList<Country> retList = new ArrayList<Country>();
				try {
					while(rs.next()) {
						
						Country country = new Country();
						country.setCountryID(rs.getInt("ID"));
						country.setCountryName(rs.getString("Name"));
						retList.add(country);
					}
					return retList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public ArrayList<City> getAllCities(){
		
		String query = "select * from cities";
		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(statement != null) {
			ResultSet rs = null;
			try {
				rs = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(rs != null) {
				ArrayList<City> retList = new ArrayList<City>();
				try {
					while(rs.next()) {
						
						City city = new City();
						city.setCityID(rs.getInt("ID"));
						city.setCityName(rs.getString("Name"));
						city.setCountryID(rs.getInt("CountryID"));
						retList.add(city);
					}
					return retList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
 	public ArrayList<Restaurant> getAllRestaurants(){
		
		String query = "select * from restaurants";
		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(statement != null) {
			ResultSet rs = null;
			try {
				rs = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(rs != null) {
				ArrayList<Restaurant> retList = new ArrayList<Restaurant>();
				try {
					while(rs.next()) {
						
						Restaurant restaurant = new Restaurant();
						restaurant.setRestaurantID(rs.getInt("ID"));
						restaurant.setRestaurantName(rs.getString("Name"));
						restaurant.setCityID(rs.getInt("CityID"));
						restaurant.setAddress(rs.getString("Address"));
						restaurant.setTelephone(rs.getString("Telephone"));
						restaurant.setWebsite(rs.getString("Website"));
						restaurant.setEmail(rs.getString("Email"));
						retList.add(restaurant);
					}
					return retList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

 	public ArrayList<Menu> getAllMenus(){
 		String query = "select * from menus";
 		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(statement != null) {
			ResultSet rs = null;
			try {
				rs = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(rs != null) {
				ArrayList<Menu> retList = new ArrayList<Menu>();
				try {
					while(rs.next()) {
						
						Menu menu = new Menu();
						menu.setMenuID(rs.getInt("ID"));
						menu.setMenuName(rs.getString("Name"));
						menu.setRestaurantID(rs.getInt("restaurantID"));
						retList.add(menu);
					}
					return retList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
 	}

 	public ArrayList<MenuItem> getAllMenuItems(){
 		
 		String query = "select * from menuitems";
 		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(statement != null) {
			ResultSet rs = null;
			try {
				rs = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(rs != null) {
				ArrayList<MenuItem> retList = new ArrayList<MenuItem>();
				try {
					while(rs.next()) {
						
						MenuItem menuItem = new MenuItem();
						menuItem.setItemID(rs.getInt("ID"));
						menuItem.setItemName(rs.getString("Name"));
						menuItem.setItemDesc(rs.getString("Description"));
						menuItem.setPrice(rs.getDouble("price"));
						menuItem.setMenuID(rs.getInt("menuID"));
						retList.add(menuItem);
					}
					return retList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
 	}

 	//Query All in Parent
 	public ArrayList<City> getCitiesIn(int countryID){
		
		String query = "select * from cities where countryID=" + countryID;
		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(statement != null) {
			ResultSet rs = null;
			try {
				rs = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(rs != null) {
				ArrayList<City> retList = new ArrayList<City>();
				try {
					while(rs.next()) {
						
						City city = new City();
						city.setCityID(rs.getInt("ID"));
						city.setCityName(rs.getString("Name"));
						city.setCountryID(rs.getInt("CountryID"));
						retList.add(city);
					}
					return retList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
 	}

 	public ArrayList<Restaurant> getRestaurantsIn(int cityID){
		
		String query = "select * from restaurants where CityID=" + cityID;
		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(statement != null) {
			ResultSet rs = null;
			try {
				rs = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(rs != null) {
				ArrayList<Restaurant> retList = new ArrayList<Restaurant>();
				try {
					while(rs.next()) {
						
						Restaurant restaurant = new Restaurant();
						restaurant.setRestaurantID(rs.getInt("ID"));
						restaurant.setRestaurantName(rs.getString("Name"));
						restaurant.setCityID(rs.getInt("CityID"));
						restaurant.setAddress(rs.getString("Address"));
						restaurant.setTelephone(rs.getString("Telephone"));
						restaurant.setWebsite(rs.getString("Website"));
						restaurant.setEmail(rs.getString("Email"));
						retList.add(restaurant);
					}
					return retList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;	
 	}

 	public ArrayList<Menu> getMenusIn(int restaurantID){
 		String query = "select * from menus where restaurantID=" + restaurantID;
 		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(statement != null) {
			ResultSet rs = null;
			try {
				rs = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(rs != null) {
				ArrayList<Menu> retList = new ArrayList<Menu>();
				try {
					while(rs.next()) {
						
						Menu menu = new Menu();
						menu.setMenuID(rs.getInt("ID"));
						menu.setMenuName(rs.getString("Name"));
						menu.setRestaurantID(rs.getInt("restaurantID"));
						retList.add(menu);
					}
					return retList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;	
 	}

 	public ArrayList<MenuItem> getItemsIn(int menuID){
 		
 		String query = "select * from menuitems where menuID=" + menuID;
 		connect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(statement != null) {
			ResultSet rs = null;
			try {
				rs = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(rs != null) {
				ArrayList<MenuItem> retList = new ArrayList<MenuItem>();
				try {
					while(rs.next()) {
						
						MenuItem menuItem = new MenuItem();
						menuItem.setItemID(rs.getInt("ID"));
						menuItem.setItemName(rs.getString("Name"));
						menuItem.setItemDesc(rs.getString("Description"));
						menuItem.setPrice(rs.getDouble("price"));
						menuItem.setMenuID(rs.getInt("menuID"));
						retList.add(menuItem);
					}
					return retList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;	
 	}

 	//Query Specific 

 	public Country getCountry(int countryID) {
 		
 		String query = "select * from countries where ID=" + countryID;
 		connect();
 		Statement statement = null;
 		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		
 		if(statement != null) {
 			ResultSet rs = null;
 			try {
				rs = statement.executeQuery(query);
				rs.next();
				Country country = new Country();
				country.setCountryID(rs.getInt("ID"));
				country.setCountryName(rs.getString("Name"));
				return country;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
 		
 		return null;
 	}

 	public City getCity(int cityID) {
 		String query = "select * from cities where ID=" + cityID;
 		connect();
 		Statement statement = null;
 		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		
 		if(statement != null) {
 			ResultSet rs = null;
 			try {
				rs = statement.executeQuery(query);
				rs.next();
				City city = new City();
				city.setCityID(rs.getInt("ID"));
				city.setCityName(rs.getString("Name"));
				city.setCountryID(rs.getInt("CountryID"));
				return city;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
 		
 		return null;
 	}
 		
 	public Restaurant getRestaurant(int restaurantID) {
 		
 		String query = "select * from restaurants where ID=" + restaurantID;
 		connect();
 		Statement statement = null;
 		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		
 		if(statement != null) {
 			ResultSet rs = null;
 			try {
				rs = statement.executeQuery(query);
				rs.next();
				Restaurant restaurant = new Restaurant();
				restaurant.setRestaurantID(rs.getInt("ID"));
				restaurant.setCityID(rs.getInt("CityID"));
				restaurant.setRestaurantName(rs.getString("Name"));
				restaurant.setAddress(rs.getString("Address"));
				restaurant.setTelephone(rs.getString("Telephone"));
				restaurant.setWebsite(rs.getString("Website"));
				restaurant.setEmail(rs.getString("Email"));
				return restaurant;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
 		
 		return null;
 	}

 	public Menu getMenu(int menuID) {
 		String query = "select * from menus where ID=" + menuID;
 		connect();
 		Statement statement = null;
 		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		
 		if(statement != null) {
 			ResultSet rs = null;
 			try {
				rs = statement.executeQuery(query);
				rs.next();
				Menu menu = new Menu();
				menu.setMenuID(rs.getInt("ID"));
				menu.setMenuName(rs.getString("Name"));
				menu.setRestaurantID(rs.getInt("restaurantID"));
				return menu;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
 		
 		return null;
 	}

 	public MenuItem getMenuItem(int itemID) {
 		String query = "select * from menuitems where ID=" + itemID;
 		connect();
 		Statement statement = null;
 		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		
 		if(statement != null) {
 			ResultSet rs = null;
 			try {
				rs = statement.executeQuery(query);
				rs.next();
				MenuItem menuItem = new MenuItem();
				menuItem.setItemID(rs.getInt("ID"));
				menuItem.setItemName(rs.getString("Name"));
				menuItem.setItemDesc(rs.getString("Description"));
				menuItem.setPrice(rs.getDouble("price"));
				menuItem.setMenuID(rs.getInt("menuID"));
				return  menuItem;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
 		
 		return null;
 	}
}
