// User.kt - User model
package com.minovox.goavehiclebooking.models

data class User(
    val userId: String,
    val name: String,
    val email: String,
    val phone: String,
    val profileImage: String? = null,
    val userType: String, // RIDER, DRIVER, ADMIN
    val isVerified: Boolean = false,
    val rating: Float = 0f,
    val totalRides: Int = 0,
    val walletBalance: Double = 0.0,
    val createdAt: Long
)