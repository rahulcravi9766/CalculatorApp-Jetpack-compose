package com.example.simplecalculator

sealed class CalculatorOperations(val symbol: String) {
    object Add: CalculatorOperations("+")
    object Minus: CalculatorOperations("-")
    object Divide: CalculatorOperations("/")
    object Multiply: CalculatorOperations("x")
}