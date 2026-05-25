# GoA Vehicle Booking App 🚗

A premium Android application for vehicle booking exclusively in the Goa region (70 km radius). Features real-time location tracking, multiple vehicle types, and separate panels for Admin, Drivers, and Riders/Users.

## 📋 Features

- **Multi-Panel Architecture**
  - 👤 User/Rider Panel - Book vehicles
  - 🚕 Driver Panel - Accept/manage rides
  - ⚙️ Admin Panel - Manage platform

- **Vehicle Types**
  - Economy Cars
  - Premium Cars
  - SUVs
  - Auto-rickshaws
  - Bikes

- **Real-time Features**
  - Live location tracking
  - Real-time driver matching
  - GPS-based geofencing (70 km Goa radius)
  - Live ride updates
  - WebSocket communication

- **Premium UI/UX**
  - Material Design 3
  - Smooth animations
  - Dark mode support
  - Native Android feel

## 🏗️ Project Structure

```
goa-vehicle-booking-app/
├── android-app/                 # Main Android application
│   ├── app/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/
│   │   │   │   │   ├── com/minovox/goavehiclebooking/
│   │   │   │   │   │   ├── models/
│   │   │   │   │   │   ├── viewmodels/
│   │   │   │   │   │   ├── ui/
│   │   │   │   │   │   ├── services/
│   │   │   │   │   │   └── utils/
│   │   │   │   └── res/
│   │   │   └── test/
│   │   └── build.gradle
│   └── settings.gradle
│
├── backend/                      # Node.js/Express backend
│   ├── src/
│   │   ├── controllers/
│   │   ├── routes/
│   │   ├── models/
│   │   ├── middleware/
│   │   ├── services/
│   │   ├── utils/
│   │   └── config/
│   ├── package.json
│   └── .env.example
│
├── docs/                         # Documentation
│   ├── SETUP_GUIDE.md
│   ├── API_DOCUMENTATION.md
│   ├── DATABASE_SCHEMA.md
│   └── ARCHITECTURE.md
│
└── README.md
```

## 🔧 Tech Stack

### Android
- **Language**: Kotlin
- **Architecture**: MVVM with Clean Architecture
- **UI Framework**: Jetpack Compose + Material Design 3
- **Networking**: Retrofit + OkHttp
- **Real-time**: Firebase Realtime Database + WebSocket
- **Location**: Google Play Services (Maps & Location)
- **Database**: Room Database (Local)
- **Authentication**: Firebase Auth + JWT
- **DI**: Hilt

### Backend
- **Framework**: Node.js + Express.js
- **Database**: MongoDB + PostgreSQL
- **Real-time**: Firebase + Socket.io
- **Maps**: Google Maps API
- **Payment**: Razorpay/Stripe Integration
- **Authentication**: JWT + Firebase Admin

## 📱 Key Screens

### User/Rider Panel
- Home with map view
- Search & book vehicle
- Trip history
- Payments & wallet
- Profile & settings
- Ratings & reviews

### Driver Panel
- Live ride requests
- Accept/reject rides
- Navigation to pickup
- Live tracking
- Earnings dashboard
- Profile management

### Admin Panel
- Dashboard with analytics
- Driver management
- User management
- Vehicle management
- Payment reconciliation
- Reports & analytics

## 🗺️ Geofencing Implementation

- 70 km radius from Goa center coordinates (15.2993°N, 73.8243°E)
- GPS-based real-time boundary checking
- Automatic service area validation
- Location-based price surge
- Haversine formula for distance calculation

## 🚀 Getting Started

### Prerequisites
- Android Studio Flamingo+
- JDK 11+
- Node.js 16+
- MongoDB Atlas account
- Google Maps API keys
- Firebase project setup

### Android Setup
```bash
git clone https://github.com/minovoxpvtltd-lab/goa-vehicle-booking-app.git
cd android-app
./gradlew build
./gradlew installDebug
```

### Backend Setup
```bash
cd backend
npm install
cp .env.example .env
npm run dev
```

## 📝 API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login
- `POST /api/auth/logout` - User logout
- `POST /api/auth/refresh-token` - Refresh JWT token

### Users
- `GET /api/users/profile` - Get user profile
- `PUT /api/users/profile` - Update user profile
- `GET /api/users/wallet` - Get wallet balance

### Drivers
- `GET /api/drivers/available` - Get available drivers
- `POST /api/drivers/accept-ride` - Accept ride
- `POST /api/drivers/complete-ride` - Complete ride
- `GET /api/drivers/earnings` - Get driver earnings

### Rides
- `POST /api/rides/request` - Request a ride
- `GET /api/rides/history` - Get ride history
- `POST /api/rides/rate` - Rate a ride
- `GET /api/rides/track` - Track active ride

### Admin
- `GET /api/admin/dashboard` - Get dashboard analytics
- `GET /api/admin/drivers` - List all drivers
- `GET /api/admin/users` - List all users
- `POST /api/admin/approve-driver` - Approve driver

## 🔐 Security

- JWT token authentication
- End-to-end encryption for sensitive data
- SSL/TLS for all communications
- Firebase security rules
- Regular security audits
- Rate limiting on API endpoints
- Input validation and sanitization

## 🎨 Design Guidelines

- Material Design 3 principles
- Color scheme: Primary accent + Neutral palette
- Typography: Roboto font family
- Spacing: 8dp grid system
- Animations: Smooth 300-500ms transitions
- Accessibility: WCAG 2.1 AA compliance

## 🤝 Contributing

1. Create feature branch from `develop`
2. Follow code style guidelines
3. Write unit tests
4. Create pull request with description

## 📄 License

MIT License - See LICENSE file

## 📧 Contact

support@minovoxpvtltd.com

---

**Last Updated**: May 2026