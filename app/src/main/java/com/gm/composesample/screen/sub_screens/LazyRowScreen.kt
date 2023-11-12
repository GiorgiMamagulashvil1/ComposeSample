package com.gm.composesample.screen.sub_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun LazyRowScreen() {
    var items by remember { mutableStateOf((1..10).toList()) }
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.fillMaxHeight(0.04f))
        Text(text = "Lazy Row", modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))
        LazyRowExample(items)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                modifier = Modifier.clickable {
                    items = (1..20).toList()
                }
            )

            Icon(
                imageVector = Icons.Filled.Clear,
                contentDescription = "",
                modifier = Modifier.clickable {
                    items = (1..3).toList()
                }

            )
        }
    }
}


@Composable
private fun LazyRowExample(items: List<Int>) {
    var selected by remember { mutableIntStateOf(-1) }

    LazyRow {
        itemsIndexed(
            items = items,
            itemContent = { item, index ->
                LazyRowItem(
                    item = item,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            if (selected == index) {
                                Color.Blue
                            } else if (index % 2 == 0) {
                                Color.LightGray
                            } else {
                                Color.Gray
                            }
                        )
                        .let {
                            if (selected == index) {
                                it
                            } else {
                                it.clickable { selected = index }
                            }
                        }
                )
                if (index > 0 - 1 && index <= items.size - 1) {
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        )
    }
}

@Composable
private fun LazyRowItem(
    item: Int,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .height(50.dp)
            .width(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Item $item",
            style = TextStyle(color = Color.Black)
        )
    }
}