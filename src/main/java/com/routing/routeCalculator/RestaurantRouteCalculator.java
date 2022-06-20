package com.routing.routeCalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routing.model.Cordinates;
import com.routing.model.DeliveryRoute;
import com.routing.model.RestaurantMatrix;
import com.routing.util.DistanceMatrixUtilForRestaurantRoutes;
import com.routing.util.RouteCalculator;

@Service
public class RestaurantRouteCalculator {

	@Autowired
	DistanceMatrixUtilForRestaurantRoutes distanceUtil;

	@Autowired
	RouteCalculator routeCalculator;

	public DeliveryRoute getBestRoute(Cordinates driverCordinates, List<Cordinates> restaurantCordinates,
			List<Cordinates> customerCordinates, List<Double> cookingTimePerResturant, double driverSpeed) {

		DeliveryRoute deliveryRoute = new DeliveryRoute();
		deliveryRoute.setSpeed(driverSpeed);

		RestaurantMatrix restaurantMatrix = distanceUtil.populateArrays(driverCordinates, restaurantCordinates,
				customerCordinates, cookingTimePerResturant, deliveryRoute);
		routeCalculator.calculateRoute(deliveryRoute, restaurantMatrix);

		return deliveryRoute;
	}

}
