package com.example.jetpackcomposeretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import com.example.jetpackcomposeretrofit.presentation.cat.CatScreen
import com.example.jetpackcomposeretrofit.presentation.cat.CatViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val catViewModel : CatViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CatScreen(catViewModel)
            }
        }
    }
}
