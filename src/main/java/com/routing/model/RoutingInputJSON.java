package com.routing.model;

import java.util.List;

public class RoutingInputJSON {
	private Cordinates driverCordinates;
	private List<Cordinates> restaurantCordinates;
	private List<Cordinates> customerCordinates;
	private List<Double> cookingTimePerResturant;
	private double driverSpeed;

	public Cordinates getDriverCordinates() {
		return driverCordinates;
	}

	public void setDriverCordinates(Cordinates driverCordinates) {
		this.driverCordinates = driverCordinates;
	}

	public List<Cordinates> getRestaurantCordinates() {
		return restaurantCordinates;
	}

	public void setRestaurantCordinates(List<Cordinates> restaurantCordinates) {
		this.restaurantCordinates = restaurantCordinates;
	}

	public List<Cordinates> getCustomerCordinates() {
		return customerCordinates;
	}

	public void setCustomerCordinates(List<Cordinates> customerCordinates) {
		this.customerCordinates = customerCordinates;
	}

	public List<Double> getCookingTimePerResturant() {
		return cookingTimePerResturant;
	}

	public void setCookingTimePerResturant(List<Double> cookingTimePerResturant) {
		this.cookingTimePerResturant = cookingTimePerResturant;
	}

	public double getDriverSpeed() {
		return driverSpeed;
	}

	public void setDriverSpeed(double driverSpeed) {
		this.driverSpeed = driverSpeed;
	}
}
