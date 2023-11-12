package com.gm.composesample.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.gm.composesample.nav.Routes

@Composable
fun MainScreen(
    navHostController: NavHostController
) {
    Column(Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.fillMaxHeight(0.04f))
        Text(text = "My Compose Application", modifier = Modifier.align(CenterHorizontally))
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(items = itemList) { item ->
                ListItem(
                    onItemClick = {
                        navHostController.navigate(item.route)
                    },
                    itemModel = item,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp, vertical = 8.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ListItem(
    onItemClick: () -> Unit,
    itemModel: ItemModel,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        onClick = {
            onItemClick.invoke()
        },
        border = BorderStroke(0.6.dp, Color.LightGray),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = itemModel.title,
                style = MaterialTheme.typography.bodyLarge,
                color = itemModel.color
            )
            Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "")
        }
    }
}


data class ItemModel(
    val title: String,
    val route: String,
    var color: Color = Color.Gray
)

private val itemList = listOf(
    // TODO Qemo make route
    ItemModel(
        title = "Lazy Row",
        route = Routes.LazyRow.route
    ),
    // TODO George make route
    ItemModel(
        title = "Lazy Column",
        route = Routes.LazyColumn.route
    ),
    // TODO Qemo Make route
    ItemModel(
        title = "Lazy Grid",
        route = "lazy_row"
    ),
    // TODO George make route
    ItemModel(
        title = "Lazy Staggered Grid",
        route = "lazy_row"
    ),
    // TODO Qemo make route
    ItemModel(
        title = "Pager",
        route = Routes.Pager.route
    ),
    //tr
    ItemModel(
        title = "Bottom Sheet",
        route = Routes.ModalBottomSheet.route
    ),
    // TODO Qemo make route
    ItemModel(
        title = "Dialog",
        route = "lazy_row"
    ),
    // TODO George make route
    ItemModel(
        title = "Simple Canvas",
        route = "lazy_row"
    ),
)