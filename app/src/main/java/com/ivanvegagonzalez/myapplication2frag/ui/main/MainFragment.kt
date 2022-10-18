package com.ivanvegagonzalez.myapplication2frag.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ivanvegagonzalez.myapplication2frag.R
import com.ivanvegagonzalez.myapplication2frag.databinding.FragmentMainBinding
import com.ivanvegagonzalez.myapplication2frag.ui.detail.DetailFragment

class MainFragment : Fragment(R.layout.fragment_main) {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding
    private val adapter = CiudadesAdapter(){ ciudad -> viewModel.navigateTo(ciudad)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = adapter
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        viewModel.state.observe(viewLifecycleOwner){state ->
            binding.progress.visibility =  if (state.loading) View.VISIBLE else View.GONE
            state.ciudades?.let {
                adapter.ciudades = state.ciudades
                adapter.notifyDataSetChanged()
            }

            state.navigateTo?.let {
                findNavController().navigate(
                    R.id.action_mainFragment_to_detailFragment,
                    bundleOf(DetailFragment.EXTRA_Ciudad to it)
                )
                viewModel.onNavigateDone()
            }




        }

    }

}
