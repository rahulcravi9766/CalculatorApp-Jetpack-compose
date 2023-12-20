package com.example.simplecalculator

import android.R
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecalculator.ui.theme.Background
import com.example.simplecalculator.ui.theme.ClearAll
import com.example.simplecalculator.ui.theme.DarkGrey
import com.example.simplecalculator.ui.theme.EqualButton
import com.example.simplecalculator.ui.theme.NumberButtons
import com.example.simplecalculator.ui.theme.OperationsButton

@Composable
fun CalculatorMainScreen(
    modifier: Modifier = Modifier,
    state: CalculatorState,
    viewModel: CalculatorViewModel,
    buttonSpacing: Dp = 8.dp,
) {

    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(
                        RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
                    )
                    .background(color = Background)
                    .padding(horizontal = 10.dp), verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = state.number1 +( state.operator?.symbol ?: "")  + state.number2,
                    fontSize = 70.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 15.dp),
                    maxLines = 2,
                    letterSpacing = 1.sp,
                    lineHeight = 60.sp,
                    color = Color.White
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f)
                    .background(color = DarkGrey)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CalculatorButtons(
                        symbol = "AC",
                        color = ClearAll,
                        modifier = Modifier
                            .aspectRatio(2f)
                            .weight(2f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Clear)
                        }
                    )
                    CalculatorButtons(
                        symbol = "Del",
                        color = OperationsButton,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Delete)
                        }
                    )

                    CalculatorButtons(
                        symbol = "/",
                        color = OperationsButton,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operations(CalculatorOperations.Divide))
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CalculatorButtons(
                        symbol = "7",
                        color = NumberButtons,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            Log.d("onButtonClick", " clicked ")
                            viewModel.onAction(CalculatorAction.Number(7))
                        }
                    )

                    CalculatorButtons(
                        symbol = "8",
                        color = NumberButtons,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(8))
                        }
                    )

                    CalculatorButtons(
                        symbol = "9",
                        color = NumberButtons,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(9))
                        }
                    )

                    CalculatorButtons(
                        symbol = "x",
                        color = OperationsButton,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            Log.d("operator", "is ${CalculatorOperations.Multiply}")
                            viewModel.onAction(CalculatorAction.Operations(CalculatorOperations.Multiply))
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CalculatorButtons(
                        symbol = "4",
                        color = NumberButtons,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(4))
                        }
                    )

                    CalculatorButtons(
                        symbol = "5",
                        color = NumberButtons,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(5))
                        }
                    )

                    CalculatorButtons(
                        symbol = "6",
                        color = NumberButtons,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(6))
                        }
                    )

                    CalculatorButtons(
                        symbol = "-",
                        color = OperationsButton,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operations(CalculatorOperations.Minus))
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CalculatorButtons(
                        symbol = "1",
                        color = NumberButtons,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(1))
                        }
                    )

                    CalculatorButtons(
                        symbol = "2",
                        color = NumberButtons,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(2))
                        }
                    )

                    CalculatorButtons(
                        symbol = "3",
                        color = NumberButtons,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(3))
                        }
                    )

                    CalculatorButtons(
                        symbol = "+",
                        color = OperationsButton,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Operations(CalculatorOperations.Add))
                        }
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                    verticalAlignment = Alignment.CenterVertically

                    ) {
                    CalculatorButtons(
                        symbol = "0",
                        color = NumberButtons,
                        modifier = Modifier
                            .aspectRatio(2f)
                            .weight(2f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Number(0))
                        }
                    )
                    CalculatorButtons(
                        symbol = ".",
                        color = NumberButtons,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Decimal)
                        }
                    )

                    CalculatorButtons(
                        symbol = "=",
                        color = EqualButton,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            viewModel.onAction(CalculatorAction.Calculate)
                        }
                    )
                }
            }
        }
    }
}