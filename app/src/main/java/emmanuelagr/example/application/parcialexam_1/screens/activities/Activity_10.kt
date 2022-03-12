package emmanuelagr.example.application.parcialexam_1.screens.activities

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import emmanuelagr.example.application.parcialexam_1.components.AppBar
import emmanuelagr.example.application.parcialexam_1.components.CardTemplate
import emmanuelagr.example.application.parcialexam_1.ui.theme.DarkGray
import emmanuelagr.example.application.parcialexam_1.ui.theme.Red
import emmanuelagr.example.application.parcialexam_1.ui.theme.White
import emmanuelagr.example.application.parcialexam_1.ui.theme.Yellow

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Activity_10(
    navController: NavController
) {
    var invoice by remember { mutableStateOf("") }
    val randomBall by remember { mutableStateOf((1..3).random()) }
    var percent = 0.0

    var result by remember { mutableStateOf(0.0) }
    var enabled by remember { mutableStateOf(false) }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        OutlinedTextField(
            placeholder = { Text(text = "0.0") },
            label = { Text(text = "Valor de la Factura:") },
            value = invoice,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+[.]?+([0-9]+)?$")) && it.length <= 10
                    || it == ""
                ) {
                    invoice = it
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

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { enabled = true }, enabled = !enabled) {
                Text(text = if (enabled) "Sacada" else "Sacar bola")
            }

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.weight(1F)) {
                AnimatedVisibility(
                    visible = enabled,
                    enter = fadeIn(animationSpec = tween(durationMillis = 300)),
                    exit = fadeOut(animationSpec = tween(durationMillis = 300))
                ) {
                    Row {
                        Box(
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp)
                                .clip(CircleShape)
                                .background(
                                    when (randomBall) {
                                        1 -> {
                                            percent = 0.4
                                            Red
                                        }
                                        2 -> {
                                            percent = 0.25
                                            Yellow
                                        }
                                        else -> White
                                    }
                                )
                                .border(1.dp, DarkGray, CircleShape)
                        )

                        Spacer(modifier = Modifier.padding(end = 5.dp))

                        Text(text = "${percent * 100}%", color = MaterialTheme.colors.secondary)
                    }
                }
            }
        }
    }

    Scaffold(
        topBar = { AppBar(title = "Actividad No. 9", navController = navController) }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CardTemplate(
                title = "Descuento Aleatorio",
                cardWidth = 300.dp,
                cardHeight = 330.dp,
                body = { CardBody() },
                visibility = visibility,
                enabled = enabled,
                onClick = {
                    result =
                        if (invoice != "") invoice.toDouble() - (invoice.toDouble() * percent)
                        else 0.0
                },
                result = "Total de la factora con el ${percent * 100}% de descuento = ${
                    String.format(
                        "%.2f",
                        result
                    )
                } COP",
                resultSize = 15.sp
            )
        }
    }
}
