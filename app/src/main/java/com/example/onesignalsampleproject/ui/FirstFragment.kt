package com.example.onesignalsampleproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.onesignalsampleproject.viewmodel.ExampleViewModel
import com.example.onesignalsampleproject.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

const val EXAMPLE_COROUTINE_WORKER_TAG = "example_coroutine_worker_tag"

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private val exampleViewModel: ExampleViewModel by viewModels()

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            exampleViewModel.startWork()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}