package com.strv.movies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.strv.movies.ui.login.LogInScreen
import com.strv.movies.ui.moviedetail.MovieDetailScreen
import com.strv.movies.ui.movieslist.MoviesListScreen

@Composable
fun MoviesNavGraph(
    navController: NavHostController = rememberNavController(),
    isDarkTheme: Boolean,
    onChangeThemeClick: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = MoviesDestinations.LOGIN_ROUTE
    ) {
        composable(MoviesDestinations.MOVIES_LIST_ROUTE) {
            MoviesListScreen(
                navigateToMovieDetail = { movieId ->
                    navController.navigate("${MoviesDestinations.MOVIE_DETAIL_ROUTE}/$movieId")
                },
                isDarkTheme = isDarkTheme,
                onChangeThemeClick = onChangeThemeClick
            )
        }

        composable(
            route = "${MoviesDestinations.MOVIE_DETAIL_ROUTE}/{${MoviesNavArguments.MOVIE_ID_KEY}}",
            arguments = listOf(
                navArgument(MoviesNavArguments.MOVIE_ID_KEY) {
                    type = NavType.IntType
                }
            )
        ) {
            MovieDetailScreen(
                isDarkTheme = isDarkTheme,
                onChangeThemeClick = onChangeThemeClick,
                onNavigateBackClick = {
                    navController.navigate(
                        MoviesDestinations.MOVIES_LIST_ROUTE
                    )
                }
            )
        }
        composable(
            route = MoviesDestinations.LOGIN_ROUTE
        ) {
            LogInScreen(
                onLoginClick = {
                    navController.navigate(MoviesDestinations.MOVIES_LIST_ROUTE)
                },
                isDarkTheme = isDarkTheme,
                onChangeThemeClick = onChangeThemeClick
            )
        }
    }
}