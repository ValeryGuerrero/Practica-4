package com.example.navegacioncon3aplicaciones.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
//import androidx.navigation.NavController
import com.example.navegacioncon3aplicaciones.componentes.ActionButton
import com.example.navegacioncon3aplicaciones.componentes.MainButton
import com.example.navegacioncon3aplicaciones.componentes.Space
import com.example.navegacioncon3aplicaciones.componentes.TitleBar
import com.example.navegacioncon3aplicaciones.componentes.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(24, 199, 240)
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ) {
        ContentHomeView(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(navController: NavController) {
    val id = 123
    var opcional by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Navegacion 3 apps")
        Space()
        /*TextField(
            value = opcional,
            onValueChange = { opcional = it },
            label = { Text(text = "Opcional") }
        )*/
        MainButton(name = "Loteria", backColor = Color(24, 199, 240), color = Color.White) {
            navController.navigate("Loteria")
        }
        MainButton(name = "Años Perrunos", backColor = Color(24, 199, 240), color = Color.White) {
            navController.navigate("Años Perrunos")
        }
        MainButton(name = "Descuento", backColor = Color(24, 199, 240), color = Color.White) {
            navController.navigate("Descuento")
        }
    }
}