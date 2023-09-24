package com.zseni.titans_free_lunch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zseni.titans_free_lunch.feature_RedeemLaunch.RedeemScreen
import com.zseni.titans_free_lunch.ui.theme.Titans_FreeLunchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Titans_FreeLunchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                   // modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    RedeemScreen()
                }
            }
        }
    }
}

/**
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    RedeemScreen()
}
**/

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Titans_FreeLunchTheme {
       RedeemScreen()
    }
}