package com.rewalty.daggermvvm1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rewalty.daggermvvm1.repository.Repository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val respository: Repository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(respository) as T
    }

}