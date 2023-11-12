package com.gm.composesample.screen.sub_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun LazyGrid() {
    val savedItems = (1..60).toList()
    var items by remember { mutableStateOf(savedItems) }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.fillMaxHeight(0.04f))
        Text(text = "Lazy Grid", modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))
        TextField(savedItems) { searchedItems ->
            items = searchedItems
        }
        LazyGridView(items)
    }
}

@Composable
private fun TextField(items: List<Int>, onItemSearch: (List<Int>) -> Unit) {
    var searchText by remember { mutableStateOf(TextFieldValue()) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        content = {
            BasicTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                    onItemSearch.invoke(
                        items.filter { number ->
                            number.toString().contains(searchText.text, ignoreCase = true)
                        }
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(16.dp)
                    .border(BorderStroke(width = 1.dp, color = Color.Black))
            )
        }
    )
}

@Composable
private fun LazyGridView(items: List<Int>) {
    Column(modifier = Modifier.fillMaxWidth()) {
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