package com.project.uber.uberApp.strategies.impl;

import com.project.uber.uberApp.dto.RideRequestDto;
import com.project.uber.uberApp.strategies.RideFairCalculationStrategy;

public class RiderFareDefaultFareCalculationStrategy implements RideFairCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
