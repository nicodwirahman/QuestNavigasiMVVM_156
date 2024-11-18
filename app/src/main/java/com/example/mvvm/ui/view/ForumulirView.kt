package com.example.mvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormulirView(
    modifier: Modifier = Modifier,
    pilihanJk: List<String>,
    onClickButton: (MutableList<String>) -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(nama, jenisK, alamat)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama Anda") },
            placeholder = { Text("Masukkan Nama Anda") }
        )



        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat Anda") },
            placeholder = { Text("Masukkan Alamat Anda") }
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "Jenis Kelamin",
            fontWeight = FontWeight.Bold
        )

        // Gender Selection Radio Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            pilihanJk.forEach { selectedJK ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    RadioButton(
                        selected = (jenisK == selectedJK),
                        onClick = { jenisK = selectedJK }
                    )
                    Text(text = selectedJK)
                }
            }
        }

        Button(
            onClick = {
                listData[0] = nama
                listData[1] = alamat
                listData[2] = jenisK
                onClickButton(listData)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Submit")
        }
    }
}