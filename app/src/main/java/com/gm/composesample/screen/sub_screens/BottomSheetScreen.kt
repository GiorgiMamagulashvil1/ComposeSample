package com.gm.composesample.screen.sub_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScreen() {
    val items = (1..60).toList()
    val bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = bottomSheetState
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar {
                Text(
                    text = "Bottom Sheet",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        },
        content = {
            Text(text = "bottom sheet fraction : ${bottomSheetState.progress}")
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            if (bottomSheetState.isCollapsed){
                                bottomSheetState.expand()
                            } else {
                                bottomSheetState.collapse()
                            }
                        }
                    },

                    ) {
                    Text(
                        text = "Show Bottom Sheet",
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        },
        sheetContent = {
            LazyGridView(items)
        },
        sheetBackgroundColor = Color.LightGray,
        sheetPeekHeight = 30.dp,
        sheetShape = RoundedCornerShape(20.dp)
    )
}

@Composable
private fun LazyGridView(items: List<Int>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            content = {
                items(items) { item ->
                    GridItem(item)
                }
            }
        )
    }
}

@Composable
private fun GridItem(item: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.Gray)
    ) {
        Text(
            text = "Item $item",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(8.dp),
            color = Color.White
        )
    }
}