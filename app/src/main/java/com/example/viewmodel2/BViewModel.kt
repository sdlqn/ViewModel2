package com.example.viewmodel2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class BViewModel {
    var heightInput: String by  mutableStateOf("")
        private set
    var weightInput: String by  mutableStateOf("")
        private set
    var bmi: Float by mutableFloatStateOf(0.0f)


    fun updateHeight(input: String) {
        heightInput = input
        calculateBMI()
    }

    fun updateWeight(input: String) {
        weightInput = input
        calculateBMI()
    }

    private fun calculateBMI() {
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toFloatOrNull() ?: 0.0f
        bmi = if (height > 0 && weight > 0) weight / (height * height) else 0.0f
    }
}