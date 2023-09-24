package com.zseni.titans_free_lunch.feature_RedeemLaunch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zseni.titans_free_lunch.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RedeemScreen(
) {
    /**
    val allItems = remember {
        mutableStateOf<List<Item>>(emptyList())
    }
    **/

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
        Column {
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
            Text(
                text = "How would you like to redeem your free " +
                    "lunch?",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp)
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

        }
        //Spacer(modifier = Modifier.height(15.dp))
        var isLoading by remember{
            mutableStateOf(true)
        }
        LaunchedEffect(key1 = true){
            delay(10000)
            isLoading = false
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
            items(3) {
                ShimmerListItem(
                    isloading = isLoading,
                    contentAfterLoading = {
                        Column{
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(20.dp)
                                    .shimmerEffect()
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .height(20.dp)
                                    .shimmerEffect()
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .height(20.dp)
                                    .shimmerEffect()
                            )
                        }
                    },
                )
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun PreviewRedeemScreen(){
    RedeemScreen(
        //isloading = false,
       // contentAfterLoading = {}
    )
}
