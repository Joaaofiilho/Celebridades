package com.joaaoferreiira.celebridades.viewmodel

import androidx.lifecycle.ViewModel
import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.joaaoferreiira.celebridades.database.AppDatabase


class MainActivityViewModelFactory(private var database: AppDatabase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(database) as T
    }
}