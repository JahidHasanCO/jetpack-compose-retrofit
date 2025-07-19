package com.example.jetpackcomposeretrofit.presentation.cat

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import com.example.jetpackcomposeretrofit.data.model.Cat

@Composable
fun CatList(cats: List<Cat>) {
    LazyColumn {
        items(cats) { cat ->
            CatItem(cat)
            HorizontalDivider()
        }
    }
}