package com.routing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.routing.model.DeliveryRoute;
import com.routing.model.RoutingInputJSON;
import com.routing.routeCalculator.RestaurantRouteCalculator;

@RestController
public class RouteController {

	@Autowired
	RestaurantRouteCalculator restaurantRouteCalculator;

	@PostMapping(path = "getBestRoute", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getBestRoute(@RequestBody RoutingInputJSON routingInputJSON) {
		try {

			DeliveryRoute deliveryRoute = restaurantRouteCalculator.getBestRoute(routingInputJSON.getDriverCordinates(),
					routingInputJSON.getRestaurantCordinates(), routingInputJSON.getCustomerCordinates(),
					routingInputJSON.getCookingTimePerResturant(), routingInputJSON.getDriverSpeed());
			return new ResponseEntity(deliveryRoute, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
