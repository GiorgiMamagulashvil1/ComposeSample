package com.gm.composesample.screen.sub_screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gm.composesample.R
@Composable
fun LazyColumnScreen() {

    val showFirstExample = remember {
        mutableStateOf(true)
    }
    val showSecondExample = remember {
        mutableStateOf(false)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (!showFirstExample.value) {
                        showFirstExample.value = true
                    }
                    showSecondExample.value = false
                },
            ) {
                Text(text = "Lazy Column 1")
            }
            Button(
                onClick = {
                    if (!showSecondExample.value) {
                        showSecondExample.value = true
                    }
                    showFirstExample.value = false
                },
            ) {
                Text(text = "Lazy Column 2")
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        AnimatedVisibility(visible = showFirstExample.value) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(0.9f),
                content = {
                    items(itemsForFirstExample()) { item ->
                        when (item.status) {
                            UserStatus.Active -> UserActiveItem(
                                item = item,
                                modifier = Modifier.fillMaxWidth()
                            )

                            UserStatus.InActive -> UserInActiveItem(
                                item = item,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            )
        }
        AnimatedVisibility(visible = showSecondExample.value) {
            ContactListUi(
                contactGroupsList = getSecondExampleList(),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

// Lazy Column Example 2
private data class PaymentItem(
    val category: String,
    val name: String
)

private data class PaymentGroup(
    val title: String,
    val paymentItems: List<PaymentItem>
)

private val listOfPaymentItem = listOf(
    PaymentItem(
        category = "კომუნალურები",
        name = "ენერგო-პრო"
    ),
    PaymentItem(
        category = "კომუნალურები",
        name = "თელმიკო"
    ),
    PaymentItem(
        category = "კომუნალურები",
        name = "სოკარი"
    ),
    PaymentItem(
        category = "კომუნალურები",
        name = "გაზი"
    ),
    PaymentItem(
        category = "კომუნალურები",
        name = "თბილისის დასუფთავება"
    ),
    PaymentItem(
        category = "კომუნალურები",
        name = "მსოფლიო დასუფთავება"
    ),
    PaymentItem(
        category = "კომუნალურები",
        name = "წყალი"
    ),
    PaymentItem(
        category = "კომუნალურები",
        name = "ჰაერის გადასახადი"
    ),
    PaymentItem(
        category = "კომუნალურები",
        name = "საწვავი"
    ),
    PaymentItem(
        category = "ინტერნეტი",
        name = "მაგთი"
    ),
    PaymentItem(
        category = "ინტერნეტი",
        name = "მაგთი"
    ),
    PaymentItem(
        category = "ინტერნეტი",
        name = "სილქნეტი"
    ),
    PaymentItem(
        category = "ინტერნეტი",
        name = "სქაიტელ"
    ),
    PaymentItem(
        category = "ინტერნეტი",
        name = "ფონიჭალა ნეტ"
    ),
    PaymentItem(
        category = "ინტერნეტი",
        name = "ვარკეთილი ნეტ"
    ),
    PaymentItem(
        category = "ინტერნეტი",
        name = "სილქნეტი 2"
    ),
    PaymentItem(
        category = "ინტერნეტი",
        name = "მაგთი 2 ნელი ინტერნეტი"
    ),
    PaymentItem(
        category = "მობილური ოპერატორები",
        name = "მაგთი"
    ),
    PaymentItem(
        category = "მობილური ოპერატორები",
        name = "სელფი"
    ),
    PaymentItem(
        category = "მობილური ოპერატორები",
        name = "ჯეოსელი"
    ),
    PaymentItem(
        category = "მობილური ოპერატორები",
        name = "სილქნეტი"
    ),
    PaymentItem(
        category = "მობილური ოპერატორები",
        name = "ბილაინი"
    ),
    PaymentItem(
        category = "სხვადასხვა",
        name = "ბთუ"
    ),
    PaymentItem(
        category = "სხვადასხვა",
        name = "პოლიციის ჯარიმა"
    ),
    PaymentItem(
        category = "სხვადასხვა",
        name = "ჯარიმები"
    ),
    PaymentItem(
        category = "სხვადასხვა",
        name = "პარკინგი"
    ),
    PaymentItem(
        category = "სხვადასხვა",
        name = "პარკინგის ჯარიმა"
    ),
)

private fun getSecondExampleList(): List<PaymentGroup> {
    return listOfPaymentItem.groupBy {
        it.category
    }.map { (category, items) ->
        PaymentGroup(
            title = category,
            paymentItems = items
        )
    }
}

@Composable
private fun PaymentItem(
    item: String
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = item, color = Color.Black, fontSize = 17.sp)
    }
}

@Composable
private fun CategoryHeader(
    title: String
) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray),
            color = Color.White
        )
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContactListUi(
    contactGroupsList: List<PaymentGroup>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        contactGroupsList.forEach { item ->
            stickyHeader {
                CategoryHeader(title = item.title)
            }
            items(item.paymentItems) {
                PaymentItem(item = it.name)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

// Lazy Column Example 1
@Composable
private fun UserInActiveItem(
    item: UserModel,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.height(60.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "No Image",
                modifier = Modifier.size(60.dp),
                textAlign = TextAlign.Center,
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = item.username, fontStyle = FontStyle.Normal)
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = ".InActive",
                    fontStyle = FontStyle.Italic,
                    fontSize = 8.sp,
                    color = Color.Red
                )
            }

        }
    }
}

@Composable
private fun UserActiveItem(
    item: UserModel,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.height(60.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imageRes!!),
                contentDescription = "",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = item.username, fontStyle = FontStyle.Normal)
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = ".Active",
                    fontStyle = FontStyle.Italic,
                    fontSize = 8.sp,
                    color = Color.Green
                )
            }
        }
    }
}

private fun itemsForFirstExample(): List<UserModel> {
    val imageList = listOf(
        R.drawable.animal_domestic_pet_12_svgrepo_com,
        R.drawable.animal_domestic_pet_7_svgrepo_com,
        null
    )

    val data = mutableListOf<UserModel>()
    (1..35).forEach {
        val randomImage = imageList.random()
        data.add(
            UserModel(
                username = "User $it",
                imageRes = randomImage,
                status = if (randomImage == null) UserStatus.InActive else UserStatus.Active
            )
        )
    }
    return data
}

private data class UserModel(
    val username: String,
    val imageRes: Int? = null,
    val status: UserStatus,
)

private enum class UserStatus {
    Active, InActive
}
