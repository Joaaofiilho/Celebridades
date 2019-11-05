package com.joaaoferreiira.celebridades.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaaoferreiira.celebridades.database.AppDatabase
import com.joaaoferreiira.celebridades.database.entity.Celebridade
import com.joaaoferreiira.celebridades.database.entity.CelebridadeEntity
import kotlinx.coroutines.launch

class CelebridadeViewModel(private val database: AppDatabase): ViewModel() {

    private val _celebridade = MutableLiveData<Celebridade>()
    val celebridade: LiveData<Celebridade> = _celebridade

    fun getCelebridade(id: Int) {
        viewModelScope.launch {
            val celebridade = database.celebridadeWithFrasesDao().getCelebridadeComFrase(id)
            _celebridade.postValue(celebridade)
        }
    }
}