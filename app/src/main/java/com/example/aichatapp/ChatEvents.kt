package com.example.aichatapp

import android.graphics.Bitmap

sealed class ChatEvents {
    data class UpdatePrompt(val newPrompt: String): ChatEvents()
    data class SendPrompt(val prompt: String, val bitmap: Bitmap?): ChatEvents()
}

