drop database restaurants;
create database restaurants;
use restaurants;

create table countries(

	ID int not null auto_increment,
	Name varchar(50),
	
	primary key(ID)
);


create table cities(
restaurantscountries
	ID int not null auto_increment,
	Name varchar(50),
	CountryID int not null,
	
	primary key(ID),
	foreign key(countryID) references countries(ID)
);


create table restaurants(

	ID int not null auto_increment,
	Name varchar(100),
	CityID int not null,
	
	Address varchar(100),
	Telephone varchar(100),
	Website varchar(100),
	Email varchar(100),
	
	primary key(ID),
	foreign key(cityID) references cities(ID)

);


create table menus(

	ID int not null auto_increment,
	Name varchar(50),
	restaurantID int not null,
	
	primary key(ID),
	foreign key(restaurantID) references restaurants(ID)
);

create table menuItems(

	ID int not null auto_increment,
	Name varchar(50),
	Description varchar(200),
	price decimal(5,2),
	menuID int not null,

	primary key(ID),
	foreign key(menuID) references menus(ID)
);

