package com.example.aichatapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aichatapp.R
import com.example.aichatapp.Viewmodels.SplashViewModel
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(viewModel: SplashViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.appname),
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(120.dp))

            Text(
                text = stringResource(R.string.madeby),
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,

            )
        }
    }


    LaunchedEffect(key1 = true) {
        delay(3000)
        viewModel.onSplashScreenDismissed()
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenView(){

   // SplashScreen()
}
