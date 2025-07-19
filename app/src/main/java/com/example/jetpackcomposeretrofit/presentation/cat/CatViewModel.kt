package com.example.jetpackcomposeretrofit.presentation.cat

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeretrofit.data.model.Cat
import com.example.jetpackcomposeretrofit.domain.repo.CatRepository
import com.example.jetpackcomposeretrofit.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    private val catRepository: CatRepository
) : ViewModel() {

    val _tag = "CatViewModel"
    private val _catList = mutableStateOf<ApiState<List<Cat>>>(ApiState.Loading)
    val catList: State<ApiState<List<Cat>>> = _catList

    fun fetchCatList(name: String) {
        _catList.value = ApiState.Loading
        viewModelScope.launch {
            try {
                val response = catRepository.getCatList(name)
                _catList.value = ApiState.Success(response)
            } catch (e: HttpException) {
                // e.code() will be 400
                val errorBody = e.response()?.errorBody()?.string()
                Log.e(
                    "CatViewModel",
                    "HTTP Error: ${e.code()}, Body: $errorBody"
                )
                // Parse errorBody if it's JSON and display a user-friendly message
                _catList.value = errorBody?.let { ApiState.Error(it) }
                    ?: ApiState.Error("HTTP Error: ${e.code()}")
            } catch (e: Exception) {
                Log.e(_tag, "Error fetching cat list", e)
                _catList.value = ApiState.Error("Failed to fetch data")
            }
        }
    }
}