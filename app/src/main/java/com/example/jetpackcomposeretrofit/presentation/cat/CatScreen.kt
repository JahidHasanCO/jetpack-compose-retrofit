package com.example.jetpackcomposeretrofit.presentation.cat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeretrofit.data.model.Cat
import com.example.jetpackcomposeretrofit.util.ApiState

@Composable
fun CatScreen(viewModel: CatViewModel) {
    var searchName by remember { mutableStateOf("") }
    val catListState by viewModel.catList

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        OutlinedTextField(
            value = searchName,
            onValueChange = { searchName = it },
            label = { Text("Search Cat Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { viewModel.fetchCatList(searchName) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (catListState) {
            is ApiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.padding(16.dp))
            }
            is ApiState.Success -> {
                CatList(cats = (catListState as ApiState.Success<List<Cat>>).data)
            }
            is ApiState.Error -> {
                Text(
                    text = (catListState as ApiState.Error).message,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}