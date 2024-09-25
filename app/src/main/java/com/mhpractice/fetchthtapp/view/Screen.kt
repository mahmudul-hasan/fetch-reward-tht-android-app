package com.mhpractice.fetchthtapp.view

/**
 * This is the screen class where the screens are defined by their routs.
 *
 * @author Mahmudul Hasan.
 */
sealed class Screen(val route: String) {
    object MainScreen : Screen("MainScreen")
}
