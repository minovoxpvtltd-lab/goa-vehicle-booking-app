// src/models/User.js - User schema
const mongoose = require('mongoose');
const bcrypt = require('bcryptjs');

const userSchema = new mongoose.Schema({
  userId: {
    type: String,
    unique: true,
    required: true
  },
  name: {
    type: String,
    required: true
  },
  email: {
    type: String,
    unique: true,
    required: true,
    lowercase: true
  },
  phone: {
    type: String,
    required: true,
    unique: true
  },
  password: {
    type: String,
    required: true
  },
  profileImage: String,
  userType: {
    type: String,
    enum: ['RIDER', 'DRIVER', 'ADMIN'],
    required: true
  },
  isVerified: {
    type: Boolean,
    default: false
  },
  rating: {
    type: Number,
    default: 0,
    min: 0,
    max: 5
  },
  totalRides: {
    type: Number,
    default: 0
  },
  walletBalance: {
    type: Number,
    default: 0
  },
  createdAt: {
    type: Date,
    default: Date.now
  },
  updatedAt: {
    type: Date,
    default: Date.now
  }
});

// Hash password before saving
userSchema.pre('save', async function(next) {
  if (!this.isModified('password')) return next();
  
  try {
    const salt = await bcrypt.genSalt(10);
    this.password = await bcrypt.hash(this.password, salt);
    next();
  } catch (error) {
    next(error);
  }
});

// Compare password method
userSchema.methods.comparePassword = async function(inputPassword) {
  return await bcrypt.compare(inputPassword, this.password);
};

module.exports = mongoose.model('User', userSchema);