package com.guilhermereisdev.unitconverter.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.guilhermereisdev.unitconverter.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(list: List<Conversion>) {
    val selectedConversion: MutableState<Conversion?> = remember { mutableStateOf(null) }
    val inputText: MutableState<String> = remember { mutableStateOf("") }
    val typedValue: MutableState<String> = remember { mutableStateOf("0.0") }

    ConversionMenu(list = list) {
        selectedConversion.value = it
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText) { input ->
            typedValue.value = input
        }
    }

    if (typedValue.value != "0.0") {
        val input = typedValue.value.toDouble()
        selectedConversion.value?.let {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.HALF_UP
            val roundedResult = df.format(input * it.multiplyBy)
            val message1 = "${typedValue.value} ${it.convertFrom} is equal to"
            val message2 = "$roundedResult ${it.convertTo}"
            ResultBlock(message1 = message1, message2 = message2)
        }
    }
}
