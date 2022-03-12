package emmanuelagr.example.application.parcialexam_1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PillCard(
    title: String,
    description: String,
    img: Int,
    imgDescription: String,
    onClick: () -> Unit
) {
    val isLight = MaterialTheme.colors.isLight
    Card(
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp),
        backgroundColor = MaterialTheme.colors.onBackground,
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(158.dp)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = imgDescription,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .width(150.dp)
                    .clip(CutCornerShape(bottomEndPercent = 100))
                    .alpha(if (isLight) 0.85f else 1f)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            ) {
                Text(
                    text = title,
                    color = MaterialTheme.colors.secondary,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = description,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}