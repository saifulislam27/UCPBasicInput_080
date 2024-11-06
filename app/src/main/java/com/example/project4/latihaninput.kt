package com.example.project4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun latihanInput(modifier: Modifier = Modifier){

    var nama by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var memilihJK by remember { mutableStateOf("") }

    val listJK = listOf("Laki-Laki", "Perempuan")

    var Namakaiden by remember { mutableStateOf("") }
    var Noteleponkaiden by remember { mutableStateOf("") }
    var memilihJKme by remember { mutableStateOf("") }


    Column(modifier = modifier.fillMaxSize().padding(1.dp),
        horizontalAlignment = Alignment.CenterHorizontally)

    {
        HeaderSection()

        Text(text = "Yuk Lengkapi Data Dirimu !", fontSize = 16.sp, fontWeight = FontWeight.Bold,)
        Spacer(Modifier.padding(10.dp))

        TextField(
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text(text = "isi nama anda") //Hint text
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Face,
                    contentDescription = null) },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        TextField(
            value = notelepon,
            onValueChange = {notelepon = it},
            label = {
                Text(text = "No Telepon")
            },
            placeholder = {
                Text(text = "isi No telepon anda")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Call,
                    contentDescription = null) },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Row (modifier = Modifier.fillMaxWidth()){
            listJK.forEach{selectedGender ->
                Row (
                    verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = memilihJK == selectedGender,
                        onClick = { memilihJK = selectedGender
                        }
                    )
                    Text(text = selectedGender)

                }}
        }

        Button(onClick = {
            Namakaiden = nama
            Noteleponkaiden = notelepon
            memilihJKme = memilihJK
        }) {
            Text(text = "Submit")
        }
        ElevatedCard (
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ){
        DetailMessagge(param = "nama",  argum = Namakaiden)
        DetailMessagge(param = "no telepon",  argum = Noteleponkaiden)
        DetailMessagge(param = "memilihJK",  argum = memilihJKme)}
    }
}



    @Composable
fun DetailMessagge(
    param: String, argum: String
){
    Column(
        modifier = Modifier.padding(16.dp))
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            Text(text = param,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = argum,
                modifier = Modifier.weight(2f))

        }
    }
}
@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.DarkGray)
            .padding(20.dp)
    ) {
        Row {
            Column {
                Text(
                    text = "Hai",
                    color = Color.White
                )
                Text(
                    text = "Saiful Islam",
                    color = Color.White
                )
            }
            Box(
                contentAlignment = Alignment.BottomStart
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "Max",
                    modifier = Modifier.size(100.dp)
                        .clip(CircleShape)
                )
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        }
    }
}
