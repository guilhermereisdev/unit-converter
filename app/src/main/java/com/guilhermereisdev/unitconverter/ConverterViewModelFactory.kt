package com.guilhermereisdev.unitconverter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guilhermereisdev.unitconverter.data.ConverterRepository

class ConverterViewModelFactory(private val repository: ConverterRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) = ConverterViewModel(repository) as T
}
