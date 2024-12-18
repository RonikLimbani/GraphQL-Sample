package com.ronik.graphqlsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ronik.graphqlsample.presentation.CountriesScreen
import com.ronik.graphqlsample.presentation.CountriesViewModel
import com.ronik.graphqlsample.ui.theme.GraphQLSampleTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GraphQLSampleTheme {
               val viewModel = hiltViewModel<CountriesViewModel>()
                val state by viewModel.state.collectAsState()
                CountriesScreen(
                    state = state,
                    onSelectCountry = {viewModel.selectCountry(it)} ,
                    onDismissCountryDialog = viewModel::dismissCountryDialog
                )
            }
        }
    }
}

