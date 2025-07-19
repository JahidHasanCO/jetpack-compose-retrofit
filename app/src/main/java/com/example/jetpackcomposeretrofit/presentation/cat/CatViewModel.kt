package com.example.jetpackcomposeretrofit.presentation.cat

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeretrofit.data.model.Cat
import com.example.jetpackcomposeretrofit.domain.repo.CatRepository
import com.example.jetpackcomposeretrofit.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    private val catRepository: CatRepository
) : ViewModel() {

    private val _catList = mutableStateOf<ApiState<List<Cat>>>(ApiState.Loading)
    val catList: State<ApiState<List<Cat>>> = _catList

    fun fetchCatList(name : String) {
        viewModelScope.launch {
            try {
                val response = catRepository.getCatList(name)
                _catList.value = ApiState.Success(response)
            } catch (e: Exception) {
                _catList.value = ApiState.Error("Failed to fetch data")
            }
        }
    }
}