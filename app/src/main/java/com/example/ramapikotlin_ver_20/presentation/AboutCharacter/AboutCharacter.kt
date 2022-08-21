package com.example.ramapikotlin_ver_20.presentation.AboutCharacter


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.ramapikotlin_ver_20.MainActivity
import com.example.ramapikotlin_ver_20.R
import com.example.ramapikotlin_ver_20.databinding.FragmentAboutCharacterBinding
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutCharacter : Fragment() {
    private val viewModel: AboutCharacterViewModel by viewModels()
    private var _binding: FragmentAboutCharacterBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutCharacterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onStart() {
        super.onStart()
        viewModel.getCharacterById(arguments?.get(getString(R.string.bundle_key_1)) as Int)
        binding.indeterminateBar.visibility = View.VISIBLE
        binding.backButton.setOnClickListener{
            (activity as MainActivity).onBackPressed()
        }
        viewModel.viewModelLiveDataEpisodesIds.observe(this, Observer {item->
            binding.episodesButton.setOnClickListener{
                (activity as MainActivity).navController.navigate(R.id.action_aboutCharacter_to_listOfEpisodes, item)
            }

        })
        viewModel.viewModelLiveData.observe(this, Observer {
            binding.indeterminateBar.visibility = View.INVISIBLE
            if(it != null){
            binding.name.text = it.name
            binding.status.text = it.status
            binding.species.text = it.species
            binding.location.text = it.location.name
            Picasso.get().load(it.image).into(binding.image)
            }else{
                    Snackbar.make(binding.root, R.string.error, Snackbar.LENGTH_INDEFINITE)
                        .setAction(R.string.again) {
                            viewModel.getCharacterById(arguments?.get("id") as Int)
                            binding.indeterminateBar.visibility = View.VISIBLE
                        }
                        .show()

            }


        })

    }



}