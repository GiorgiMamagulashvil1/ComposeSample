package com.gm.composesample.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gm.composesample.screen.MainScreen
import com.gm.composesample.screen.sub_screens.BottomSheetScreen
import com.gm.composesample.screen.sub_screens.DialogScreen
import com.gm.composesample.screen.sub_screens.LazyColumnScreen
import com.gm.composesample.screen.sub_screens.LazyGrid
import com.gm.composesample.screen.sub_screens.LazyRowScreen
import com.gm.composesample.screen.sub_screens.ModalBottomSheetScreen
import com.gm.composesample.screen.sub_screens.PagerScreen

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
        composable(route = Routes.BottomSheet.route) {
            BottomSheetScreen()
        }
        composable(route = Routes.LazyColumn.route) {
            LazyColumnScreen()
        }
        composable(route = Routes.ModalBottomSheet.route) {
            ModalBottomSheetScreen()
        }
        composable(route = Routes.Pager.route) {
            PagerScreen()
        }
        composable(route = Routes.Dialog.route) {
            DialogScreen()
        }
    }
}