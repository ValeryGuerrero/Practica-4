package com.example.navegacioncon3aplicaciones.navegacion


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.loto.views.LoteriaMetodoView
import com.example.navegacioncon3aplicaciones.view.DescuentoMetodoView
import com.example.navegacioncon3aplicaciones.view.DogYearMetodoView
import com.example.navegacioncon3aplicaciones.view.HomeView



@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"  ){
        composable("Home"){
            HomeView(navController)
        }
        composable("Descuento"){
            DescuentoMetodoView(navController)
        }
        composable("Años Perrunos"){
            DogYearMetodoView(navController)
        }
        composable("Loteria"){
            LoteriaMetodoView(navController)
        }
    }
}