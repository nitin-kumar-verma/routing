package com.routing.util;

import org.springframework.stereotype.Service;

import com.routing.model.Cordinates;

@Service
public class DistanceCalculator {

	public double haversine(Cordinates cordinate1, Cordinates cordinate2) {
		double lat1 = cordinate1.getLatitude(), lon1 = cordinate1.getLongitude(), lat2 = cordinate2.getLatitude(),
				lon2 = cordinate2.getLongitude();
		// distance between latitudes and longitudes
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);

		// convert to radians
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		// apply formulae
		double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double rad = 6371;
		double c = 2 * Math.asin(Math.sqrt(a));
		return rad * c;
	}
}
