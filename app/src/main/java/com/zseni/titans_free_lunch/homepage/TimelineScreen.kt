@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)
package com.zseni.titans_free_lunch.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.titansfreelunch.ui.theme.DarkGreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimelineScreen(
) {

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            item {
                ReceivedLunchCard(
                    modifier = Modifier,
                    name = "John Mao",
                    remark = "Hi, Sam. The work you do is very much appreciated. Keep doing what you know how " +
                            "to do best.",
                    amount = 3
                )
            }
            items(3) {
                SentLunchCard(modifier = Modifier, name = "Mary Jao", amount = 6)
            }
            item {
                ReceivedLunchCard(
                    modifier = Modifier,
                    name = "Ken Tao",
                    remark = "Hi, Sam. The work you do is very much appreciated. Keep doing what you know how " +
                            "to do best.",
                    amount = 3
                )
            }
            items(3) {
                SentLunchCard(modifier = Modifier, name = "Gary Jao", amount = 6)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun FirstPreview() {
    TimelineScreen()
}

@Composable
fun ReceivedLunchCard(
    modifier: Modifier,
    name: String,
    remark: String,
    amount: Int
) {
    Card(
        modifier
            .padding(5.dp)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "You got a Triple Lunch!",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.width(100.dp))
            Text(
                modifier = Modifier.padding(10.dp),
                text = "1 hr ago",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = Color.LightGray
                )
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.LightGray)
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp),
                    text = name,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                        color = Color.Black
                    )
                )
                Text(
                    modifier = Modifier.padding(start = 15.dp, bottom = 10.dp),
                    text = remark,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Column {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "You received",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        color = Color.LightGray
                    )
                )
                Row(modifier = Modifier.padding(bottom = 5.dp, start = 10.dp)) {
                    Icon(imageVector = Icons.Filled.CurrencyPound, contentDescription = "Money")
                    //Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = amount.toString(),
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                            color = Color.Black
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.width(150.dp))
            Button(
                modifier = Modifier
                    .padding(top = 15.dp),
                onClick = {
                          // takes you to the redeem lunch screen
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkGreen
                ),
                elevation = ButtonDefaults.buttonElevation(5.dp)
            ) {
                Text(
                    text = "Redeem!!",
                    color = Color.White
                )
            }
        }
    }
}


@Composable
fun SentLunchCard(
    modifier: Modifier,
    name: String,
    amount: Int
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier
                .padding(10.dp)
                .wrapContentSize(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Row {
                Column {
                    Text(
                        modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                        text = "You sent to:",
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                            color = Color.LightGray
                        )
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = name,
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                            color = Color.Black
                        )
                    )
                }
                Spacer(modifier = Modifier.width(130.dp))
                Column {
                    Text(
                        modifier = Modifier.padding(start = 80.dp, top = 10.dp, end = 5.dp),
                        text = "2hr ago",
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                            color = Color.LightGray
                        )
                    )
                    Row(modifier = Modifier.padding(top = 15.dp, start = 80.dp, bottom = 5.dp)) {
                        Icon(imageVector = Icons.Filled.CurrencyPound, contentDescription = "Money")
                        Text(
                            text = amount.toString(),
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                                color = Color.Black
                            )
                        )
                    }
                }
            }
        }
    }
}