package com.ivanvegagonzalez.myapplication2frag.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivanvegagonzalez.myapplication2frag.R
import com.ivanvegagonzalez.myapplication2frag.databinding.ViewCiudadBinding
import com.ivanvegagonzalez.myapplication2frag.inflate
import com.ivanvegagonzalez.myapplication2frag.loadUrl
import com.ivanvegagonzalez.myapplication2frag.model.Ciudad


class CiudadesAdapter(val listener: (Ciudad) -> Unit):
    RecyclerView.Adapter<CiudadesAdapter.ViewHolder>() {

    var ciudades = emptyList<Ciudad>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_ciudad, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ciudad = ciudades[position]
        holder.bind(ciudad)

        holder.itemView.setOnClickListener {
            listener(ciudad)
        }
    }

    override fun getItemCount(): Int = ciudades.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ViewCiudadBinding.bind(view)
        fun bind(ciudad: Ciudad){
            binding.title.text = ciudad.title

            binding.imagen.loadUrl(ciudad.urlImagen)
        }
    }
}

