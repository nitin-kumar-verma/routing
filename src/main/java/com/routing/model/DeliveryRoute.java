package com.routing.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DeliveryRoute {
	private List<String> bestRoute;
	private double minPossibleTime = Double.MAX_VALUE;
	@JsonIgnore
	private List<String> options = new ArrayList<>();

	@JsonIgnore
	private double speed;

	public DeliveryRoute(List<String> bestRoute) {
		super();
		this.bestRoute = bestRoute;
	}

	public DeliveryRoute() {
	}

	public List<String> getBestRoute() {
		return bestRoute;
	}

	public void setBestRoute(List<String> bestRoute) {
		this.bestRoute = bestRoute;
	}

	public double getMinPossibleTime() {
		return minPossibleTime;
	}

	public void setMinPossibleTime(double minPossibleTime) {
		this.minPossibleTime = minPossibleTime;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
