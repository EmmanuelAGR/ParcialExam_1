package emmanuelagr.example.application.parcialexam_1.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import emmanuelagr.example.application.parcialexam_1.screens.HomeScreen
import emmanuelagr.example.application.parcialexam_1.screens.activities.*

@Composable
fun Routes() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "/", builder = {
        composable(route = "/", content = { HomeScreen(navController) })
        composable(route = "/activity_5", content = { Activity_5(navController) })
        composable(route = "/activity_6", content = { Activity_6(navController) })
        composable(route = "/activity_7", content = { Activity_7(navController) })
        composable(route = "/activity_8", content = { Activity_8(navController) })
        composable(route = "/activity_10", content = { Activity_10(navController) })
    })
}