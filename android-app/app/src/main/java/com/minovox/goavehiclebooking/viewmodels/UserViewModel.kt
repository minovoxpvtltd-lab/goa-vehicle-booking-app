// UserViewModel.kt - User/Rider management
package com.minovox.goavehiclebooking.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minovox.goavehiclebooking.models.Ride
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    
    private val _userLocation = MutableStateFlow<Pair<Double, Double>?>(null)
    val userLocation: StateFlow<Pair<Double, Double>?> = _userLocation
    
    private val _availableVehicles = MutableStateFlow<List<String>>(emptyList())
    val availableVehicles: StateFlow<List<String>> = _availableVehicles
    
    private val _estimatedFare = MutableStateFlow(0.0)
    val estimatedFare: StateFlow<Double> = _estimatedFare
    
    private val _currentRide = MutableStateFlow<Ride?>(null)
    val currentRide: StateFlow<Ride?> = _currentRide
    
    private val _rideHistory = MutableStateFlow<List<Ride>>(emptyList())
    val rideHistory: StateFlow<List<Ride>> = _rideHistory
    
    private val _walletBalance = MutableStateFlow(0.0)
    val walletBalance: StateFlow<Double> = _walletBalance
    
    fun updateLocation(latitude: Double, longitude: Double) {
        _userLocation.value = Pair(latitude, longitude)
    }
    
    fun searchVehicles(vehicleType: String) {
        viewModelScope.launch {
            // Call API to search available vehicles
            // _availableVehicles.value = searchVehiclesAPI(vehicleType)
        }
    }
    
    fun estimateFare(pickupLat: Double, pickupLng: Double, dropoffLat: Double, dropoffLng: Double, vehicleType: String) {
        viewModelScope.launch {
            // Call API to estimate fare with surge pricing based on geofencing
            // _estimatedFare.value = estimateFareAPI(...)
        }
    }
    
    fun bookRide(vehicleType: String, pickupAddress: String, dropoffAddress: String) {
        viewModelScope.launch {
            // Call API to book ride
            // val ride = bookRideAPI(vehicleType, pickupAddress, dropoffAddress)
            // _currentRide.value = ride
        }
    }
    
    fun getRideHistory() {
        viewModelScope.launch {
            // Call API to fetch ride history
            // _rideHistory.value = getRideHistoryAPI()
        }
    }
    
    fun addMoneyToWallet(amount: Double) {
        viewModelScope.launch {
            // Call API to add money to wallet
            // _walletBalance.value += amount
        }
    }
    
    fun rateRide(rideId: String, rating: Int, feedback: String) {
        viewModelScope.launch {
            // Call API to rate ride
            // rateRideAPI(rideId, rating, feedback)
        }
    }
}