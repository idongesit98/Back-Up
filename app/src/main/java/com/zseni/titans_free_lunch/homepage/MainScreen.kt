@file:OptIn(ExperimentalMaterial3Api::class)

package com.zseni.titans_free_lunch.homepage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Green
                    ),
                    title = {
                        Text( text = "Home",
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black )
                        ) },
                    scrollBehavior = scrollBehavior
                )
            },
            bottomBar = { BottomBar(navController = navController) },
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(30.dp),
                    containerColor = DarkGreen
                ) {
                    Icon(imageVector = Icons.Filled.ArrowRight,
                        contentDescription = "Next",
                        tint = Green
                    )
                }
            }
        ) { padding ->
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(padding)) {
                SetupNavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController
) {

    val screens = listOf(
        BottomBarScreen.Timeline,
        BottomBarScreen.People,
        BottomBarScreen.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.White,
    ) {
        screens.forEachIndexed{ index, screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
                index = index
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
    index: Int
) {

    val bottomNavState by rememberSaveable() {
        mutableStateOf(0)
    }

    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = if (bottomNavState == index) screen.selectedIcon
                else screen.unSelectedIcon,
                contentDescription = screen.title,
                tint = if (bottomNavState == index) DarkGreen
                else Color.Black
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = DarkGreen,
            selectedTextColor = Color.Black,
            indicatorColor = Green
        )
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MainScreenPreview() {
    MainScreen()
}