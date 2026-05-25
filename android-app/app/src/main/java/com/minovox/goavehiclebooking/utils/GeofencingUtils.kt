// GeofencingUtils.kt - Geofencing utility for 70 km Goa radius
package com.minovox.goavehiclebooking.utils

import kotlin.math.*

object GeofencingUtils {
    // Goa center coordinates (Panaji, Goa)
    private const val GOA_CENTER_LAT = 15.2993
    private const val GOA_CENTER_LNG = 73.8243
    private const val GEOFENCE_RADIUS_KM = 70
    private const val EARTH_RADIUS_KM = 6371.0
    
    /**
     * Calculate distance between two coordinates using Haversine formula
     * @return distance in kilometers
     */
    fun calculateDistance(lat1: Double, lng1: Double, lat2: Double, lng2: Double): Double {
        val dLat = Math.toRadians(lat2 - lat1)
        val dLng = Math.toRadians(lng2 - lng1)
        
        val a = sin(dLat / 2) * sin(dLat / 2) +
                cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) *
                sin(dLng / 2) * sin(dLng / 2)
        
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        
        return EARTH_RADIUS_KM * c
    }
    
    /**
     * Check if location is within Goa service area (70 km radius)
     */
    fun isWithinServiceArea(latitude: Double, longitude: Double): Boolean {
        val distance = calculateDistance(GOA_CENTER_LAT, GOA_CENTER_LNG, latitude, longitude)
        return distance <= GEOFENCE_RADIUS_KM
    }
    
    /**
     * Get distance from Goa center in kilometers
     */
    fun getDistanceFromCenter(latitude: Double, longitude: Double): Double {
        return calculateDistance(GOA_CENTER_LAT, GOA_CENTER_LNG, latitude, longitude)
    }
    
    /**
     * Calculate price surge multiplier based on distance from center
     * Closer to center = lower surge, farther = higher surge
     */
    fun calculateSurgeMultiplier(latitude: Double, longitude: Double): Float {
        val distance = getDistanceFromCenter(latitude, longitude)
        return when {
            distance < 25 -> 1.0f      // No surge in central areas
            distance < 50 -> 1.2f      // 20% surge
            distance < 70 -> 1.5f      // 50% surge
            else -> 2.0f               // 100% surge outside service area
        }
    }
    
    /**
     * Get Goa center coordinates
     */
    fun getGoaCenterCoordinates(): Pair<Double, Double> {
        return Pair(GOA_CENTER_LAT, GOA_CENTER_LNG)
    }
    
    /**
     * Check if user is outside service area and provide warning
     */
    fun getLocationStatus(latitude: Double, longitude: Double): LocationStatus {
        val distance = getDistanceFromCenter(latitude, longitude)
        return when {
            distance <= 70 -> LocationStatus.WITHIN_SERVICE_AREA
            distance <= 75 -> LocationStatus.NEAR_BOUNDARY
            else -> LocationStatus.OUTSIDE_SERVICE_AREA
        }
    }
    
    enum class LocationStatus {
        WITHIN_SERVICE_AREA,
        NEAR_BOUNDARY,
        OUTSIDE_SERVICE_AREA
    }
}