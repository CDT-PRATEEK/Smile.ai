package com.example.aichatapp.navigation

sealed class Routes(val routes : String) {

    object Chat : Routes("chat")
    object Splash : Routes("splash")
}
