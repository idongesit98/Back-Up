@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.zseni.titans_free_lunch.homepage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.CurrencyPound
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.titansfreelunch.ui.theme.DarkGreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetailScreen() {

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    var personalMessage by remember{ mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color.White
                    ),
                    title = {
                        Text(
                            text = "Send Lunch",
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        )
                    },
                    scrollBehavior = scrollBehavior,
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Filled.Cancel,
                                contentDescription = "Cancel send lunch"
                            )
                        }
                    }
                )
            },
            bottomBar = { BottomBar() }
        ) { paddingValues ->

            Column(modifier = Modifier.padding(paddingValues)) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.align(Alignment.TopCenter)
                    ) {
                        Row(
                            modifier = Modifier.padding(start = 10.dp)
                        ) {
                            StatusIcon(
                                icon = Icons.Filled.Check,
                                enabled = true,
                                modifier = Modifier.padding(5.dp))
                            Divider(
                                modifier = Modifier
                                    .width(170.dp)
                                    .padding(top = 40.dp),
                                thickness = 3.dp,
                                color = Color.Green
                            )
                            StatusItemEnabled(
                                label = "2",
                                enabled = true,
                                modifier = Modifier.padding(5.dp))
                        }
                        Row(
                            modifier = Modifier.padding(top = 5.dp)
                        ) {
                            Text(
                                text = "Select a worker",
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.width(170.dp))
                            Text(
                                text = "Send lunch",
                                color = Color.LightGray
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier.padding(top = 10.dp, start = 20.dp),
                    text = "Personal message",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 15.sp
                    )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .width(350.dp)
                        .height(150.dp)
                        .align(Alignment.CenterHorizontally),
                    value = personalMessage,
                    onValueChange = { personalMessage = it },
                    label = { Text(text = "Add personal message...") },
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Black,
                        containerColor = Color.Transparent,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))
                LunchBalance(modifier = Modifier, amount = "10")

                Spacer(modifier = Modifier.height(10.dp))
                SendLunchSection()
            }
        }
    }
}

@Composable
fun BottomBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.BottomEnd
    ) {
        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {
                      //to send lunch
                      //and show dialog if lunch is sent
                      //then call lunch sent dialog
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkGreen
            )
        ) {
            Text(text = "Send", style = TextStyle(fontSize = 15.sp), color = Color.White)
        }
    }
}


@Composable
fun CurrencyCard(
    modifier: Modifier,
    amount: String
) {

    Card(
        modifier
            .padding(5.dp)
            .width(200.dp)
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(top = 20.dp, start = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = amount,
                style = TextStyle(
                    fontSize = 25.sp
                ),
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(25.dp))
            Icon(imageVector = Icons.Filled.CurrencyPound, contentDescription = "Currency")
        }
    }
}


@Composable
fun LunchBalance(
    modifier: Modifier,
    amount: String
) {
    Card(
        modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(50.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(modifier = Modifier.padding(15.dp)
        ) {
                Text(
                    text = "Lunch balance:",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 20.sp
                    )
                )
            Spacer(modifier = Modifier.width(150.dp))
                Row {
                    Icon(imageVector = Icons.Filled.CurrencyPound, contentDescription = "Currency")
                    Text(text = amount, style = TextStyle(
                        fontSize = 20.sp
                    )
                    )
                }
        }
    }
}


@Composable
fun SendLunchSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Send lunch",
            style = TextStyle(color = Color.Black, fontSize = 20.sp),
            modifier = Modifier.padding(10.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            item{
                CurrencyCard(modifier = Modifier, amount = "Single")
            }
            item {
                CurrencyCard(modifier = Modifier, amount = "Double")
            }
            item {
                CurrencyCard(modifier = Modifier, amount = "Triple")
            }
            item {
                CurrencyCard(modifier = Modifier, amount = "Quadruple")
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun LunchSentDialog(
    sent: Boolean
) {
    //the dialog logic
    var showDialog by remember { mutableStateOf(sent) }

    if (showDialog) {
            Dialog(
                onDismissRequest = {
                    showDialog = false
                    //code to navigate back to home page
                },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                Card( modifier = Modifier
                    .height(330.dp)
                    .background(Color.White)){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                ) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircleOutline,
                        modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 10.dp),
                        contentDescription = "Check",
                        tint = com.example.titansfreelunch.ui.theme.Green
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Lunch Sent!",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.headlineLarge.fontSize
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = "You've just brightened someone's day and added some flavor to their" +
                                " week. Expect a thanks from them soon!",
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedButton(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        onClick = {
                            //navigate to home screen
                        },
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        Text(
                            text = "Go to Timeline",
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DetailTest() {
    PostDetailScreen()
}

@Composable
fun StatusIcon(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    enabled: Boolean = false
) {
    val color = if (enabled) DarkGreen else Color(0xFFE6EBE9)
    val textColor = if (enabled) Color.Black else Color.Gray

    Box(
        modifier = modifier
            .size(70.dp)
            .clip(CircleShape)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Icon(imageVector = icon, contentDescription = "Check Icon", tint = Color.Green)
    }
}

@Composable
fun StatusItemEnabled(
    label: String,
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    enabled: Boolean = false
) {
    val color = if (enabled) com.example.titansfreelunch.ui.theme.Green else Color(0xFFE6EBE9)

    Box(
        modifier = modifier
            .size(70.dp)
            .clip(CircleShape)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
    }

}
        

               