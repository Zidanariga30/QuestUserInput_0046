package com.example.jmbud

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var datagender = listOf("Laki - Laki","Perempuan")

    var confName by remember { mutableStateOf("") }
    var confemail by remember { mutableStateOf("") }
    var confalamat by remember { mutableStateOf("") }
    var confnotelepon by remember { mutableStateOf("") }
    var confgender by remember { mutableStateOf("") }

    Column ( modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        TextField(
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text(text = "Isi Nama Anda")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Row (modifier = Modifier.fillMaxWidth()) {
            datagender.forEach{selectedGender ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = {gender = selectedGender})
                }
                Text (text = selectedGender) }
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Isi Email Anda")
            },
            modifier = Modifier.fillMaxWidth() ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "Alamat")
            },
            placeholder = {
                Text(text = "Isi Alamat Anda")
            },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = notelepon,
            onValueChange = {notelepon = it},
            label = {
                Text(text = "No Telepon")
            },
            placeholder = {
                Text(text = "Isi No Telpon Anda")
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = {
            confName= nama
            confemail = email
            confalamat= alamat
            confnotelepon = notelepon
            confgender = gender
        }) {
            Text(text = "Simpan")
        }
        TampilData(
            param = "Nama",
            argu = confName)
        TampilData(
            param = "Email",
            argu = confemail)
        TampilData(
            param = "Alamat",
            argu = confalamat)
        TampilData(
            param = "No Telepon",
            argu = confnotelepon)
        TampilData(
            param = "Gender",
            argu = confgender)
    }
}

@Composable
fun TampilData(
    param: String, argu:String
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = param,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = argu,
                modifier = Modifier.weight(2f)
            )
        }
    }
}