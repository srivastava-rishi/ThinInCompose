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

/*
 In this example, we demonstrate the simplicity of Jetpack Compose by using a single
 activity that hosts the entire navigation graph. This approach eliminates the need for
 multiple activities and fragments, which is one of the advantages of adopting Compose.
*/
class ThinkInComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavGraph()
        }
    }

    // Composable function defining the navigation graph
    @Composable
    fun NavGraph() {
        // NavController manages navigation within the app's screens
        val navController = rememberNavController()
        // Setting up the navigation graph using NavHost
        NavHost(
            navController = navController,
            startDestination = "HomeScreen"
        ) {
            // Screen for the HomeScreen destination
            composable("HomeScreen") {
                HomeScreen(
                    // Passes a callback to navigate to the detail screen when users click on "Read More"
                    goToDetailScreen = {
                        navController.navigate("NewsDetailScreen/$it")
                    }
                )
            }
            // Screen for the NewsDetailScreen destination, with a dynamic newsId argument
            composable(
                "NewsDetailScreen/{newsId}",
                // Screen for the NewsDetailScreen destination, with a dynamic newsId argument passed during navigation to avoid runtime exceptions.
                arguments = listOf(
                    navArgument("newsId") { type = NavType.StringType }
                )
            ) { it ->
                NewsDetailScreen(
                    // Retrieving the newsId from navigation arguments
                    newsId = it.arguments?.getString("newsId"),
                    // Callback to navigate back to the previous screen
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}