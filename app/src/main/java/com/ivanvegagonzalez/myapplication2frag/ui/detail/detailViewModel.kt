package com.ivanvegagonzalez.myapplication2frag.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ivanvegagonzalez.myapplication2frag.model.Ciudad

class DetailViewModel(movie: Ciudad): ViewModel() {
    private val _ciudad = MutableLiveData(movie)
    val ciudad: LiveData<Ciudad> get() = _ciudad
}

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(private val ciudad: Ciudad): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(ciudad) as T
    }

}