package com.example.jetpackcomposeretrofit.presentation.cat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeretrofit.data.model.Cat

@Composable
fun CatItem(cat: Cat) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        cat.name?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        cat.origin?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}