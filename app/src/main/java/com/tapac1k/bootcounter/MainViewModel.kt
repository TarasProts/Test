package com.tapac1k.bootcounter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val databaseRepository: DatabaseRepository
): ViewModel() {
    val bootText = databaseRepository.subscribeBoots().map {
        if (it.isEmpty()) return@map null
        else it.joinToString("\n") { "${it.id} - ${it.time}" }
    }.asLiveData()

}