package com.example.aichatapp.Viewmodels

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aichatapp.ChatEvents
import com.example.aichatapp.ChatState
import com.example.aichatapp.data.Chat
import com.example.aichatapp.data.ChatData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ChatViewModel : ViewModel() {

    private val _chatState = MutableStateFlow(ChatState())
    val chatState = _chatState.asStateFlow()

    fun onEvent(event: ChatEvents ) {
        when (event) {
            is ChatEvents.SendPrompt -> {
                if (event.prompt.isNotEmpty()) {
                    if (event.bitmap != null) {

                        addPrompt(event.prompt, event.bitmap)
                        getResponseWithImage(event.prompt, event.bitmap)
                    } else {

                        addPrompt(event.prompt, null)
                        getResponse(event.prompt)
                    }
                }



            }
            is ChatEvents.UpdatePrompt -> {
                _chatState.update {
                    it.copy(prompt = event.newPrompt)
                }
            }
        }
    }

    private fun addPrompt(prompt: String, bitmap: Bitmap?) {
        _chatState.update {
            it.copy(
                chatList = it.chatList.toMutableList().apply {
                    add(0, Chat(prompt, bitmap,  true))
                },
                prompt = "",
                bitmap = null
            )
        }
    }

    private fun getResponse(prompt: String) {
        viewModelScope.launch {
            val chat = ChatData.getResponse(prompt)
            updateChatState(chat)
        }
    }

    private fun getResponseWithImage(prompt: String, bitmap: Bitmap) {
        viewModelScope.launch {
            val chat = ChatData.getResponseWithImage(prompt, bitmap)
            updateChatState(chat)
        }
    }





    private fun updateChatState(chat: Chat) {
        viewModelScope.launch {
            _chatState.update {
                it.copy(
                    chatList = it.chatList.toMutableList().apply {
                        add(0, chat)
                    }
                )
            }
        }
    }
}
