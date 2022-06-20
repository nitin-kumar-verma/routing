package com.routing.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routing.model.Cordinates;
import com.routing.model.DeliveryRoute;
import com.routing.model.RestaurantMatrix;

@Service
public class DistanceMatrixUtilForRestaurantRoutes {

	@Autowired
	DistanceCalculator distanceCalculator;

	public RestaurantMatrix populateArrays(Cordinates driverCoordinates, List<Cordinates> restaurantsCoordinates,
			List<Cordinates> customerCoordinates, List<Double> cookingTimePerRestaurant, DeliveryRoute deliveryRoute) {
		int numberOfCustomers = restaurantsCoordinates.size();

		double[] driverToRestaurantDistance = new double[numberOfCustomers + 1];
		double[] cookingTime = new double[numberOfCustomers + 1];

		double[][] restaurantToRestaurantDist = new double[numberOfCustomers + 1][numberOfCustomers + 1];
		double[][] customerToCustomerDist = new double[numberOfCustomers + 1][numberOfCustomers + 1];
		double[][] customerToRestaurantDist = new double[numberOfCustomers + 1][numberOfCustomers + 1];

		for (int i = 1; i <= numberOfCustomers; i++) {
			// Populate distance between driver and i th restaurants
			double d1 = distanceCalculator.haversine(driverCoordinates, restaurantsCoordinates.get(i - 1));
			driverToRestaurantDistance[i] = d1;
			cookingTime[i] = cookingTimePerRestaurant.get(i - 1);
		}

		for (int i = 0; i < numberOfCustomers; i++) {
			for (int j = 0; j < numberOfCustomers; j++) {
				// Populate distance between restaurants
				restaurantToRestaurantDist[i + 1][j + 1] = distanceCalculator.haversine(restaurantsCoordinates.get(i),
						restaurantsCoordinates.get(j));

				// Populate distance between customers
				customerToCustomerDist[i + 1][j + 1] = distanceCalculator.haversine(customerCoordinates.get(i),
						customerCoordinates.get(j));

				// Populate distance between restaurants and customers
				customerToRestaurantDist[i + 1][j + 1] = distanceCalculator.haversine(customerCoordinates.get(i),
						restaurantsCoordinates.get(j));
			}
		}
		for (int i = 1; i <= numberOfCustomers; i++) {
			deliveryRoute.getOptions().add("R" + i);
		}

		return new RestaurantMatrix(driverToRestaurantDistance, cookingTime, restaurantToRestaurantDist,
				customerToCustomerDist, customerToRestaurantDist);
	}
}
