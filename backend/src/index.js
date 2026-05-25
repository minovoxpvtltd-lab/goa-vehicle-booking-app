// src/index.js - Main server entry point
const express = require('express');
const dotenv = require('dotenv');
const cors = require('cors');
const helmet = require('helmet');
const morgan = require('morgan');
const http = require('http');
const socketIO = require('socket.io');

dotenv.config();

const app = express();
const server = http.createServer(app);
const io = socketIO(server, {
  cors: {
    origin: process.env.FRONTEND_URL || '*',
    methods: ['GET', 'POST']
  }
});

// Middleware
app.use(helmet());
app.use(cors());
app.use(morgan('combined'));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Health check endpoint
app.get('/health', (req, res) => {
  res.json({ status: 'Server is running', timestamp: new Date() });
});

// WebSocket handlers for real-time communication
io.on('connection', (socket) => {
  console.log('User connected:', socket.id);
  
  // Driver location updates - emit to all connected clients
  socket.on('driver_location_update', (data) => {
    console.log('Driver location updated:', data);
    io.emit('driver_location_updated', {
      driverId: data.driverId,
      latitude: data.latitude,
      longitude: data.longitude,
      timestamp: new Date()
    });
  });
  
  // Ride requests from users
  socket.on('ride_request', (data) => {
    console.log('New ride request:', data);
    io.emit('new_ride_request', {
      rideId: data.rideId,
      userId: data.userId,
      pickup: data.pickup,
      dropoff: data.dropoff,
      vehicleType: data.vehicleType,
      timestamp: new Date()
    });
  });
  
  // Ride acceptance by driver
  socket.on('ride_accepted', (data) => {
    console.log('Ride accepted:', data);
    io.emit('ride_status_updated', {
      rideId: data.rideId,
      driverId: data.driverId,
      status: 'ACCEPTED',
      timestamp: new Date()
    });
  });
  
  // Ride completion
  socket.on('ride_completed', (data) => {
    console.log('Ride completed:', data);
    io.emit('ride_status_updated', {
      rideId: data.rideId,
      status: 'COMPLETED',
      finalFare: data.finalFare,
      timestamp: new Date()
    });
  });
  
  socket.on('disconnect', () => {
    console.log('User disconnected:', socket.id);
  });
});

// Error handling middleware
app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).json({
    error: err.message || 'Internal Server Error'
  });
});

const PORT = process.env.PORT || 5000;
server.listen(PORT, () => {
  console.log(`🚀 Server running on port ${PORT}`);
  console.log(`📍 Geofencing enabled for 70km Goa radius`);
});

module.exports = app;