package com.ivanvegagonzalez.myapplication2frag.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ivanvegagonzalez.myapplication2frag.R
import com.ivanvegagonzalez.myapplication2frag.databinding.FragmentDetailBinding
import com.ivanvegagonzalez.myapplication2frag.loadUrl
import com.ivanvegagonzalez.myapplication2frag.model.Ciudad

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private  val viewModel: DetailViewModel by viewModels {
        DetailViewModelFactory(arguments?.getParcelable<Ciudad>(EXTRA_Ciudad)!!)
    }
    companion object{
        const val EXTRA_Ciudad = "DetailActivity:Ciudad"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)


        viewModel.ciudad.observe(viewLifecycleOwner){ ciudad ->
            (requireActivity() as AppCompatActivity).supportActionBar?.title = ciudad.title
            binding.imagen.loadUrl(ciudad.urlImagen)
        }
    }
}