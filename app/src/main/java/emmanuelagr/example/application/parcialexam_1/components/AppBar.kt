package emmanuelagr.example.application.parcialexam_1.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AppBar(
    title: String,
    navController: NavController? = null
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.onBackground,
        elevation = 10.dp,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = if (navController != null) Arrangement.Start else Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (navController != null) {
                    Surface(
                        elevation = 3.dp,
                        shape = CircleShape,
                        color = MaterialTheme.colors.onBackground,
                        content = {
                            IconButton(onClick = { navController.popBackStack() }, content = {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back",
                                    tint = MaterialTheme.colors.secondary
                                )
                            })
                        }
                    )
                    Spacer(modifier = Modifier.fillMaxWidth(0.21f))
                }

                Text(
                    text = title,
                    fontSize = 20.sp,
                    color = MaterialTheme.colors.secondary,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    )
}