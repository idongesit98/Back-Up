package com.zseni.titans_free_lunch.homepage

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = BottomBarScreen.Timeline.route) {
        composable(route = BottomBarScreen.Timeline.route) {
            TimelineScreen()
        }
        composable(route = BottomBarScreen.People.route) {
            PeopleScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            //settings screen
        }
    }
}