package com.gm.composesample.screen.sub_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetScreen() {
    Surface(
        Modifier.fillMaxSize()
    ) {

        val buttonColor = remember {
            mutableStateOf(Color.DarkGray)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                val state = rememberModalBottomSheetState()
                val showSheet = remember {
                    mutableStateOf(false)
                }
                Spacer(modifier = Modifier.fillMaxHeight(0.4f))
                Button(
                    onClick = { showSheet.value = true },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor.value)
                ) {
                    Text(text = "Open Sheet", color = Color.Black)
                }
                if (showSheet.value) {
                    ModalBottomSheet(
                        onDismissRequest = { showSheet.value = false },
                        sheetState = state
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(30.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(
                                    onClick = {
                                        buttonColor.value = Color.Cyan
                                        showSheet.value = false
                                    },
                                    modifier = Modifier
                                        .size(40.dp)
                                        .background(
                                            Color.Transparent
                                        )
                                        .clip(CircleShape),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
                                ) {

                                }
                                Button(
                                    onClick = {
                                        buttonColor.value = Color.Red
                                        showSheet.value = false
                                    }, modifier = Modifier
                                        .size(40.dp)
                                        .background(
                                            Color.Transparent
                                        )
                                        .clip(CircleShape),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)

                                ) {

                                }
                                Button(
                                    onClick = {
                                        buttonColor.value = Color.Green
                                        showSheet.value = false
                                    }, modifier = Modifier
                                        .size(40.dp)
                                        .background(
                                            Color.Transparent
                                        )
                                        .clip(CircleShape),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)

                                ) {

                                }
                                Button(
                                    onClick = {
                                        buttonColor.value = Color.Yellow
                                        showSheet.value = false
                                    }, modifier = Modifier
                                        .size(40.dp)
                                        .background(
                                            Color.Transparent
                                        )
                                        .clip(CircleShape),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
                                ) {

                                }
                            }
                        }
                    }
                }
            }
        )
    }
}