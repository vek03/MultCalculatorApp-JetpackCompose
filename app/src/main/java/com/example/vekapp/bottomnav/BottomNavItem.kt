package com.example.vekapp.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title:String, var icon: ImageVector, var screen_route:String){

    object Distance : BottomNavItem("Distance", Icons.Filled.Star,"distance")

    object SecondG: BottomNavItem("Second G",Icons.Filled.Warning,"secondG")

    object PointM: BottomNavItem("Point M",Icons.Filled.Favorite,"pointM")

    object Distributive: BottomNavItem("Distributive",Icons.Filled.PlayArrow,"distributive")

    object Calculator: BottomNavItem("Calculator", Icons.Filled.Add ,"Calculator")

}