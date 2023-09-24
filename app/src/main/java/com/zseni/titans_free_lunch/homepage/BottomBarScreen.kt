package com.zseni.titans_free_lunch.homepage

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Timeline
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
) {
    object Timeline : BottomBarScreen(
        route = "timeline_screen",
        title = "Timeline",
        selectedIcon = Icons.Filled.Timeline,
        unSelectedIcon = Icons.Outlined.Timeline
    )
    object People : BottomBarScreen(
        route = "people_screen",
        title = "People",
        selectedIcon = Icons.Filled.People,
        unSelectedIcon = Icons.Outlined.People
    )
    object Settings : BottomBarScreen(
        route = "settings_screen",
        title = "Settings",
        selectedIcon = Icons.Filled.Settings,
        unSelectedIcon = Icons.Outlined.Settings
    )
}
