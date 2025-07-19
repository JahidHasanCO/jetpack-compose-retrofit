package com.example.jetpackcomposeretrofit.domain.repo

import com.example.jetpackcomposeretrofit.data.model.Cat

interface CatRepository {
    suspend fun getCatList(name: String): List<Cat>
}