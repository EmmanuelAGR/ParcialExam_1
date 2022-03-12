package emmanuelagr.example.application.parcialexam_1.screens.activities

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import emmanuelagr.example.application.parcialexam_1.components.AppBar
import emmanuelagr.example.application.parcialexam_1.components.CardTemplate

@SuppressLint("UnrememberedMutableState")
@Composable
fun Activity_6(
    navController: NavController
) {
    var number by remember { mutableStateOf("") }
    var numberRandom = (1..1000).random()
    var iteration = 0

    var result by remember { mutableStateOf("") }
    var enabled by remember { mutableStateOf(false) }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        OutlinedTextField(
            placeholder = { Text(text = "0") },
            label = { Text(text = "Número:") },
            value = number,
            onValueChange = {
                if (it.contains(regex = Regex("^[1-9]+([0-9]+)?$"))
                ) {
                    if (it.toIntOrNull() in 1..1000) {
                        number = it
                        visibility.value = false
                        enabled = true
                    }
                }
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.secondary,
                placeholderColor = MaterialTheme.colors.secondary
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }

    Scaffold(
        topBar = { AppBar(title = "Actividad No. 6", navController = navController) }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CardTemplate(
                title = "Acierta el Número",
                cardWidth = 300.dp,
                cardHeight = 300.dp,
                body = { CardBody() },
                visibility = visibility,
                enabled = enabled,
                onClick = {
                    val vNumber = if (number != "") number.toInt() else 0
                    val vNumberRandomOld = numberRandom
                    result = "Intento No. $iteration = "

                    when {
                        vNumber < numberRandom -> result += "El número es mayor que $vNumber."
                        vNumber > numberRandom -> result += "El número es menor que $vNumber."
                        else -> {
                            result += "Lo lograste el número era $numberRandom. " +
                                    when {
                                        iteration <= 3 -> "Felicidades!!!. Eres un suertudo."
                                        iteration <= 6 -> "Felicidades!!!. Eres un genio."
                                        iteration <= 8 -> "Sin embargo, se puede mejorar."
                                        else -> "Sin embargo, no eres muy inteligente."
                                    }

                            numberRandom = (1..1000).random()
                            iteration = 0
                            number = ""
                            enabled = false
                        }
                    }

                    if (vNumberRandomOld == numberRandom)
                        ++iteration
                },
                result = result,
                resultSize = 12.sp
            )
        }
    }
}
