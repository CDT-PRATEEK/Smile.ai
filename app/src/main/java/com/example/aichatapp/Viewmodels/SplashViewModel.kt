package com.example.aichatapp.Viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {
    private val _showSplash = mutableStateOf(true)
    val showSplash: State<Boolean> = _showSplash

    fun onSplashScreenDismissed() {
        _showSplash.value = false
    }
}
