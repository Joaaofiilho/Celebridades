package com.joaaoferreiira.celebridades.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joaaoferreiira.celebridades.database.AppDatabase

class CelebridadeViewModelFactory(private var database: AppDatabase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CelebridadeViewModel(database) as T
    }
}