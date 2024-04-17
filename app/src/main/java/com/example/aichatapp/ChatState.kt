package com.example.aichatapp

import android.graphics.Bitmap

data class ChatState(

    val chatList: MutableList<com.example.aichatapp.data.Chat> = mutableListOf(),
    val prompt: String ="",
    val bitmap: Bitmap?= null
)
