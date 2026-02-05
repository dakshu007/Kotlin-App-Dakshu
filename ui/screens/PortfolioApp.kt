package com.dakshesh.portfolio.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PortfolioApp() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("projects") {
            ProjectsScreen(navController)
        }
        composable("skills") {
            SkillsScreen(navController)
        }
        composable("about") {
            AboutScreen(navController)
        }
        composable("contact") {
            ContactScreen(navController)
        }
    }
}