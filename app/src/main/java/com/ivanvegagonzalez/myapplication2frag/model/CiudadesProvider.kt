package com.ivanvegagonzalez.myapplication2frag.model

object CiudadesProvider {
    fun getMovies(tipo: String = "City"): List<Ciudad> {
        Thread.sleep(2000)
        return (1..100).map {Ciudad("Ciudad $it","https://loremflickr.com/240/320/$tipo?lock=$it") }
    }
}