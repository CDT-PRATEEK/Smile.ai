package com.example.aichatapp.navigation

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aichatapp.Viewmodels.SplashViewModel
import com.example.aichatapp.screens.ChatScreen
import com.example.aichatapp.screens.SplashScreen
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun NavGraph(
    navController: NavHostController,
    imagePicker: ActivityResultLauncher<PickVisualMediaRequest>,
    pdfPicker: ActivityResultLauncher<String>,
    uriState: MutableStateFlow<String>,
    pdfuriState: MutableStateFlow<String>
) {

    val viewModel: SplashViewModel = viewModel()


    NavHost(navController = navController, startDestination = if (viewModel.showSplash.value) {
        Routes.Splash.routes
    } else {
        Routes.Chat.routes
    }){
        composable(Routes.Splash.routes) {
            SplashScreen(viewModel)
        }
        composable(Routes.Chat.routes) {
            ChatScreen(
                paddingValues = PaddingValues(0.dp),
                imagePicker = imagePicker,
                pdfPicker = pdfPicker,
                uriState = uriState,
                pdfuriState = pdfuriState
            )
        }
    }
}