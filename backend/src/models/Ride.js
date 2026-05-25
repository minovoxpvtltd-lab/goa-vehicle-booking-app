// src/models/Ride.js - Ride schema
const mongoose = require('mongoose');

const rideSchema = new mongoose.Schema({
  rideId: {
    type: String,
    unique: true,
    required: true
  },
  riderId: {
    type: String,
    required: true
  },
  driverId: String,
  vehicleId: String,
  pickupLat: {
    type: Number,
    required: true
  },
  pickupLng: {
    type: Number,
    required: true
  },
  dropoffLat: {
    type: Number,
    required: true
  },
  dropoffLng: {
    type: Number,
    required: true
  },
  pickupAddress: {
    type: String,
    required: true
  },
  dropoffAddress: {
    type: String,
    required: true
  },
  vehicleType: {
    type: String,
    enum: ['ECONOMY', 'PREMIUM', 'SUV', 'AUTO', 'BIKE'],
    required: true
  },
  estimatedFare: {
    type: Number,
    required: true
  },
  actualFare: {
    type: Number,
    default: 0
  },
  status: {
    type: String,
    enum: ['PENDING', 'ACCEPTED', 'STARTED', 'COMPLETED', 'CANCELLED'],
    default: 'PENDING'
  },
  rideStartTime: Date,
  rideEndTime: Date,
  rating: Number,
  feedback: String,
  createdAt: {
    type: Date,
    default: Date.now
  }
});

module.exports = mongoose.model('Ride', rideSchema);