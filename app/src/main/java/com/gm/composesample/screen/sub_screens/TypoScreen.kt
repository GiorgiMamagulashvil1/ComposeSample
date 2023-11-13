package com.gm.composesample.screen.sub_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TypoScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(
            rememberScrollState()
        )
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "example text ", style = MaterialTheme.typography.displayLarge)

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "example text", style = MaterialTheme.typography.displayMedium)

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "example text", style = MaterialTheme.typography.displaySmall)

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "example text", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "headlineMedium text", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "bodyLarge text", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "bodyMedium text", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(10.dp))
    }
}