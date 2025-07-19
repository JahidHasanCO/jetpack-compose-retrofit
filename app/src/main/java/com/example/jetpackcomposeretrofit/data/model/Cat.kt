package com.example.jetpackcomposeretrofit.data.model


import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("children_friendly")
    val childrenFriendly: Int?,
    @SerializedName("family_friendly")
    val familyFriendly: Int?,
    @SerializedName("general_health")
    val generalHealth: Int?,
    @SerializedName("grooming")
    val grooming: Int?,
    @SerializedName("image_link")
    val imageLink: String?,
    @SerializedName("intelligence")
    val intelligence: Int?,
    @SerializedName("length")
    val length: String?,
    @SerializedName("max_life_expectancy")
    val maxLifeExpectancy: Int?,
    @SerializedName("max_weight")
    val maxWeight: Int?,
    @SerializedName("min_life_expectancy")
    val minLifeExpectancy: Int?,
    @SerializedName("min_weight")
    val minWeight: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin")
    val origin: String?,
    @SerializedName("other_pets_friendly")
    val otherPetsFriendly: Int?,
    @SerializedName("playfulness")
    val playfulness: Int?,
    @SerializedName("shedding")
    val shedding: Int?
)