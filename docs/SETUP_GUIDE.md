# GoA Vehicle Booking App - Complete Setup Guide

## 🎯 Prerequisites

### System Requirements
- Android Studio Flamingo or later
- JDK 11 or higher
- Node.js 16+ and npm
- Git
- MongoDB Atlas account
- Google Maps API keys
- Firebase project
- Razorpay/Stripe account (for payments)

### Software Installation

#### 1. Android Studio
- Download from [developer.android.com](https://developer.android.com/studio)
- Install with default settings
- Setup Android SDK (API 34+)
- Install Kotlin plugin

#### 2. Node.js
```bash
# Download from nodejs.org
node --version  # Verify installation (v16+)
npm --version
```

## 📱 Android App Setup

### 1. Clone Repository
```bash
git clone https://github.com/minovoxpvtltd-lab/goa-vehicle-booking-app.git
cd goa-vehicle-booking-app/android-app
```

### 2. Add Google Services JSON
- Go to [Firebase Console](https://console.firebase.google.com/)
- Create new project: "goa-vehicle-booking"
- Add Android app
- Download `google-services.json`
- Place in `android-app/app/` directory

### 3. Configure Google Maps API
```bash
# Create Google Cloud project
# Enable Maps SDK for Android
# Create API key
# Add to local.properties:
echo "MAPS_API_KEY=your-api-key-here" >> local.properties
```

### 4. Setup Firebase

**Authentication:**
- Enable Email/Password
- Enable Google Sign-in
- Enable Phone authentication

**Realtime Database:**
```json
{
  "rules": {
    "drivers": {
      "$uid": {
        ".read": "auth.uid === $uid",
        ".write": "auth.uid === $uid"
      }
    },
    "riders": {
      "$uid": {
        ".read": "auth.uid === $uid",
        ".write": "auth.uid === $uid"
      }
    },
    "rides": {
      "$uid": {
        ".read": "auth.uid === $uid",
        ".write": "auth.uid === $uid"
      }
    }
  }
}
```

### 5. Build and Run
```bash
# Build project
./gradlew clean build

# Run on emulator
./gradlew installDebug

# Or directly open in Android Studio and click Run
```

## 🔌 Backend Setup

### 1. Navigate to Backend
```bash
cd backend
```

### 2. Install Dependencies
```bash
npm install
```

### 3. Configure Environment
```bash
cp .env.example .env
```

Edit `.env` with your configuration:
```env
PORT=5000
NODE_ENV=development

# MongoDB
MONGODB_URI=mongodb+srv://username:password@cluster.mongodb.net/goa-vehicle-booking

# JWT
JWT_SECRET=your-super-secret-key-here-min-32-characters
JWT_EXPIRE=7d

# Google Maps
GOOGLE_MAPS_API_KEY=your-google-maps-api-key

# Payment Gateway
RAZORPAY_KEY_ID=your-razorpay-key-id
RAZORPAY_KEY_SECRET=your-razorpay-key-secret

# Geofencing
GOA_CENTER_LAT=15.2993
GOA_CENTER_LNG=73.8243
GOA_RADIUS_KM=70
```

### 4. Start Development Server
```bash
# Development mode with auto-reload
npm run dev

# Production mode
npm start
```

Server runs on: `http://localhost:5000`

## 🔥 Firebase Setup

### 1. Create Firebase Project
- Go to [Firebase Console](https://console.firebase.google.com/)
- Click "Add Project"
- Project name: "goa-vehicle-booking"
- Enable Google Analytics
- Click "Create project"

### 2. Setup Authentication
```javascript
// In Firebase Console → Authentication → Sign-in method
// Enable:
- Email/Password
- Google Sign-in
- Phone Number
```

### 3. Create Realtime Database
```javascript
// In Firebase Console → Realtime Database → Create Database
// Start in test mode
// Location: Closest to your users
```

### 4. Create Firestore Database
```javascript
// In Firebase Console → Firestore Database → Create Database
// Start in test mode
// Location: Same as Realtime DB
```

### 5. Setup Storage
```javascript
// In Firebase Console → Storage → Get Started
// Choose test rules for development
```

## 💳 Payment Gateway Setup

### Razorpay Integration
```bash
# 1. Create Razorpay account at razorpay.com
# 2. Get API keys from dashboard
# 3. Add to .env:
RAZORPAY_KEY_ID=your-key-id
RAZORPAY_KEY_SECRET=your-key-secret
```

### Stripe Integration
```bash
# 1. Create Stripe account at stripe.com
# 2. Get API keys
# 3. Add to .env:
STRIPE_SECRET_KEY=sk_test_...
STRIPE_PUBLISHABLE_KEY=pk_test_...
```

## 🗺️ Geofencing Configuration

The app uses a 70 km radius from Goa center:
```
Center: 15.2993°N, 73.8243°E (Panaji, Goa)
Radius: 70 km
Algorithm: Haversine formula
```

**Features:**
- Automatic service area validation
- Real-time boundary checking
- Dynamic price surge based on distance
- Location-based availability

## 🧪 Testing

### Android Unit Tests
```bash
cd android-app
./gradlew test
```

### Android Instrumented Tests
```bash
./gradlew connectedAndroidTest
```

### Backend Tests
```bash
cd backend
npm test
```

## 📦 Deployment

### Android App Deployment

**1. Create Signed APK:**
```bash
cd android-app
./gradlew assembleRelease
```

**2. Generate Signed AAB (for Play Store):**
```bash
./gradlew bundleRelease
```

**3. Upload to Google Play Store:**
- Sign up as Play Store developer ($25 one-time)
- Create app listing
- Upload AAB
- Fill store listing details
- Submit for review

### Backend Deployment

**Option 1: Heroku**
```bash
heroku login
heroku create goa-vehicle-booking-api
git push heroku main
```

**Option 2: AWS EC2**
```bash
# 1. Create EC2 instance (Ubuntu 20.04)
# 2. SSH into instance
# 3. Install Node.js
sudo apt update
sudo apt install nodejs npm
# 4. Clone and deploy
git clone your-repo
cd goa-vehicle-booking-app/backend
npm install
npm start
```

**Option 3: DigitalOcean**
```bash
# Similar to AWS
# Create Droplet → Install Node.js → Deploy app
```

## 🔍 Troubleshooting

### Android Issues

**Issue: Google Play Services not found**
```bash
# Solution: Update Google Play Services in SDK Manager
Tools → SDK Manager → SDK Tools → Google Play Services
```

**Issue: Firebase connection fails**
```bash
# Solution: Check internet and verify google-services.json
# is in correct location (app/ folder)
```

**Issue: Maps not showing**
```bash
# Solution: Verify Maps API key in local.properties
echo "MAPS_API_KEY=your-valid-api-key" >> local.properties
```

### Backend Issues

**Issue: MongoDB connection timeout**
```bash
# Solution: Whitelist your IP in MongoDB Atlas
# Network Access → Add Current IP
```

**Issue: Port 5000 already in use**
```bash
# Solution: Kill process or use different port
lsof -ti:5000 | xargs kill -9
# Or set PORT=3001 in .env
```

**Issue: CORS errors**
```bash
# Solution: Update FRONTEND_URL in .env
FRONTEND_URL=your-app-frontend-url
```

## 📚 Additional Resources

- [Android Developers](https://developer.android.com/)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Express.js Guide](https://expressjs.com/)
- [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)
- [Google Maps API](https://developers.google.com/maps)

## 🆘 Support

For issues and questions:
- Email: support@minovoxpvtltd.com
- GitHub Issues: [Report Bug](https://github.com/minovoxpvtltd-lab/goa-vehicle-booking-app/issues)
- Documentation: [Project Wiki](https://github.com/minovoxpvtltd-lab/goa-vehicle-booking-app/wiki)

---

**Happy Coding! 🚀**