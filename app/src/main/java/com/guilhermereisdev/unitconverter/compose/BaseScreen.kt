package com.guilhermereisdev.unitconverter.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guilhermereisdev.unitconverter.ConverterViewModel
import com.guilhermereisdev.unitconverter.ConverterViewModelFactory
import com.guilhermereisdev.unitconverter.compose.converter.TopScreen
import com.guilhermereisdev.unitconverter.compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
) {
    val list = converterViewModel.getConversions()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())
    Column(modifier = modifier.padding(16.dp)) {
        TopScreen(list) { message1, message2 ->
            converterViewModel.addResult(message1, message2)
        }
        Spacer(modifier = modifier.height(24.dp))
        HistoryScreen(historyList)
    }
}
