package com.zseni.titans_free_lunch.feature_RedeemLaunch

import android.text.Layout
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.zseni.titans_free_lunch.R
import com.zseni.titans_free_lunch.ui.theme.btnColor
import com.zseni.titans_free_lunch.ui.theme.redeemColour

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WithdrawScreen(
) {
    val numbers = "012345678901"
    var numero by remember {
        mutableStateOf("")
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val bankName = listOf("First Bank","Zenith Bank","Wema Bank")

    var isSelectedBank by remember {
        mutableStateOf("")
    }
    var textFieldSize by remember {
        mutableStateOf(Size.Zero)
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Column {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.screen_name),
                    maxLines = 1
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
            ),
            actions = {
                FilledIconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = Color.LightGray
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(5.dp),
                        tint = Color.Black
                    )
                }
            }
        )
        Divider(
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            thickness = 2.dp
        )
        Column() {
            Box {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .background(color = MaterialTheme.colorScheme.background)
                        .clip(
                            shape = RoundedCornerShape(20.dp)
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF063B27)
                    )

                ) {
                    Text(
                        text = stringResource(id = R.string.lunch),
                        color = Color(0xFF535457),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .absolutePadding(left = 8.dp),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bread),
                            contentDescription = stringResource(id = R.string.bread),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(4.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.bread),
                            contentDescription = stringResource(id = R.string.bread),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(4.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.bread),
                            contentDescription = stringResource(id = R.string.bread),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(4.dp)
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.medal),
                                contentDescription = stringResource(id = R.string.medal),
                                modifier = Modifier
                                    .size(40.dp)
                                    .absolutePadding(right = 15.dp),
                            )
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row {
                Text(
                    text = "How would you like to redeem your free \n" +
                            " lunch? \uD83D\uDC40",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            FilledIconButton(
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = Color.LightGray
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.withdraw),
                    contentDescription = "Withdraw",
                    modifier = Modifier
                        .size(30.dp)
                        .absolutePadding(top = 10.dp),
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Withdraw",
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.padding(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = btnColor
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(30.dp)
                        .fillMaxWidth()
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                isExpanded = false
                            }
                        )
                ) {
                    Text(
                        modifier = Modifier.absolutePadding(left = 2.dp, bottom = 15.dp, top = 5.dp),
                        text = "Withdraw",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            TextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .border(
                                        width = 1.dp,
                                        color = Color.LightGray,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .onGloballyPositioned { coordiantes ->
                                        textFieldSize = coordiantes.size.toSize()
                                    },
                                value = isSelectedBank,
                                onValueChange = {
                                    isSelectedBank = it
                                    isExpanded = true
                                },
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    cursorColor = Color.Black
                                ),
                                textStyle = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp
                                ),
                                singleLine = true,
                                trailingIcon = {
                                    IconButton(
                                        onClick = { isExpanded = !isExpanded }) {
                                        Icon(
                                            imageVector = Icons.Default.ArrowDropDown,
                                            contentDescription = "Arrow Down"
                                        )
                                    }
                                }
                            )
                        }
                        AnimatedVisibility(visible = isExpanded) {
                            Card(
                                modifier = Modifier
                                    .padding(horizontal = 5.dp)
                                    .width(textFieldSize.width.dp),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 10.dp
                                )
                            ) {
                                LazyColumn(
                                    modifier =
                                    Modifier
                                        .heightIn(max = 150.dp)
                                ) {
                                    if (isSelectedBank.isNotEmpty()) {
                                        items(
                                            bankName.filter {
                                                it.lowercase()
                                                    .contains(isSelectedBank.lowercase()) || it.lowercase()
                                                    .contains("others")
                                            }.sorted()
                                        ) {
                                            CategoryItems(title = it) { title ->
                                                isSelectedBank = title
                                                isExpanded = false
                                            }
                                        }
                                    } else {
                                        items(
                                            bankName.sorted()
                                        ) {
                                            CategoryItems(title = it) { title ->
                                                isSelectedBank = title
                                                isExpanded = false
                                            }
                                        }
                                    }

                                }

                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .border(
                                width = 1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .onGloballyPositioned { coordiantes ->
                                textFieldSize = coordiantes.size.toSize()
                            },
                        value = numbers,
                        onValueChange = {
                            numero = it
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Gege Akutami")
                        Icon(
                            painter = painterResource(id = R.drawable.tick_circle),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp),
                            tint = Color.Green
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .border(
                                width = 2.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        value = "How much do you want to redeem?",
                        onValueChange = {},
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Triple lunch = N 500")
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .absolutePadding(top = 10.dp, left = 20.dp, right = 20.dp)
                ) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .onGloballyPositioned { coordiantes ->
                                    textFieldSize = coordiantes.size.toSize()
                                },
                            value = isSelectedBank,
                            onValueChange = {
                                isSelectedBank = it
                                isExpanded = true
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.Black
                            ),
                            textStyle = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp
                            ),
                            singleLine = true,
                            trailingIcon = {
                                IconButton(
                                    onClick = { isExpanded = !isExpanded }) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowDropDown,
                                        contentDescription = "Arrow Down"
                                    )
                                }
                            }
                        )
                    }
                    AnimatedVisibility(visible = isExpanded) {
                        Card(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .width(textFieldSize.width.dp),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 10.dp
                            )
                        ) {
                            LazyColumn(
                                modifier =
                                Modifier
                                    .heightIn(max = 150.dp)
                            ) {
                                if (isSelectedBank.isNotEmpty()) {
                                    items(
                                        bankName.filter {
                                            it.lowercase()
                                                .contains(isSelectedBank.lowercase()) || it.lowercase()
                                                .contains("others")
                                        }.sorted()
                                    ) {
                                        CategoryItems(title = it) { title ->
                                            isSelectedBank = title
                                            isExpanded = false
                                        }
                                    }
                                } else {
                                    items(
                                        bankName.sorted()
                                    ) {
                                        CategoryItems(title = it) { title ->
                                            isSelectedBank = title
                                            isExpanded = false
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    containerColor = redeemColour,
                    contentColor = Color.Green,
                    shape = CircleShape,
                    modifier = Modifier
                        .align(Alignment.End)
                        .absolutePadding(right = 10.dp)
                ) {
                    Icon(Icons.Default.ArrowForward, "FAB")
                }

            }

        }

    }
}

@Composable
fun CategoryItems(
    title:String,
    onSelect:(String)->Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onSelect(title)
        }
        .padding(10.dp)
    ){
        Text(
            text = title,
            fontSize = 16.sp)
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewWithdrawScreen(){
    WithdrawScreen()
}
