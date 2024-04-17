# Description

This project implements a conversational chatbot powered by generative AI technology, specifically the Gemini API. It's designed in Android Studio Hedgehog and leverages a secret Gradle plugin to securely store API keys.

# Features

User-friendly interface for interacting with the chatbot
Integration with Gemini API for generative AI responses
Secure API key management using a secret Gradle plugin
# Requirements

Android Studio Hedgehog (or a compatible version)
A Gemini API account (https://support.gemini.com/hc/en-us/articles/360031080191-How-do-I-create-an-API-key)
# Setup

Clone the Repository: Use git clone https://github.com/<your-username>/<your-repo-name>.git to clone this repository to your local machine.
Install Dependencies: Open the project in Android Studio and navigate to Tools > Build > Refresh Gradle Project. This ensures all dependencies are downloaded and configured.
Configure Gemini API Key: Strictly avoid committing your API key directly to the codebase. Instead:
Create a secret Gradle plugin file (e.g., secrets.gradle). Follow the instructions provided by your chosen secret Gradle plugin to securely store your Gemini API key within this file.
Reference the key securely in your code using the methods provided by your chosen plugin.
# Running the App

Connect an Android Device: Ensure an Android device is connected to your development machine or an emulator is running.
Build and Run: Select your device or emulator from the Run configuration dropdown in Android Studio. Click the Run button (green triangle) to build and deploy the app.
# Usage

Once the app launches on your device, interact with the chatbot through the provided user interface. The chatbot will utilize the Gemini API to generate responses based on your input.

# Contributing

contributions are welcome to this project! Please create a pull request on GitHub with your changes and a clear explanation of what you've modified.
