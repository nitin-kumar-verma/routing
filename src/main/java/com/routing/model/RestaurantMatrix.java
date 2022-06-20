package com.routing.model;

public class RestaurantMatrix {
	// time is in hrs
	// distances is in kms
	private double[] driverToRestaurantDistance, cookingTimePerRestaurant;
	private double[][] restaurantToRestaurantDist, customerToCustomerDist, customerToRestaurantDist;

	public RestaurantMatrix() {
	}

	public RestaurantMatrix(double[] driverToRestaurantDistance, double[] cookingTimePerRestaurant,
			double[][] restaurantToRestaurantDist, double[][] customerToCustomerDist,
			double[][] customerToRestaurantDist) {
		super();
		this.driverToRestaurantDistance = driverToRestaurantDistance;
		this.cookingTimePerRestaurant = cookingTimePerRestaurant;
		this.restaurantToRestaurantDist = restaurantToRestaurantDist;
		this.customerToCustomerDist = customerToCustomerDist;
		this.customerToRestaurantDist = customerToRestaurantDist;

	}

	public double[] getDriverToRestaurantDistance() {
		return driverToRestaurantDistance;
	}

	public void setDriverToRestaurantDistance(double[] driverToRestaurantDistance) {
		this.driverToRestaurantDistance = driverToRestaurantDistance;
	}

	public double[] getCookingTimePerRestaurant() {
		return cookingTimePerRestaurant;
	}

	public void setCookingTimePerRestaurant(double[] cookingTimePerRestaurant) {
		this.cookingTimePerRestaurant = cookingTimePerRestaurant;
	}

	public double[][] getRestaurantToRestaurantDist() {
		return restaurantToRestaurantDist;
	}

	public void setRestaurantToRestaurantDist(double[][] restaurantToRestaurantDist) {
		this.restaurantToRestaurantDist = restaurantToRestaurantDist;
	}

	public double[][] getCustomerToCustomerDist() {
		return customerToCustomerDist;
	}

	public void setCustomerToCustomerDist(double[][] customerToCustomerDist) {
		this.customerToCustomerDist = customerToCustomerDist;
	}

	public double[][] getCustomerToRestaurantDist() {
		return customerToRestaurantDist;
	}

	public void setCustomerToRestaurantDist(double[][] customerToRestaurantDist) {
		this.customerToRestaurantDist = customerToRestaurantDist;
	}

}
