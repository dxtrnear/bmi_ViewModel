package com.example.bmi_mvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    var heightInput: String by mutableStateOf(value = "")
    var weightInput: String by mutableStateOf(value = "")
    fun modify_HeightInput(newInput: String) {
        heightInput = newInput.replace(oldChar = ',', newChar = '.')
    }
    fun modify_WeightInput(newInput: String) {
        weightInput = newInput.replace(oldChar = ',', newChar = '.')
    }
    var heightValue: Float = 0.0f
        get() {
            return heightInput.toFloatOrNull() ?: 0.0f
        }
    var weightValue: Int = 0
        get() {
            return weightInput.toIntOrNull() ?: 0
        }
    var bmi: Float = 0.0f
        get() {
            return calculateResult()
        }
    private fun calculateResult(): Float {
        return if (heightValue > 0 && weightValue > 0) weightValue / (heightValue * heightValue) else 0.0f
    }
}