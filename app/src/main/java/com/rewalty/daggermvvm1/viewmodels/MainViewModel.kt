package com.rewalty.daggermvvm1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rewalty.daggermvvm1.models.Products
import com.rewalty.daggermvvm1.repository.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(private val respository: Repository) : ViewModel() {

    val productsLiveData: LiveData<List<Products>>
        get() = respository.productsLiveData

    init {
        viewModelScope.launch {
            respository.getProducts()
        }
    }
}