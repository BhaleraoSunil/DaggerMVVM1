package com.rewalty.daggermvvm1.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rewalty.daggermvvm1.models.Products
import com.rewalty.daggermvvm1.retrofit.FakerAPI
import javax.inject.Inject

class Repository @Inject constructor(private val fakerAPI: FakerAPI) {

    private val productMutableData = MutableLiveData<List<Products>>()

    val productsLiveData: LiveData<List<Products>>
        get() = productMutableData


    suspend fun getProducts() {
        val results = fakerAPI.getProduces()

        if (results.isSuccessful && results.body() != null) {
            productMutableData.postValue(results.body())
        }
    }
}