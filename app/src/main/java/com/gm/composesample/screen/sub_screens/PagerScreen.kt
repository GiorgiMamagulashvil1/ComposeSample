package com.gm.composesample.screen.sub_screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gm.composesample.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PagerScreen() {
    val showPagerOne = remember {
        mutableStateOf(false)
    }
    val showPagerTwo = remember {
        mutableStateOf(false)
    }
    val pageState = rememberPagerState {
        8
    }
    val verticalPagerState = rememberPagerState {
        8
    }
    val data = listOf(
        R.drawable.animal_cat_domestic_2_svgrepo_com,
        R.drawable.animal_domestic_pet_7_svgrepo_com,
        R.drawable.animal_domestic_face_3_svgrepo_com,
        R.drawable.animal_domestic_pet_12_svgrepo_com,
        R.drawable.animal_cat_domestic_2_svgrepo_com,
        R.drawable.animal_domestic_pet_7_svgrepo_com,
        R.drawable.animal_domestic_face_3_svgrepo_com,
        R.drawable.animal_domestic_pet_12_svgrepo_com
    )
    val scope = rememberCoroutineScope()

    // Content
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Pager Screen")
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    showPagerOne.value = true
                    showPagerTwo.value = false
                }
            ) {
                Text(text = "Pager 1")
            }
            Button(
                onClick = {
                    showPagerOne.value = false
                    showPagerTwo.value = true
                }
            ) {
                Text(text = "Pager 1")
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        // Horizontal Pager Ui
        AnimatedVisibility(visible = showPagerOne.value) {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "Horizontal Pager")
                Spacer(modifier = Modifier.height(10.dp))
                HorizontalPager(
                    pageSize = PageSize.Fixed(200.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(200.dp),
                    state = pageState,
                    pageSpacing = 20.dp
                ) {
                    Text(text = "${it + 1}", fontSize = 21.sp, fontWeight = FontWeight.Bold)
                    Image(
                        modifier = Modifier
                            .background(Color.Cyan)
                            .clip(RoundedCornerShape(18.dp)),
                        painter = painterResource(id = data[it]),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                ) {
                    Button(onClick = { scope.launch { pageState.animateScrollToPage(4) } }) {
                        Text(text = "#5 ", fontSize = 21.sp, fontWeight = FontWeight.Bold)
                    }
                    Button(onClick = { scope.launch { pageState.animateScrollToPage(0) } }) {
                        Text(text = "#1 ", fontSize = 21.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Vertical Pager Ui
        AnimatedVisibility(visible = showPagerTwo.value) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Vertical Pager")
                Spacer(modifier = Modifier.height(10.dp))
                VerticalPager(
                    pageSize = object : PageSize {
                        override fun Density.calculateMainAxisPageSize(
                            availableSpace: Int,
                            pageSpacing: Int
                        ): Int {
                            return ((availableSpace - 2 * pageSpacing) * 0.5f).toInt()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .aspectRatio(1f),
                    state = verticalPagerState,
                    pageSpacing = 20.dp
                ) {
                    Image(
                        modifier = Modifier
                            .background(Color.Yellow)
                            .clip(RoundedCornerShape(8.dp)),
                        painter = painterResource(id = data[it]),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

