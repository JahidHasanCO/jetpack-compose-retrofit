package com.example.jetpackcomposeretrofit.data.repo


import com.example.jetpackcomposeretrofit.data.remote.api.ApiService
import com.example.jetpackcomposeretrofit.domain.repo.CatRepository
import com.example.jetpackcomposeretrofit.data.model.Cat
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CatRepository {

    override suspend fun getCatList(name: String): List<Cat> {
        val dataCats: List<Cat> = apiService.getCatList(name)
        return dataCats;
    }
}
