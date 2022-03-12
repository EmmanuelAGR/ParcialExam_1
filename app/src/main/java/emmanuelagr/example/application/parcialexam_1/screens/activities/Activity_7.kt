package emmanuelagr.example.application.parcialexam_1.screens.activities

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
fun Activity_7(
    navController: NavController
) {
    var dividend by remember { mutableStateOf("") }
    var divider by remember { mutableStateOf("") }

    var result by remember { mutableStateOf("") }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        OutlinedTextField(
            placeholder = { Text(text = "0") },
            label = { Text(text = "Dividendo:") },
            value = dividend,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+([0-9]+)?$")) && it.length <= 10
                    || it == ""
                ) {
                    dividend = it
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

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            placeholder = { Text(text = "0") },
            label = { Text(text = "Divisor:") },
            value = divider,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+([0-9]+)?$")) && it.length <= 10
                    || it == ""
                ) {
                    divider = it
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
        topBar = { AppBar(title = "Actividad No. 7", navController = navController) }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CardTemplate(
                title = "Division usando Restas",
                cardWidth = 300.dp,
                cardHeight = 360.dp,
                body = { CardBody() },
                visibility = visibility,
                onClick = {
                    val vDividend = if (dividend != "") dividend.toInt() else 0
                    val vDivider = if (divider != "") divider.toInt() else 0
                    var rest = vDividend
                    var quotient = 0

                    while (rest >= vDivider && rest != 0 && vDivider != 0) {
                        ++quotient
                        rest -= vDivider
                    }

                    result = if (vDividend < vDivider)
                        "Nota = El divisor no puede ser mayor que el dividendo."
                    else
                        "Residuo = $rest y Cociente = $quotient"
                },
                result = result,
                resultSize = 15.sp
            )
        }
    }
}