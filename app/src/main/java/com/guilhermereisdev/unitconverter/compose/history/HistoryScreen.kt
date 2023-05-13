package com.guilhermereisdev.unitconverter.compose.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.guilhermereisdev.unitconverter.data.ConversionResult

@Composable
fun HistoryScreen(
    list: State<List<ConversionResult>>,
    modifier: Modifier = Modifier,
) {
    HistoryList(list = list, onCloseTask = {})
}
