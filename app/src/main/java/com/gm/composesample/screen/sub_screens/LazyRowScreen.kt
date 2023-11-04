package com.gm.composesample.screen.sub_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier

@Composable
fun LazyRowScreen() {
    Column {
        Text(text = "This is Lazy row screen", Modifier.align(CenterHorizontally))
    }
}