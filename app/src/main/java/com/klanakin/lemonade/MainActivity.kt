package com.klanakin.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.klanakin.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}


@Composable
fun LemonApp() {

    // Current step the app is displaying (remember allows the state to be retained
    // across recompositions).
    var currentStep by remember { mutableStateOf(1) }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        color = MaterialTheme.colorScheme.background ) {

        when (currentStep) {
            1 -> {
                LemonTextAndImage(
                    textId = R.string.lemon_tree,
                    imageId = R.drawable.lemon_tree,
                    contentDescriptionId = R.string.content_description_lemon_tree,
                    onImageClick = {
                        // Back to starting step
                        currentStep = 2
                    }
                )
            }

            2 -> {
                LemonTextAndImage(
                    textId = R.string.lemon_squeeze,
                    imageId = R.drawable.lemon_squeeze,
                    contentDescriptionId = R.string.content_description_lemon_squeeze,
                    onImageClick = {
                        // Back to starting step
                        currentStep = 3
                    }
                )
            }

            3 -> {
                LemonTextAndImage(
                    textId = R.string.lemonade_drink,
                    imageId = R.drawable.lemonade_drink,
                    contentDescriptionId = R.string.content_description_lemonade_drink,
                    onImageClick = {
                        // Back to starting step
                        currentStep = 4
                    }
                )
            }

            4 -> {
                LemonTextAndImage(
                    textId = R.string.empty_glass,
                    imageId = R.drawable.empty_glass,
                    contentDescriptionId = R.string.content_description_empty_glass,
                    onImageClick = {
                        // Back to starting step
                        currentStep = 1
                    }
                )
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    textId: Int,
    imageId: Int,
    contentDescriptionId: Int,
    onImageClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = textId))
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = imageId),
            contentDescription = stringResource(id = contentDescriptionId),
            modifier = Modifier
                .wrapContentSize()
                .clickable(
                    onClick = onImageClick
                )
                .border(
                    BorderStroke(Dp.Hairline, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
        )
    }
}







