package com.guilhermereisdev.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.guilhermereisdev.unitconverter.compose.BaseScreen
import com.guilhermereisdev.unitconverter.data.ConverterDatabase
import com.guilhermereisdev.unitconverter.data.ConverterRepositoryImpl
import com.guilhermereisdev.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = ConverterDatabase.getInstance(application).converterDAO
        val repository = ConverterRepositoryImpl(dao)
        val factory = ConverterViewModelFactory(repository)

        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BaseScreen(factory = factory)
                }
            }
        }
    }
}
