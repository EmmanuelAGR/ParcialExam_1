package emmanuelagr.example.application.parcialexam_1.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import emmanuelagr.example.application.parcialexam_1.R

data class Activities(
    val title: String,
    val description: String,
    val img: Int,
    val imgDescription: String,
    val route: String
)

val activies = listOf(
    Activities(
        "Tiempo en llenarse una Jarra",
        "Calcular cuanto tiempo tarda en llenarse una jarra con una perdida del 5% cada 5 segundos.",
        R.drawable.derramando_agua_em_vidro,
        "Jug",
        "/activity_5"
    ),
    Activities(
        "Acierta el Número",
        "Entra ahora y desafiate a ti mismo en encontrar el número entre el 1 al 1000.",
        R.drawable.search_the_number,
        "Guess the number",
        "/activity_6"
    ),
    Activities(
        "Division usando Restas",
        "Según dos números enteros positivos, mostrar el residuo y el consiente usando restas.",
        R.drawable.fraction,
        "Division using subtraction",
        "/activity_7"
    ),
    Activities(
        "Invertir Número Entero",
        "Dale la vuelta al número que quieras.",
        R.drawable.invert_integer,
        "Invert integer",
        "/activity_8"
    ),
    Activities(
        "Descuento Aleatorio",
        "Solo por hoy, escoge aleatoreamente una bola de color con un descuento para toda tu factura.",
        R.drawable.discount,
        "Random discount",
        "/activity_10"
    )
)

@Composable
fun ActivitiesList(navController: NavController) {
    LazyColumn(content = {
        items(activies) { activity ->
            PillCard(
                title = activity.title,
                description = activity.description,
                img = activity.img,
                imgDescription = activity.imgDescription,
                onClick = { navController.navigate(route = activity.route) }
            )
        }
    })
}