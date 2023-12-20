package com.example.simplecalculator

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {

        Log.d("action","is $action")
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operations -> enterOperation(action.operations)
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Brackets -> {

            }

            is CalculatorAction.Percentage -> calculatePercentage(action.number)
        }
    }

    private fun calculatePercentage(number: Int) {
//        state = (state.number1.toInt() * 100).toString()
    }

    private fun performCalculation() {

        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if (number1 != null && state.operator != null && number2 != null) {
            val result = when (state.operator) {
                is CalculatorOperations.Add -> number1 + number2
                is CalculatorOperations.Minus -> number1 - number2
                is CalculatorOperations.Divide -> number1 / number2
                is CalculatorOperations.Multiply -> number1 * number2
                null -> return
            }

            state = state.copy(number1 = result.toString(), number2 = "", operator = null)

        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(number2 = state.number2.dropLast(1))
            state.operator != null -> state = state.copy(operator = null)
            state.number1.isNotBlank() -> state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun enterOperation(operations: CalculatorOperations) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operator = operations)
        }
    }

    private fun enterDecimal() {
        if (state.operator == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1.plus("."))
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2.plus("."))
            return
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operator == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(number1 = state.number1 + number)
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(number2 = state.number2 + number)
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}

