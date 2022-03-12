package emmanuelagr.example.application.parcialexam_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import emmanuelagr.example.application.parcialexam_1.routes.Routes
import emmanuelagr.example.application.parcialexam_1.ui.theme.ParcialExam_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParcialExam_1Theme {
                // A surface container using the 'background' color from the theme
                Routes()
            }
        }
    }
}