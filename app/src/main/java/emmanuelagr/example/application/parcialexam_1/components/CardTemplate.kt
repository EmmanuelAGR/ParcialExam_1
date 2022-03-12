package emmanuelagr.example.application.parcialexam_1.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CardTemplate(
    title: String,
    cardWidth: Dp,
    cardHeight: Dp,
    body: @Composable () -> Unit,
    visibility: MutableState<Boolean>,
    enabled: Boolean = true,
    onClick: () -> Unit,
    result: String,
    resultSize: TextUnit = 17.sp
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.onBackground,
        modifier = Modifier
            .width(cardWidth)
            .height(cardHeight)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.secondary,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )

            Divider(modifier = Modifier.padding(top = 5.dp, bottom = 20.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {

                body()

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = {
                        onClick()
                        visibility.value = true
                    },
                    enabled = enabled
                ) {
                    Text(text = "Calcular", color = MaterialTheme.colors.secondaryVariant)
                }

                Spacer(modifier = Modifier.height(20.dp))

                AnimatedVisibility(visible = visibility.value) {
                    Text(
                        text = result,
                        fontSize = resultSize,
                        fontWeight = FontWeight.Medium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colors.secondary,
                    )
                }
            }
        }
    }
}