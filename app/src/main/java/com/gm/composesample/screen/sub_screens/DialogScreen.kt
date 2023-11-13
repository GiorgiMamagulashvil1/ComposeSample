package com.gm.composesample.screen.sub_screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun DialogScreen() {

    val showDialog = remember {
        mutableStateOf(false)
    }
    val showAlertDialog = remember {
        mutableStateOf(false)
    }
    val arcColor = remember {
        mutableStateOf(Color.Black)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Text(text = "Dialog Screen")
        Spacer(modifier = Modifier.fillMaxHeight(0.12f))
        Button(onClick = { showDialog.value = true }, modifier = Modifier.padding(10.dp)) {
            Text(text = "Open Dialog")
        }
        Button(onClick = { showAlertDialog.value = true }, modifier = Modifier.padding(10.dp)) {
            Text(text = "Open Alert Dialog")
        }

        if (showDialog.value) {
            RenderDialogUI(
                onDismiss = {
                    showDialog.value = false
                    arcColor.value = it
                }
            )
        }

        if (showAlertDialog.value) {
            RenderAlertDialogUI(
                onDismiss = {
                    showAlertDialog.value = false
                },
                onConfirm = {
                    showAlertDialog.value = false
                }
            )
        }

        Spacer(modifier = Modifier.height(60.dp))
        Canvas(
            modifier = Modifier.size(170.dp),
            onDraw = {
                drawArc(
                    color = arcColor.value,
                    startAngle = 0f,
                    sweepAngle = 270f,
                    useCenter = false,
                    style = Stroke(width = 10f)
                )
            }
        )

    }

}

@Composable
private fun RenderDialogUI(
    onDismiss: (Color) -> Unit
) {
    Dialog(
        onDismissRequest = { onDismiss.invoke(Color.Black) },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
        ),
        content = {
            Surface(shape = RoundedCornerShape(16.dp), color = Color.White) {
                Box(contentAlignment = Alignment.Center) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Text(text = "Color Palette")
                        Spacer(modifier = Modifier.height(30.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(
                                onClick = {
                                    onDismiss.invoke(Color.Cyan)
                                },
                                modifier = Modifier
                                    .size(30.dp)
                                    .background(
                                        Color.Transparent
                                    )
                                    .clip(CircleShape),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
                            ) {

                            }
                            Button(
                                onClick = {
                                    onDismiss.invoke(Color.Red)
                                }, modifier = Modifier
                                    .size(30.dp)
                                    .background(
                                        Color.Transparent
                                    )
                                    .clip(CircleShape),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)

                            ) {

                            }
                            Button(
                                onClick = {
                                    onDismiss.invoke(Color.Green)
                                }, modifier = Modifier
                                    .size(30.dp)
                                    .background(
                                        Color.Transparent
                                    )
                                    .clip(CircleShape),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)

                            ) {

                            }
                            Button(
                                onClick = {
                                    onDismiss.invoke(Color.Yellow)
                                }, modifier = Modifier
                                    .size(30.dp)
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

@Composable
private fun RenderAlertDialogUI(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {
            onDismiss.invoke()
        },
        title = { Text("Alert Dialog Title") },
        text = { Text("Dialog content goes here.") },
        confirmButton = {
            Button(onClick = {
                onConfirm.invoke()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(onClick = {
                onDismiss.invoke()
            }) {
                Text("Cancel")
            }
        }
    )
}