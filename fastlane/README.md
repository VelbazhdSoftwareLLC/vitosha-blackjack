# Fastlane Configuration for Vitosha Blackjack

This directory contains the Fastlane configuration for automating the build and deployment of the Vitosha Blackjack Android application.

## Setup

1. Install Fastlane:
   ```bash
   gem install fastlane
   ```

2. Set up Google Play Console access:
   - Create a service account in Google Play Console
   - Download the JSON key file
   - Place it as `fastlane/service-account.json`

3. Install dependencies:
   ```bash
   fastlane install_plugins
   ```

## Available Lanes

- `test` - Runs all unit tests
- `debug` - Builds a debug APK
- `release` - Builds a release APK
- `deploy` - Builds and deploys to Google Play Store (internal track)
- `upload_metadata` - Uploads only metadata to Google Play Console
- `download_metadata` - Downloads metadata from Google Play Console
- `increment_version` - Increments the version code
- `clean` - Cleans the build directory

## Usage Examples

### Build and deploy to internal testing
```bash
fastlane deploy
```

### Upload metadata only
```bash
fastlane upload_metadata
```

### Run tests
```bash
fastlane test
```

## Metadata Structure

The `fastlane/metadata/android/` directory contains:
- `title.txt` - App title
- `short_description.txt` - Short description (80 chars max)
- `full_description.txt` - Full description
- `release_notes.txt` - Release notes for current version
- `content_rating.txt` - Content rating information
- `images/` - Directory for store images and screenshots

### Image Directories

- `images/icon/` - App icon (512x512 PNG)
- `images/featureGraphic/` - Feature graphic (1024x500 PNG)
- `images/promoGraph/` - Promo graphic (180x120 PNG)
- `images/phoneScreenshots/` - Phone screenshots (320-3840px, PNG or JPEG)

## Notes

- The app package name is `eu.veldsoft.vitosha.blackjack`
- Current version is 2.0.1 (version code 3)
- The app targets Android SDK 33 with minimum SDK 25
