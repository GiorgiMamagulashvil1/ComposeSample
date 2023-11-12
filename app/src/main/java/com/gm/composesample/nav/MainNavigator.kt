package com.gm.composesample.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gm.composesample.screen.MainScreen
import com.gm.composesample.screen.sub_screens.BottomSheetScreen
import com.gm.composesample.screen.sub_screens.LazyGrid
import com.gm.composesample.screen.sub_screens.LazyRowScreen

@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = Routes.Main.route) {
        composable(route = Routes.Main.route) {
            MainScreen(navHostController = navHostController)
        }
        composable(route = Routes.LazyRow.route) {
            LazyRowScreen()
        }
        composable(route = Routes.LazyGrid.route) {
            LazyGrid()
        }
        composable(route = Routes.BottomSheet.route){
            BottomSheetScreen()
        }
    }
}