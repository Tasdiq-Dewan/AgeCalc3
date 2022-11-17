package com.tasdiq.agecalc3.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tasdiq.agecalc3.R
import com.tasdiq.agecalc3.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val showAgeDescription = binding.showAgeDescription
        val ageTextInput = binding.ageTextInput
        val calcAgeButton = binding.calcAgeButton
        showAgeDescription.text = viewModel.getAgeResult()
        calcAgeButton.setOnClickListener {
            val ageText = ageTextInput.text.toString()
            val age = ageText.toIntOrNull()
            viewModel.setAgeResult(age)
            showAgeDescription.text = viewModel.getAgeResult()
        }
    }
}