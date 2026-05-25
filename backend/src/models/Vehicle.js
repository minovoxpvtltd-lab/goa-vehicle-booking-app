// src/models/Vehicle.js - Vehicle schema
const mongoose = require('mongoose');

const vehicleSchema = new mongoose.Schema({
  vehicleId: {
    type: String,
    unique: true,
    required: true
  },
  driverId: {
    type: String,
    required: true
  },
  vehicleType: {
    type: String,
    enum: ['ECONOMY', 'PREMIUM', 'SUV', 'AUTO', 'BIKE'],
    required: true
  },
  registrationNumber: {
    type: String,
    unique: true,
    required: true
  },
  make: String,
  model: String,
  year: Number,
  color: String,
  licensePlateImage: String,
  registrationCertificate: String,
  insurance: String,
  currentLat: Number,
  currentLng: Number,
  isActive: {
    type: Boolean,
    default: false
  },
  totalEarnings: {
    type: Number,
    default: 0
  },
  totalRides: {
    type: Number,
    default: 0
  },
  rating: {
    type: Number,
    default: 0
  },
  createdAt: {
    type: Date,
    default: Date.now
  }
});

module.exports = mongoose.model('Vehicle', vehicleSchema);