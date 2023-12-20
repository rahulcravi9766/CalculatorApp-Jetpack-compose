package com.example.simplecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simplecalculator.ui.theme.DarkGrey
import com.example.simplecalculator.ui.theme.SimpleCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                CalculatorMainScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = DarkGrey)
                        , state = state, viewModel = viewModel
                )
            }
        }
    }
}


@Composable
fun CalculatorButtons(
    symbol: String,
    color: Color,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(50.dp)
            .clip(
                CircleShape
            )
            .background(color)
            .clickable {
                onClick()
            }
            .then(modifier)
    ) {
        Text(text = symbol, fontSize = 30.sp, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorButtonsPreview() {
    SimpleCalculatorTheme {
       // CalculatorButtons("1", modifier = Modifier)
    }
}