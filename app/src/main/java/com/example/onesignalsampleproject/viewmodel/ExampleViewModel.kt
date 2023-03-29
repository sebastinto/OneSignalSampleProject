package com.example.onesignalsampleproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onesignalsampleproject.repository.ExampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val exampleRepository: ExampleRepository
) : ViewModel() {

    fun startWork() =
        viewModelScope.launch {
            exampleRepository.enqueueWork()
        }

}