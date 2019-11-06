package com.joaaoferreiira.celebridades.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaaoferreiira.celebridades.database.AppDatabase
import com.joaaoferreiira.celebridades.database.entity.Celebridade
import com.joaaoferreiira.celebridades.database.entity.CelebridadeEntity
import com.joaaoferreiira.celebridades.util.CelebridadesUtil
import com.joaaoferreiira.celebridades.util.FrasesUtil
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val database: AppDatabase
): ViewModel() {
    private var _onCelebridadesCarregadas = MutableLiveData<List<Celebridade>>()
    var onCelebridadesCarregadas: LiveData<List<Celebridade>> = _onCelebridadesCarregadas

    fun gerarCelebridadesForDB() {
        viewModelScope.launch {
            val celebridades = CelebridadesUtil.getCelebridades()

            celebridades.forEach { database.celebridadeDao().salvarCelebridade(it) }

            val frases = FrasesUtil.getFrases()

            frases.forEach { database.fraseDao().salvarFrase(it) }

            carregarCelebridadesFromDB()
        }
    }

    fun carregarCelebridadesFromDB() {
        viewModelScope.launch {
            val celebridades = database.celebridadeWithFrasesDao().getCelebridadeComFrases()
            _onCelebridadesCarregadas.value = celebridades.sortedBy { celeb -> celeb.celebridade?.nome }
        }
    }
}