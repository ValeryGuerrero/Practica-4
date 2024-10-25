package com.example.navegacioncon3aplicaciones.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import com.example.examen1.ui.theme.Examen1Theme
import androidx.compose.material3.ExperimentalMaterial3Api
import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navegacioncon3aplicaciones.componentes.MainIconButton
import com.example.navegacioncon3aplicaciones.componentes.TitleBar


@Composable
fun Descuento(){
    var texto by remember { mutableStateOf("") }
    var descuento by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var precioDescontar by remember { mutableStateOf("") }
    var totales by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize()
        .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            OutlinedTextField(
                value = precio,
                onValueChange = {precio = it},
                label = { Text("Precio") }
            )
        }
        /*OutlinedTextField(
                value = texto,
        onValueChange = {texto = it},
        label = { Text("% Descuento") }
        )*/
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                value = precioDescontar,
                onValueChange = { precioDescontar = it },
                label = { Text("% Descuento") }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ElevatedButton(onClick = {descuento=descuentoCalcular(precio, precioDescontar).toString()
                totales = total(precio,descuento).toString()
            })

            {
                Text("Calcular")
            }
            Spacer(modifier = Modifier.padding(10.dp))
            ElevatedButton(onClick = { /*TODO*/precio = ""
                precioDescontar = ""
                descuento = ""
                totales = "" }) {

                Text("Limpiar")
            }
        }


        Spacer(modifier = Modifier.padding(10.dp))

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            OutlinedTextField(readOnly = true,
                value = descuento, onValueChange = { descuento = it },
                label = { Text("Descuento")}
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            OutlinedTextField(readOnly = true,
                //value = texto,
                value = totales,
                onValueChange = {totales = it },
                label = { Text("Total")}
            )
        }
    }
}

fun descuentoCalcular(texto1: String, texto2: String):Double{

    val precio = texto1.toDouble()
    val precioDescontar = texto2.toDouble()
    val descuento = (precioDescontar*precio)/100

    return descuento
}

fun total(texto1: String, texto2: String):Double{

    val precio = texto1.toDouble()
    val precioDescontar = texto2.toDouble()
    val total = precio - precioDescontar

    return total
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DescuentoMetodoView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Descuento") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(24, 199, 240,255)
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        Descuento()
    }
}

