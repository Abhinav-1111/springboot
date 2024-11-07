package com.project.uber.uberApp.strategies;

import com.project.uber.uberApp.dto.RideRequestDto;

public interface RideFairCalculationStrategy {
    double calculateFare(RideRequestDto rideRequestDto);

}
