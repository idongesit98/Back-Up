@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.zseni.titans_free_lunch.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.titansfreelunch.R


@Composable
fun PeopleScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 10.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.align(TopCenter)
            ) {
                Row(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    StatusItem(label = "1", modifier = Modifier.padding(5.dp))
                    Divider(
                        modifier = Modifier
                            .width(170.dp)
                            .padding(top = 40.dp),
                        thickness = 3.dp,
                        color = Color.LightGray)
                    StatusItem(label = "2", modifier = Modifier.padding(5.dp))
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

        Spacer(modifier = Modifier.padding(top = 20.dp))

        Box(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
        ) {
            SearchAppBar(
                text = "Search name...",
                onTextChanged = {},
                onCloseClicked = {},
                onSearchClicked = {}
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Box(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                items(15) {
                    WorkersList(name = "Jane Mao")
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PeopleScreenPreview() {
    PeopleScreen()
}


@Composable
fun WorkersList(
    checked: Boolean = false,
    name: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            Box(modifier = Modifier
                .size(70.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))
            ) {
                Image(painter = painterResource(id = R.drawable.avatar), contentDescription = "Image")
            }
            Text(
                modifier = Modifier.padding(top = 20.dp, start = 10.dp),
                text = name,
                style = TextStyle(
                    fontSize = 25.sp,
                    color = Color.Black
                )
            )
            Checkbox(
                modifier = Modifier.padding(start = 130.dp, top = 10.dp),
                checked = false,
                onCheckedChange = {
                                  //change the color of the 1 circle
                },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color.LightGray,
                    checkedColor = Color.Black
                )
            )
        }
    }
}


@Composable
fun StatusItem(
    label: String,
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    enabled: Boolean = false
) {
    val color = if (enabled) Color(0xFFCFFF92) else Color(0xFFE6EBE9)
    val textColor = if (enabled) Color.Black else Color.Gray

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
                color = textColor
            )
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    text: String,
    onTextChanged: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {

    var searchText by remember { mutableStateOf( "") }

    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(65.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChanged(it)
                //search bar logic to get names of workers with the letters inputed
            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(alpha = 0.5f),
                    text = text,
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 25.sp
                    )
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = { },
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.LightGray
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Black
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()) {
                            onTextChanged("")
                        } else {
                            onCloseClicked()
                        }
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.LightGray
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon",
                        tint = Color.Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White.copy(alpha = 0.5f)
            )
        )
    }
}