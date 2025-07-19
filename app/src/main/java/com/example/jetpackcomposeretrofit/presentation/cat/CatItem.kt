package com.example.jetpackcomposeretrofit.presentation.cat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.jetpackcomposeretrofit.data.model.Cat


@Composable
fun CatItem(cat: Cat) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        cat.imageLink?.let {
            SubcomposeAsyncImage(
                model = it,
                contentDescription = "Image of ${cat.name ?: "a cat"}",
                loading = {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(10.dp)
                            .padding(10.dp)
                            .align(
                                Alignment.Center
                            )
                    )
                },
                error = {
                    Text("Image failed to load")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
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
        Spacer(modifier = Modifier.height(4.dp))
        cat.length?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
