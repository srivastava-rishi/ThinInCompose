package com.example.thinkincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.thinkincompose.ui.theme.ThinkInComposeTheme

class ThinkInComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThinkInComposeTheme {
                NavGraph()
            }
        }
    }

    @Composable
    fun NavGraph() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "HomeScreen"
        ) {
            composable("HomeScreen") {
                HomeScreen(
                    goToDetailScreen = {
                        navController.navigate("NewsDetailScreen/$it")
                    }
                )
            }
            composable(
                "NewsDetailScreen/{newsId}",
                arguments = listOf(navArgument("newsId") { type = NavType.StringType })
            ) { backStackEntry ->
                NewsDetailScreen(
                    newsId = backStackEntry.arguments?.getString("newsId"),
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}