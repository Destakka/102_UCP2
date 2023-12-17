package com.example.pam_ucp2.ui

import HalamanDua
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam_ucp2.data.Tumbuhan.sayur1

enum class PengelolaHalaman {
    Home,
    Formulir,
    Summary
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirApp(
    viewModel: FormViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    Scaffold { inner ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(inner)
        ) {
            composable(route = PengelolaHalaman.Home.name) {
                HalamanSatu(
                    onNextButtonClicked = {
                        navController.navigate(PengelolaHalaman.Formulir.name)
                    }
                )
            }
            composable(route = PengelolaHalaman.Formulir.name) {
                val context = LocalContext.current
                HalamanDua(
                    macamsayur = sayur1.map { id -> context.resources.getString(id) },
                    macambuah = sayur1.map { id -> context.resources.getString(id) },
                    onSelectionChanged1 = { viewModel.setSAYUR(it) },
                    onSelectionChanged2 = { viewModel.setBUAH(it) },
                    onSubmitClicked = {
                        viewModel.setData(it)
                        navController.navigate(PengelolaHalaman.Summary.name)
                    },
                )
            }
            composable(route = PengelolaHalaman.Summary.name) {
                HalamanTiga(
                    FormUIState = uiState,
                    onCancelButtonClicked = {
                        navController.popBackStack(
                            PengelolaHalaman.Formulir.name,
                            inclusive = false
                        )
                    }
                )

            }
        }
    }
}