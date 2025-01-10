# FUN WITH KMP

A cross-platform mobile application built with Kotlin Multiplatform Mobile, featuring shared business logic and platform-specific UI implementations using Compose Multiplatform for iOS and Android.

## Demo
https://github.com/user-attachments/assets/ef09b65d-2ccb-4a6c-9007-82a327742b71


## 🌟 Features

- Shared Kotlin code between iOS and Android
- Compose Multiplatform for cross-platform UI
- Custom Toast notifications system
- Animated UI components
- Dependency injection with Koin
- Cute Kodee animations 🐨



## 🏗 Project Structure

```
├── shared/
│   ├── commonMain/       # Shared Kotlin code
│   ├── androidMain/      # Android-specific code
│   └── iosMain/          # iOS-specific code
├── androidApp/           # Android application module
└── iosApp/              # iOS application module
```

## 🚀 Getting Started

### Prerequisites

- Android Studio Arctic Fox or newer
- Xcode 13 or newer
- JDK 11 or newer
- Kotlin Multiplatform Mobile plugin
- CocoaPods

## 📱 Key Components

### Toast Manager
A cross-platform toast notification system:
- Android: Uses native Android Toast
- iOS: Custom implementation using UIKit

```kotlin
// Usage
toastManager.showLongToast("Hello from KMM!")
```

### Animated Components
Custom animated UI components using Compose Multiplatform:
- Bouncing buttons
- Fade animations
- Kodee jump animations

### Dependency Injection
Koin setup for dependency management:
```kotlin
fun initializeKoin() {
    startKoin {
        modules(
            module {
                single { ToastManager() }
                // Add other dependencies
            }
        )
    }
}
```

## 🔧 Configuration

### iOS Configuration
In `MainViewController.kt`:
```kotlin
fun MainViewController() = ComposeUIViewController(
    configure = { initializeKoin() }
) { App() }
```

### Android Configuration
In `MainActivity.kt`:
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeKoin()
        setContent {
            App()
        }
    }
}
```

## 🌈 UI Components

### Cute Toast Button
```kotlin
CuteToastButton(toastManager)
```
Features:
- Animated hearts
- Bounce effects
- Smooth color transitions

### Animated Kodee
```kotlin
AnimatedKodee(isToastTapped)
```
Features:
- Fade-in/out animations
- Bouncing effects
- Smooth transitions

## 📚 Libraries Used

- Kotlin Multiplatform Mobile
- Compose Multiplatform
- Koin for dependency injection
- Kotlin Coroutines
- Material Design Components

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## 🙏 Acknowledgments

- Kotlin Multiplatform Mobile team
- JetBrains for Compose Multiplatform
- The adorable Kodee mascot 🐨
