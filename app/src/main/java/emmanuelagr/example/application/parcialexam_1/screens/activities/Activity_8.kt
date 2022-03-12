package emmanuelagr.example.application.parcialexam_1.screens.activities

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

@Composable
fun Activity_8(
    navController: NavController
) {
    var number by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        OutlinedTextField(
            placeholder = { Text(text = "0") },
            label = { Text(text = "Número Entero:") },
            value = number,
            onValueChange = {
                if (it.contains(regex = Regex("^-([0-9]+)?$")) && it.length <= 10
                    || it.contains(regex = Regex("^[0-9]+([0-9]+)?$")) && it.length <= 10
                    || it == ""
                ) {
                    number = it
                    visibility.value = false
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
        topBar = { AppBar(title = "Actividad No. 8", navController = navController) }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CardTemplate(
                title = "Invertir Número Entero",
                cardWidth = 300.dp,
                cardHeight = 350.dp,
                body = { CardBody() },
                visibility = visibility,
                onClick = {

                    val invertedNumbers =
                        if (number != "" && number != "-") {
                            val vNumber = number.toMutableList()
                            val isNegative = vNumber.remove('-')
                            val invertedString = vNumber.asReversed().joinToString("")

                            if (isNegative && invertedString != "0") {
                                "-$invertedString"
                            } else
                                invertedString
                        } else
                            "0"

                    result = invertedNumbers
                },
                result = "Número Invertido = $result.",
                resultSize = 15.sp
            )
        }
    }
}