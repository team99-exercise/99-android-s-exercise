package com.team99.exerciserhony

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.team99.exerciserhony.ui.screen.navigation.MainNavigation
import com.team99.exerciserhony.ui.theme.Team99AndroidExerciseRhonyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Team99AndroidExerciseRhonyTheme {
                MainNavigation(navController = rememberNavController())
            }
        }
    }
}
