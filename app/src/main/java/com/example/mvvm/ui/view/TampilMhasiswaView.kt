package com.example.mvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvm.model.Mahasiswa // Assuming `Mahasiswa` is a model class in your project

@Composable
fun TampilMahasiswaView(
    mhs: Mahasiswa
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {



        TampilData(
            judul = "Nama",
      isinya = mhs.nama

        )
        TampilData(
            judul = "Alamat",
            isinya = mhs.alamat
        )


        TampilData(
            judul = "Jenis Kelamin",
            isinya = mhs.gender
        )

    }
}

@Composable
fun TampilData(
    judul: String,
    isinya: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(judul, modifier = Modifier.weight(1f))
        Text(":", modifier = Modifier.weight(0.1f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}