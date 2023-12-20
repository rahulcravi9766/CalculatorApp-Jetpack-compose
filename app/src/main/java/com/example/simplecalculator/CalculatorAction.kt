package com.example.simplecalculator

sealed class CalculatorAction{
    data class Number(val number: Int): CalculatorAction()
    object Clear: CalculatorAction()
    object Decimal: CalculatorAction()
    object Brackets: CalculatorAction()
    object Calculate: CalculatorAction()
    data class Percentage(val number: Int): CalculatorAction()
    object Delete: CalculatorAction()
    data class Operations(val operations: CalculatorOperations): CalculatorAction()
}



