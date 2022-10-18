package com.ivanvegagonzalez.myapplication2frag.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivanvegagonzalez.myapplication2frag.model.Ciudad
import com.ivanvegagonzalez.myapplication2frag.model.CiudadesProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(): ViewModel() {
    private val _state = MutableLiveData(UiState())
    val state: LiveData<UiState> get() = _state

    init {
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = _state.value?.copy(loading = true)
            val ciudades =  withContext(Dispatchers.IO){ CiudadesProvider.getCiudades()}
            _state.value = _state.value?.copy(loading = false, ciudades = ciudades)
        }
    }

    fun navigateTo(ciudad: Ciudad) {
        _state.value = _state.value?.copy(navigateTo = ciudad)
    }

    fun onNavigateDone(){
        _state.value = _state.value?.copy(navigateTo = null)
    }

    data class UiState(
        val loading: Boolean = false,
        val ciudades: List<Ciudad>? = null,
        val navigateTo: Ciudad? = null
    )

}