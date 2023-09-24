package com.mbabalola.titansscreens

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItems(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val route: String
)
