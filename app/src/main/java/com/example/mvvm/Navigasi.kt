package com.example.mvvm

import androidx.compose.foundation.layout.padding
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
import com.example.mvvm.model.DataJK
import com.example.mvvm.model.Mahasiswa
import com.example.mvvm.ui.view.FormulirView
import com.example.mvvm.ui.view.TampilMahasiswaView
import com.example.mvvm.ui.viewmodel.MahasiswaViewModel

enum class Halaman {
    Form,
    Data
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
) {
    Scaffold { paddingValues ->

        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            modifier = modifier.padding(paddingValues),
            navController = navHost,
            startDestination = Halaman.Form.name
        ) {

            composable(route = Halaman.Form.name) {
                val context = LocalContext.current

                FormulirView(
                    pilihanJk = DataJK.isiJK.map { id ->
                        context.resources.getString(id)
                    },
                    onClickButton = { mahasiswaData ->
                        viewModel.saveDataMahasiswa(mahasiswaData)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }


            composable(route = Halaman.Data.name) {
                TampilMahasiswaView(
                    mhs = uiState
                )
            }
        }
    }
}