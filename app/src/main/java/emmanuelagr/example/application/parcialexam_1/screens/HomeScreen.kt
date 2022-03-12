package emmanuelagr.example.application.parcialexam_1.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import emmanuelagr.example.application.parcialexam_1.components.ActivitiesList
import emmanuelagr.example.application.parcialexam_1.components.AppBar

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = { AppBar("Parcial Exam No. 1") },
        content = {
            ActivitiesList(navController)
        }
    )
}