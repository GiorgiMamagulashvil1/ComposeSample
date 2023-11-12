package com.gm.composesample.nav

sealed class Routes(val route: String) {
    object Main: Routes("main")
    object LazyRow : Routes("lazy_row")
    object LazyColumn : Routes("lazy_column")
    object ModalBottomSheet: Routes("modal_bottom_sheet")
    object Pager: Routes("pager")
}
