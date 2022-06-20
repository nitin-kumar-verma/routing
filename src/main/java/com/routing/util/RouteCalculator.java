package com.routing.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.routing.model.DeliveryRoute;
import com.routing.model.RestaurantMatrix;

@Service
public class RouteCalculator {

	private void calculateRoute(DeliveryRoute route, List<String> currRoute, String currPos, double timeLapsed,
			RestaurantMatrix restaurantMatrix) {
		if (timeLapsed >= route.getMinPossibleTime())
			return;

		if (route.getOptions().isEmpty()) {
			route.setMinPossibleTime(timeLapsed);
			route.setBestRoute(new ArrayList<>(currRoute));
			return;
		}

		char curr = currPos.charAt(0);
		int curr_idx = currPos.charAt(1) - '0';

		for (int i = 0; i < route.getOptions().size(); i++) {
			String nextPos = route.getOptions().remove(i);

			char dest = nextPos.charAt(0);
			int dest_idx = nextPos.charAt(1) - '0';
			double timeLapsedTillNow = 0;

			if (curr == 'A') {
				timeLapsedTillNow = (restaurantMatrix.getDriverToRestaurantDistance()[dest_idx] / route.getSpeed());

				if (timeLapsedTillNow < restaurantMatrix.getCookingTimePerRestaurant()[dest_idx])
					timeLapsedTillNow += (restaurantMatrix.getCookingTimePerRestaurant()[dest_idx] - timeLapsedTillNow);

			}

			else if (curr == 'R') {
				if (dest == 'R') {
					timeLapsedTillNow = timeLapsed
							+ (restaurantMatrix.getRestaurantToRestaurantDist()[curr_idx][dest_idx] / route.getSpeed());

					if (timeLapsedTillNow < restaurantMatrix.getCookingTimePerRestaurant()[dest_idx])
						timeLapsedTillNow += (restaurantMatrix.getCookingTimePerRestaurant()[dest_idx]
								- timeLapsedTillNow);
				}

				else {
					timeLapsedTillNow = timeLapsed
							+ (restaurantMatrix.getCustomerToRestaurantDist()[dest_idx][curr_idx] / route.getSpeed());
				}

			}

			else {

				if (dest == 'R') {
					timeLapsedTillNow = timeLapsed
							+ (restaurantMatrix.getCustomerToRestaurantDist()[curr_idx][dest_idx] / route.getSpeed());

					if (timeLapsedTillNow < restaurantMatrix.getCookingTimePerRestaurant()[dest_idx])
						timeLapsedTillNow += (restaurantMatrix.getCookingTimePerRestaurant()[dest_idx]
								- timeLapsedTillNow);
				}

				else {
					timeLapsedTillNow = timeLapsed
							+ (restaurantMatrix.getCustomerToCustomerDist()[dest_idx][curr_idx] / route.getSpeed());
				}
			}

			if (dest == 'R')
				route.getOptions().add("C" + dest_idx);

			currRoute.add(nextPos);

			calculateRoute(route, currRoute, nextPos, timeLapsedTillNow, restaurantMatrix);
			currRoute.remove(currRoute.size() - 1);

			if (dest == 'R')
				route.getOptions().remove(route.getOptions().size() - 1);

			route.getOptions().add(i, nextPos);
		}
	}

	public void calculateRoute(DeliveryRoute route, RestaurantMatrix restaurantMatrix) {
		calculateRoute(route, new ArrayList<>(), "A ", 0.0, restaurantMatrix);
	}
}
