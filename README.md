# Dakshesh Portfolio (Android)

## Getting Started

1. Install Android Studio and ensure the Android SDK is installed (Platform 34 and Build Tools 34.0.0).
2. Copy the example SDK config and update it for your machine:

```
cp local.properties.example local.properties

# Then edit local.properties:
sdk.dir=/path/to/Android/sdk
```

3. (Optional) You can also set an environment variable instead of `local.properties`:

```
export ANDROID_SDK_ROOT=/path/to/Android/sdk
```

4. Build and run the app:

```
./gradlew assembleDebug
```
