// Ride.kt - Ride model
package com.minovox.goavehiclebooking.models

data class Ride(
    val rideId: String,
    val riderId: String,
    val driverId: String? = null,
    val vehicleId: String? = null,
    val pickupLat: Double,
    val pickupLng: Double,
    val dropoffLat: Double,
    val dropoffLng: Double,
    val pickupAddress: String,
    val dropoffAddress: String,
    val vehicleType: String, // ECONOMY, PREMIUM, SUV, AUTO, BIKE
    val estimatedFare: Double,
    val actualFare: Double = 0.0,
    val status: String, // PENDING, ACCEPTED, STARTED, COMPLETED, CANCELLED
    val rideStartTime: Long? = null,
    val rideEndTime: Long? = null,
    val rating: Int? = null,
    val feedback: String? = null,
    val createdAt: Long
)