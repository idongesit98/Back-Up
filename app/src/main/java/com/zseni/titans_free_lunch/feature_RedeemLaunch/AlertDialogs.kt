package com.zseni.titans_free_lunch.feature_RedeemLaunch

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zseni.titans_free_lunch.R
import com.zseni.titans_free_lunch.ui.theme.btnContent

@Composable
fun DismissDialog(
    onDismiss: () -> Unit,
){
    Dialog(
        onDismissRequest = {
            onDismiss
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(2.dp, color = Color.White, shape = RoundedCornerShape(20.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier
                        .size(60.dp),
                    painter = painterResource(id = R.drawable.warning_2),
                    contentDescription = "dialog warning"
                )
                Text(
                    text = "Unsuccessful",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "This country is not supported",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
                Spacer(modifier = Modifier.height(5.dp))
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .absolutePadding(right = 10.dp),
                    onClick = { onDismiss },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = btnContent
                    ),
                    ) {
                    Text(text = "Go back")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDialog(){
    DismissDialog(
        onDismiss = { /*TODO*/ }
    )
}

@Composable
fun ConfirmDialog(
    onConfirm: () -> Unit
){
    Dialog(
        onDismissRequest = {
            onConfirm
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(2.dp, color = Color.White, shape = RoundedCornerShape(20.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier
                        .size(60.dp),
                    painter = painterResource(id = R.drawable.check_v_good),
                    contentDescription = "dialog warning",
                    tint = Color.Green
                )
                Text(
                    text = "Redeem successful",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Your have successful redeemed 5 free \n " +
                            "lunches(N 2500). ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(5.dp))
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .absolutePadding(right = 10.dp),
                    onClick = { onConfirm },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = btnContent
                    ),
                ) {
                    Text(text = "Home")
                }
            }
        }
    }
}
@Preview
@Composable
fun PreviewCustomDialog(){
    ConfirmDialog(
        onConfirm = { /*TODO*/ }
    )
}
